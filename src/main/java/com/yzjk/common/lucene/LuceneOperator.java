package com.yzjk.common.lucene;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;

import com.yzjk.system.disease.entity.DiseaseInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LuceneOperator {

	public static boolean operatorDiseaseInfo(DiseaseInfo info,int type,String path) {
		IndexWriter indexWriter = null;
		try {
			indexWriter = LuceneUtil.getIndexWriter(path);
			Term term = new Term("diseaseId", String.valueOf(info.getDiseaseId()));
			switch (type) {
				case 1:// 新增
					indexWriter.addDocument(LuceneCreate.createDiseaseDoc(info));
					break;
				case 2://修改
					indexWriter.updateDocument(term, LuceneCreate.createDiseaseDoc(info));
					break;
				case 3://删除
					indexWriter.deleteDocuments(term);
					break;
				default:
					break;
			}
				indexWriter.commit();
			return true;
		} catch (Exception e) {
			log.error("对自疾病索引库进行添加、修改、删除时出现异常。", e);
		} finally {
			if (null != indexWriter) {
				try {
					indexWriter.close();
				} catch (Exception e) {
					log.error("关闭疾病IndexWriter时出现异常。", e);
				}
			}
		}
		return false;
	}
	
	
}
