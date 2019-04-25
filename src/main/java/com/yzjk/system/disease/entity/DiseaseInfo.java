package com.yzjk.system.disease.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("disease_info")
public class DiseaseInfo extends Model<DiseaseInfo> {
private static final long serialVersionUID = 1L;

    /**
   * 
   */
    @TableId(type = IdType.INPUT)
    private Long diseaseId;
    /**
   * 疾病名称
   */
    private String diseaseName;
    /**
   * 疾病其它名称
   */
    private String diseaseOtherName;
    /**
   * 疾病图片
   */
    private String diseaselogo;
    /**
   * 
   */
    private String spell;
    /**
   * 传染性
   */
    private Integer infectiousness;
    /**
   * 倾向人群
   */
    private String pronePopulation;
    /**
   * 病态部分
   */
    private String diseasedPart;
    /**
   * 疾病摘要
   */
    private String diseaseSummary;
    /**
   * 疾病原因
   */
    private String diseaseCause;
    /**
   * 症状描述
   */
    private String symptomDescription;
    /**
   * 食品安全
   */
    private String foodSafe;
    /**
   * 预防
   */
    private String prevention;
    /**
   * 治疗
   */
    private String treatment;
    /**
   * 检查说明
   */
    private String examinationDescription;
    /**
   * 鉴别诊断
   */
    private String differentialDiagosis;
    /**
   * 并发症
   */
    private String complication;
    /**
   * 
   */
    private Date createTime;
  
}
