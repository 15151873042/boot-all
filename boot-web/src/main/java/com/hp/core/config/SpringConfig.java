package com.hp.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ServletComponentScan({"com.hp.servlet"}) // @WebFilter， @WebListener注解扫描
@MapperScan({"com.hp.**.mapper"})	// Mybatis mapper路劲扫描
@EnableAsync	// 开启异步
@EnableScheduling	// 开启定时任务
public class SpringConfig {
	
	

}
