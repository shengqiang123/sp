package com.topscit.springboot1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

//extends SpringBootServletInitializer
@SpringBootApplication
@MapperScan("com.topscit.springboot1.dao")
public class Appllication {
	
	public static void main(String[] args) {
		SpringApplication.run(Appllication.class, args);
	}
	
	//需要打包为war才需要这个配置
//	@Override
//	protected SpringApplicationBuilder configure(
//			SpringApplicationBuilder builder) {
//		return builder.sources(Appllication.class);
//	}
	
}
