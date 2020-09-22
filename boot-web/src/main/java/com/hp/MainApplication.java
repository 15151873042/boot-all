package com.hp;

import org.redisson.spring.session.config.EnableRedissonHttpSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import hp.boot.transaction.config.annotation.EnableTransactionCommonConfig;
import hp.boot.web.config.annotation.EnableWebMvcCommonConfig;

@SpringBootApplication
@EnableWebMvcCommonConfig
@EnableTransactionCommonConfig
@EnableRedissonHttpSession(keyPrefix = "custom:session:")
public class MainApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MainApplication.class);
	}
}
