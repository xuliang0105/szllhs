package com.yzjk.system.disease.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzjk.common.conf.LucenePath;
import com.yzjk.common.lucene.LuceneOperator;
import com.yzjk.common.util.IdUtil;
import com.yzjk.common.util.RestResp;
import com.yzjk.system.disease.entity.DiseaseInfo;
import com.yzjk.system.disease.service.DiseaseInfoService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/diseaseinfo")
public class DiseaseInfoController {
	
	@Autowired LucenePath lucenePath;
	private final DiseaseInfoService diseaseInfoService;
	
  	/**
   	* 新增记录
   	* @param diseaseInfo
   	* @return R
   	*/
  	@RequestMapping("/saveDisease")
	@ResponseBody
  	public  RestResp saveDisease(DiseaseInfo diseaseInfo){
  		try {
  			diseaseInfo.setDiseaseId(IdUtil.generateId());
  			diseaseInfo.setCreateTime(new Date());
  	  		boolean bool = diseaseInfoService.save(diseaseInfo);
  	  		if(bool) {
  	  			//新增索引
  	  			LuceneOperator.operatorDiseaseInfo(diseaseInfo, 1, lucenePath.diseaseIndex);
  	  		}
  		}catch (Exception e) {
  			log.info("疾病信息保存失败!saveDisease{}");
  			RestResp.ok("疾病信息保存失败!");
		}
  		return  RestResp.ok("疾病信息保存成功!");
  	}

  	/**
   	* 修改记录
   	* @param diseaseInfo
   	* @return R
   	*/
  	@RequestMapping("/updateDisease")
  	@ResponseBody
  	public RestResp updateDisease(DiseaseInfo diseaseInfo){
  		try {
  	  		boolean bool = diseaseInfoService.updateById(diseaseInfo);
  	  		if(bool) {
  	  			//修改索引
  	  			LuceneOperator.operatorDiseaseInfo(diseaseInfo, 2, lucenePath.diseaseIndex);
  	  		}
  		}catch (Exception e) {
  			RestResp.ok("修改信息保存失败!");
		}
  		return  RestResp.ok("疾病信息修改成功!");
  	}

  	
  	/**
   	* 通过id删除一条记录
   	* @param diseaseId
   	* @return R
   	*/
	@RequestMapping("/{diseaseId}")
  	@ResponseBody
  	public RestResp deleteDisease(@PathVariable Long diseaseId){
		try {
  	  		boolean bool = diseaseInfoService.removeById(diseaseId);
  	  		if(bool) {
  	  			//删除索引
	  	  		DiseaseInfo diseaseInfo = new DiseaseInfo();
				diseaseInfo.setDiseaseId(diseaseId);
  	  			LuceneOperator.operatorDiseaseInfo(diseaseInfo, 3, lucenePath.diseaseIndex);
  	  		}
  		}catch (Exception e) {
  			RestResp.ok("删除信息保存失败!");
		}
  		return  RestResp.ok("疾病信息删除成功!");
  	}

	
}
