package com.yzjk.common.lucene;

import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;

/**
 * 
 */
public class AnalyzerUtil {
	
	private static SmartChineseAnalyzer smartChineseAnalyzer;

	/**
	 * 创建IKAnalyzer分词器
	 * @return
	 */
	public static SmartChineseAnalyzer getIkAnalyzer() {
		if (smartChineseAnalyzer == null) {
			// 当为true时，分词器迚行最大词长切分 ；当为false时，分词器迚行最细粒度切
			smartChineseAnalyzer = new SmartChineseAnalyzer(true);
		}
		return smartChineseAnalyzer;
	}
}
