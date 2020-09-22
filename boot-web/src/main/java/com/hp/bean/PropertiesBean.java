package com.hp.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 通过@ConfigurationProperties和@Component注解可以将配置文件中的属性转换成spring管理的bean
 * @author 胡鹏
 *
 */
@Component
@ConfigurationProperties(prefix = "author")
public class PropertiesBean {
	
	private String name;
	
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
