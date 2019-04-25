package com.yzjk.common.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyQuery {
 

	/**
	 * 根据关键字获取Query
	 * 
	 * @param keywords
	 *            关键字
	 * @param analyzer
	 *            分词器
	 * @param fiedsIndex
	 * @return
	 */
	public static Query getByQuery(String keywords, Analyzer analyzer, String indexMark) {
		Query query = null;
		try {
			if (StringUtils.isNotEmpty(keywords)) {
				String[] fields = null;
				switch (indexMark) {
				case "disease":
					fields = new String[] { "diseaseName", "diseaseOtherName","diseaseCause","diseaseSummary",
							"symptomDescription","prevention", "treatment", "examinationDescription", "differentialDiagosis" };
					break;
				default:
					break;
				}
				BooleanClause.Occur[] clauses = new BooleanClause.Occur[fields.length];
				for (int i = 0; i < fields.length; i++) {
					clauses[i] = BooleanClause.Occur.SHOULD;
				}
				//使用MultiFieldQueryParser实现多域检索  
				query = new MultiFieldQueryParser(fields, analyzer).parse(QueryParser.escape(keywords));
			} else {
				query = new MatchAllDocsQuery();
			}
		} catch (ParseException e) {
			log.error("执行MyQuery.getByQuery(String keywords, Analyzer analyzer, int flag)...时出现异常", e);
		}
		return query;
	}
}
