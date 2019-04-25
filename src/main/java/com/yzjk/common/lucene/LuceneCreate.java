package com.yzjk.common.lucene;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.NumericDocValuesField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;

import com.yzjk.system.disease.entity.DiseaseInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LuceneCreate {
	

	public static boolean createIndex(String path,List<Object> list,String type) throws IOException {
		log.info("开始创建索引......");
		IndexWriter indexWriter = null;
		try {
			indexWriter= LuceneUtil.getIndexWriter(path);
			switch (type) {
				case "disease":
					createDiseaseIndex(list,indexWriter);
					break;
				case "package":
					//createDiseaseIndex(list,indexWriter);
					break;	
				default:
					break;
			}
	        indexWriter.commit();
		} catch (IOException e) {
			log.info("创建索引库出现异常。", e);
			return false;
		} finally {
			if (null != indexWriter)
				try {
					indexWriter.close();
				} catch (IOException e) {
					log.error("创建索引库关闭IndexWriter对象出现异常。", e);
					return false;
				}
		}
		log.info("创建索引库已完成。");
		return true;
	}
	
	
	/**
	 * 创建疾病信息索引库
	 * 
	 * @param list
	 *            疾病信息集合
	 * @throws IOException
	 */
	private static void createDiseaseIndex(List<Object> list, IndexWriter indexWriter) throws IOException {
		Document doc = null;
		// 写入索引
		for(Object obj : list) {
			doc = LuceneCreate.createDiseaseDoc((DiseaseInfo) obj);
			indexWriter.addDocument(doc);
		}
	}

	/**
	 * 转换疾病信息为Document对象
	 * 
	 * @param map
	 *            疾病信息
	 * @return Document
	 */
	public static Document createDiseaseDoc(DiseaseInfo disInfo) {
		Document doc = new Document();
		doc.add(new StringField("diseaseId", String.valueOf(disInfo.getDiseaseId()), Store.YES));
		doc.add(new TextField("diseaseName", String.valueOf(disInfo.getDiseaseName()), Store.YES));
		doc.add(new TextField("diseaseOtherName",String.valueOf(disInfo.getDiseaseOtherName()), Store.YES));
		doc.add(new TextField("pronePopulation",String.valueOf(disInfo.getPronePopulation()), Store.YES));
		doc.add(new TextField("diseasedPart",String.valueOf(disInfo.getDiseasedPart()), Store.YES));
		doc.add(new TextField("diseaseSummary", String.valueOf(disInfo.getDiseaseSummary()), Store.YES));
		doc.add(new TextField("diseaseCause", String.valueOf(disInfo.getDiseaseCause()), Store.YES));
		doc.add(new TextField("symptomDescription", String.valueOf(disInfo.getSymptomDescription()), Store.YES));
		doc.add(new TextField("prevention", String.valueOf(disInfo.getPrevention()), Store.YES));
		doc.add(new TextField("treatment", String.valueOf(disInfo.getTreatment()), Store.YES));
		doc.add(new TextField("examinationDescription", String.valueOf(disInfo.getExaminationDescription()), Store.YES));
		doc.add(new TextField("differentialDiagosis", String.valueOf(disInfo.getDifferentialDiagosis()), Store.YES));
		doc.add(new TextField("complication", String.valueOf(disInfo.getComplication()), Store.YES));
		doc.add(new TextField("createTimeStr", String.valueOf(disInfo.getCreateTime().getTime()), Store.YES));
		doc.add(new NumericDocValuesField("createTime",disInfo.getCreateTime().getTime())); 
		return doc;
	}
}
