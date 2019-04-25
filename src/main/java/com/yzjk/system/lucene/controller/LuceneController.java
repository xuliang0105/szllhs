package com.yzjk.system.lucene.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopDocs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yzjk.common.conf.LucenePath;
import com.yzjk.common.lucene.AnalyzerUtil;
import com.yzjk.common.lucene.LuceneCreate;
import com.yzjk.common.lucene.LuceneOperator;
import com.yzjk.common.lucene.LuceneUtil;
import com.yzjk.common.lucene.MyQuery;
import com.yzjk.common.lucene.MyTopDocs;
import com.yzjk.common.util.Page;
import com.yzjk.common.util.RestResp;
import com.yzjk.system.disease.entity.DiseaseInfo;
import com.yzjk.system.disease.service.DiseaseInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/lucene")
public class LuceneController {
	@Autowired LucenePath lucenePath;
	@Autowired DiseaseInfoService diseaseInfoService;
	
	/**
	 * 创建疾病信息索引
	 * 
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/initDiseaseIndex")
	@ResponseBody
	public RestResp initDiseaseIndex(Model model) throws IOException {
		//先删除索引
		LuceneUtil.delete(lucenePath.diseaseIndex);
		try {
			boolean bool = false;
			List<Object> diseaseInfoList = null;
			diseaseInfoList =(List) diseaseInfoService.list();
			bool = LuceneCreate.createIndex(lucenePath.diseaseIndex,diseaseInfoList,"disease");
		} catch (Exception e) {
			log.info("创建疾病信息索引失败 initDiseaseIndex{}");
			return  RestResp.error(RestResp.ERROR, "创建疾病信息索引失败");
			
		}
		return RestResp.ok("创建疾病信息索引成功!");
	}
	

	/**
	 * 疾病索引操作
	 * @param info
	 * @param type
	 * @return
	 */
	@RequestMapping("/operatorDiseaseInfo")
	@ResponseBody
	public boolean operatorDiseaseInfo(DiseaseInfo info,int type) {
		return LuceneOperator.operatorDiseaseInfo(info, type, lucenePath.diseaseIndex);
	}
	
	
	/**
	 * 根据关键字查找疾病索引内容
	 * @param keywords
	 * @param page
	 * @return
	 */
	@RequestMapping("/searchDiseaseInfoByKeyWords")
	@ResponseBody
	public  List<DiseaseInfo>  searchDiseaseInfoByKeyWords(String keywords, Page page){
		List<DiseaseInfo> dislist = null;
		try {
			IndexSearcher indexSearcher  = LuceneUtil.getIndexSearcher(lucenePath.diseaseIndex);
			SmartChineseAnalyzer analyzer = AnalyzerUtil.getIkAnalyzer();
			Query query = MyQuery.getByQuery(keywords, analyzer, "disease");
			//字段排序
			Sort sorts = new Sort();
			sorts.setSort(new SortField[] {new SortField("createTime", SortField.Type.LONG, true) });
			TopDocs hits = MyTopDocs.getTopDocs(indexSearcher, page, query,sorts);
			indexSearcher.search(query, 1);
			
			 if(hits.totalHits ==0) {
				 log.info("非常抱歉，没有找到疾病记录。");
				 return null;
			 }
			 
			 dislist = new ArrayList<DiseaseInfo>();
			 DiseaseInfo dInfo = null; 
			 
			 for (ScoreDoc scoreDoc: hits.scoreDocs){
				dInfo = new DiseaseInfo();
				Document doc = indexSearcher.doc(scoreDoc.doc);
				dInfo.setDiseaseId(Long.parseLong(String.valueOf(doc.get("diseaseId"))));
				// 疾病名称
				String diseaseName = doc.get("diseaseName").toString();
				if (StringUtils.isNotEmpty(diseaseName)) {
					diseaseName = LuceneUtil.getHighlighterFiled(analyzer, query, "diseaseName", diseaseName);
					dInfo.setDiseaseName(diseaseName);
				}
				//别名
				String diseaseOtherName = doc.get("diseaseOtherName").toString();
				if (StringUtils.isNotEmpty(diseaseOtherName)) {
					diseaseOtherName = LuceneUtil.getHighlighterFiled(analyzer, query, "diseaseOtherName", diseaseOtherName);
					dInfo.setDiseaseOtherName(diseaseOtherName);
				}
				
				dInfo.setPronePopulation(doc.get("pronePopulation").toString());
				dInfo.setDiseasedPart(doc.get("diseasedPart").toString());
				
				//概括
				String diseaseSummary = doc.get("diseaseSummary").toString();
				if(StringUtils.isNotEmpty(diseaseSummary)) {
					diseaseSummary = LuceneUtil.getHighlighterFiled(analyzer, query, "diseaseSummary", diseaseSummary);
					dInfo.setDiseaseSummary(diseaseSummary);
				}
				
				// 疾病原因
				String diseaseCause = doc.get("diseaseCause").toString();
				if (StringUtils.isNotEmpty(diseaseCause)) {
					diseaseCause = LuceneUtil.getHighlighterFiled(analyzer, query, "diseaseCause", diseaseCause);
					dInfo.setDiseaseCause(diseaseCause);
				}
				dInfo.setSymptomDescription(doc.get("symptomDescription").toString());
				dInfo.setPrevention(doc.get("prevention").toString());
				dInfo.setTreatment(doc.get("treatment").toString());
				dInfo.setExaminationDescription(doc.get("examinationDescription").toString());
				dInfo.setDifferentialDiagosis(doc.get("differentialDiagosis").toString());
				dInfo.setComplication(doc.get("complication").toString());
				dInfo.setCreateTime(new Date(Long.parseLong(doc.get("createTimeStr").toString())));
				dislist.add(dInfo);
			 }
		}catch (Exception e) {
			e.printStackTrace();
			log.info("查找疾病索引异常"+e);
		}
		return dislist;
	}
	
	
}
