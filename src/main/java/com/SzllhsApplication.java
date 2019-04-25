package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@EnableCaching  //开启缓存
@ComponentScan(basePackages={"com.yzjk"})
public class SzllhsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SzllhsApplication.class, args);
	}

}
