package com.hp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hp.bean.DataTypeDTO;
import com.hp.bean.ImportBean;
import com.hp.bean.User;
import com.hp.service.DictService;

@ServletComponentScan({"com.hp.servlet"})
@SpringBootApplication
@RestController
@Import(ImportBean.class)
public class MainApplication extends SpringBootServletInitializer implements BeanFactoryAware {
	
	private BeanFactory beanFactory;
	
	@Autowired
	private DictService dictService;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger =  LoggerFactory.getLogger(MainApplication.class);
	

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MainApplication.class);
	}
	
	
	@GetMapping("/test/db_query")
	public Object dbQuery() {
		return dictService.getAllDictList();
	}
	
	
	@RequestMapping("/test/data_type")
	public DataTypeDTO dataType(@RequestBody DataTypeDTO dto) {
		DataTypeDTO result = new DataTypeDTO();
		result.setName("胡鹏");
		result.setAge(30);
		result.setIsDeleted(false);
		result.setAmount(new BigDecimal("123.456"));
		result.setBirthday(new Date());
		return dto;
	}
	
	
	@GetMapping("/test/autowire_by_type")
	public User testAutowireByType() {
		User user = beanFactory.getBean(User.class);
		return user;
	}
	
	@GetMapping("/incr")
	public void versionIncr() {
		dictService.updateIncreVersion();
	}
	
	
	@GetMapping("/redis")
	public void redisSetTest() {
		 Map<String, String> map = new HashMap<>();
		 map.put("姓名2", "张三2");
		 redisTemplate.opsForHash().putAll("hash", map);
	}
	
	@GetMapping("/async")
	public void asyncTest() {
		dictService.asycnTest();
	}
	
	@Scheduled(cron = "0 0/10 * * * ? ")
	public void scheduledTest() {
		System.out.println("我每10分钟执行一次");
	}
	
	
	@GetMapping("/restTemlate")
	public Object restTemplateTest() throws JsonProcessingException {
		return restTemplate.getForEntity("https://aiapp.17got.com/free/init/initialize", Object.class).getBody();
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

}
