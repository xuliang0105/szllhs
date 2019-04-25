package com.yzjk.common.lucene;

import java.io.IOException;

import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TopFieldCollector;

import com.yzjk.common.util.Page;

public class MyTopDocs {

	/**
	 * 索引分页
	 * 
	 * @param searcher
	 *            IndexSearcher对象
	 * @param page
	 *            分页对象
	 * @param query
	 *            自定义Query
	 * @param fieldMap
	 *            检索条件参数集合
	 * @param sortStr
	 *            排序
	 * @return
	 * @throws IOException
	 */
	public static TopDocs getTopDocs(IndexSearcher searcher, Page page, Query query, Sort sorts) throws IOException {

		int start = (page.getNum() - 1) * page.getLimit();  
		int hm = start + page.getLimit();
		
		TopFieldCollector tfc = TopFieldCollector.create(sorts, hm, false, true, true, true); 
		searcher.search(query, tfc);
		
		page.initCountAndSum(tfc.getTotalHits());
		TopDocs  hits = tfc.topDocs(start, page.getLimit());
		return hits;
	}

}
