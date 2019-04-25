package com.yzjk.common.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix="file")
public class FileUploadPath {
	   private String locationfileDir;
}
