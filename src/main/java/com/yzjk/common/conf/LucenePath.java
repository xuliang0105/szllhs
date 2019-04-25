package com.yzjk.common.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.Data;

@Order(1)
@Data
@Component
@ConfigurationProperties
public class LucenePath {
	@Value("${lucene.diseaseIndex}")
	public  String diseaseIndex;
	
	@Value("${lucene.packageIndex}")
	public  String packageIndex;
}
