package com.yzjk.common.lucene;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Paths;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.LogDocMergePolicy;
import org.apache.lucene.index.LogMergePolicy;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.SearcherFactory;
import org.apache.lucene.search.SearcherManager;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class LuceneUtil {
 

	public final static Version VERSION = Version.LUCENE_7_6_0;

	/**
	 * 初始化IndexWriter对象
	 * 
	 * @param indexFilePath
	 *            索引库路径
	 * @return
	 * @throws IOException
	 */
	public static IndexWriter getIndexWriter(String indexFilePath) throws IOException {

		// 索引库路径不存在则新建一个
		Directory directory = FSDirectory.open(Paths.get(new File(indexFilePath).getPath()));
		// 创建索引配置器
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(AnalyzerUtil.getIkAnalyzer());

		LogMergePolicy mergePolicy = new LogDocMergePolicy();

		// 索引基本配置
		// 设置segment添加文档(Document)时的合并频率
		// 值较小,建立索引的速度就较慢
		// 值较大,建立索引的速度就较快,>10适合批量建立索引
		mergePolicy.setMergeFactor(30);

		// 设置segment最大合并文档(Document)数
		// 值较小有利于追加索引的速度
		// 值较大,适合批量建立索引和更快的搜索
		mergePolicy.setMaxMergeDocs(5000);

		// 启用复合式索引文件格式,合并多个segment
		
		/*mergePolicy.setUseCompoundFile(true);
		if (IndexWriter.isLocked(directory)) {
			IndexWriter.unlock(directory);
		}*/
		 
		indexWriterConfig.setMaxBufferedDocs(10000);
		indexWriterConfig.setMergePolicy(mergePolicy);
		indexWriterConfig.setRAMBufferSizeMB(64);

		// /设置索引的打开模式 创建或者添加索引
		indexWriterConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);

		// 创建索引器
		IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
		return indexWriter;
	}
	
	
	
	/**
	 * 初始化IndexSearcher对象
	 * 
	 * @param indexPath
	 *            索引库路径
	 * @return
	 * @throws IOException
	 */
	public static IndexSearcher getIndexSearcher(String indexFilePath) throws IOException {

		//File indexFile = new File(indexFilePath);
		Directory directory = FSDirectory.open(Paths.get(new File(indexFilePath).getPath()));
		SearcherManager sm = new SearcherManager(directory, new SearcherFactory());
		return sm.acquire();
	}

	/**
	 * 设置字段值中关键词高亮显示
	 * 
	 * @param analyzer
	 *            分析器
	 * @param fieldName
	 *            字段名
	 * @param fieldValue
	 *            字段值
	 * @return 带高亮的字段值
	 * @throws IOException
	 * @throws InvalidTokenOffsetsException
	 */
	public static String getHighlighterFiled(SmartChineseAnalyzer analyzer, Query query, String fieldName, String fieldValue) throws IOException {
		 try {
			 Highlighter highlighter = settingHighter(query); 
			  TokenStream tokenStream =  analyzer.tokenStream(fieldName, new StringReader(fieldValue));
			  String  highlighterValue = highlighter.getBestFragment(tokenStream,fieldValue);
			  // 如果字段中没有找到关键词
			  if (null == highlighterValue)
				  	highlighterValue = fieldValue;
			  return highlighterValue;
		 }catch (Exception e) {
			log.info("查找关键字错误!");
		}
		return null;
	}

	/**
	 * 创建高亮器,使搜索的关键词突出显示
	 * 
	 * @param query
	 * @return
	 */
	private static Highlighter settingHighter(Query query) {
		// 高亮显示
		/*
		 * 创建高亮器,使搜索的结果高亮显示 SimpleHTMLFormatter：用来控制你要加亮的关键字的高亮方式 此类有2个构造方法
		 * 1：SimpleHTMLFormatter()默认的构造方法.加亮方式：<B>关键字</B>
		 * 2：SimpleHTMLFormatter(String preTag, String
		 * postTag).加亮方式：preTag关键字postTag
		 */
		// 以红色字体标记关键词
		SimpleHTMLFormatter formatter = new SimpleHTMLFormatter("<font style='color:red;'>", "</font>");
		// 用于高亮查询,query是Lucene的查询对象Query
		QueryScorer scorer = new QueryScorer(query);

		// 创建一个高亮器
		Highlighter highlighter = new Highlighter(formatter, scorer);

		// 设置文本摘要大小
		Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
		highlighter.setTextFragmenter(fragmenter);
		return highlighter;
	}

	

	/**
	 * 强制删除，意思就是清空回收站
	 * 
	 * @param indexFilePath
	 *            索引目录
	 * @throws IOException
	 */
	public static void forceDelete(String indexFilePath) throws IOException {
		IndexWriter indexWriter = LuceneUtil.getIndexWriter(indexFilePath);
	
		indexWriter.forceMergeDeletes();
	
		indexWriter.close();
	}

	/**
	 * 指定路径删除索引库
	 * 
	 * @param indexFilePath
	 *            索引库路径
	 * @throws IOException
	 */
	public static boolean delete(String indexFilePath) {
		IndexWriter indexWriter = null;
		try {
			indexWriter = LuceneUtil.getIndexWriter(indexFilePath);
			log.info("开始删除索引库...");
			indexWriter.deleteAll();
			log.info("成功删除索引库...");
			return true;
		} catch (IOException e) {
			log.error("删除索引库时出现异常,请及时与管理员联系.", e);
			return false;
		} finally {
			if (null != indexWriter) {
				try {
					indexWriter.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 添加一条索引
	 * @param indexFilePath
	 * @param doc
	 * @throws IOException
	 */
	public static void add(String indexFilePath, Document doc) throws IOException {
		IndexWriter indexWriter = LuceneUtil.getIndexWriter(indexFilePath);
		indexWriter.addDocument(doc);
		indexWriter.commit();
		indexWriter.close();
	}
	
	/**
	 * 根据索引库数据ID删除索引数据
	 * 
	 * @param indexFilePath
	 * @param fieldId
	 * @param fieldValue
	 * @throws IOException
	 */
	public static void deleteById(String indexFilePath, String fieldId, String fieldValue) throws IOException {
		IndexWriter indexWriter = LuceneUtil.getIndexWriter(indexFilePath);

		// 这里的参数可以是一个Query，也可以是一个term
		// 1、当参数为Query时，可以传入一个Query对象，它会根据你传入的query对象，把符合这个查找条件的文档都删掉，例如：如果你传入的Query是content域中，包含字母‘a’的，那么所有包含字符‘a’的文档都会被删掉
		// 2、当传入的是一个term时，这个算是一个精确查找，它是一个‘像’，怎么理解呢，比如，下面的Term("id","1")它就是id为1的像，也就是，它会找到id为1的索引文档
		// 需要注意的一点是，这个删除并不是真正的删除，它会把这个文档放到回收站里
		indexWriter.deleteDocuments(new Term(fieldId, fieldValue));

		// rollback()函数，当indexWriter没有commit之前，它是可以回滚回之前没有修改的状态，
		indexWriter.commit();
		// 清空回收站
		// indexWriter.forceMergeDeletes();
		// indexWriter不提交或者不关闭，它所进行的修改时不会起效的
		indexWriter.close();

	}

}