package com.hp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.got.common.core.vo.JsonResult;
import com.hp.bean.DataTypeDTO;
import com.hp.service.DictService;

import hp.boot.web.client.RestClient;

@RestController
@RequestMapping("/test")
public class TestController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DictService dictService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	


	
	@GetMapping("/rest_temlate")
	public Object restTemplateTest() throws JsonProcessingException {
		restTemplate.getForEntity("https://aiapp.17got.com/free/init/initialize", Object.class).getBody();
		return RestClient.get("https://aiapp.17got.com/free/init/initialize", new ParameterizedTypeReference<JsonResult>() {});
	}
	
	
	@GetMapping("/db_query")
	public Object dbQuery() {
		return dictService.getAllDictList();
	}
	
	@GetMapping("/list_page")
	public Object dblistPage() {
		return dictService.getListPage();
	}
	
	
	@RequestMapping("/data_type")
	public DataTypeDTO dataType(@RequestBody DataTypeDTO dto) throws InterruptedException {
		synchronized ("1") {
			Thread.sleep(5000);
			DataTypeDTO result = new DataTypeDTO();
			result.setName("胡鹏");
			result.setAge(30);
			result.setIsDeleted(false);
			result.setAmount(new BigDecimal("123.456"));
			result.setBirthday(new Date());
			return dto;
		}

	}
	
	@RequestMapping("/log")
	public Object testLog() {
		logger.info("====日志输出====");
		return new JsonResult();
	}
	
	
	@RequestMapping("/session")
	public JsonResult testSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("key", "value");
		String sessionId = session.getId();
		return new JsonResult(sessionId);
	}
	
	
//	/**
//	 * @see com.hp.processor.MyBeanDefinitionRegistryPostProcessor
//	 * */
//	@GetMapping("/autowire_by_type")
//	public User testAutowireByType() {
//		User user = beanFactory.getBean(User.class);
//		return user;
//	}
	
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

}
