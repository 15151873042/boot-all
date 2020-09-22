package com.hp.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServleltConfig {
	
	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> myServletContextListener() {
		MyServletContextListener myServletContextListener = new MyServletContextListener();
		ServletListenerRegistrationBean<ServletContextListener> servletListenerRegistrationBean = 
				new ServletListenerRegistrationBean<>(myServletContextListener);
		return servletListenerRegistrationBean;
		
	}
	
	public static class MyServletContextListener implements ServletContextListener {
		
		@Override
		public void contextInitialized(ServletContextEvent sce) {
//			System.out.println("MyServletContextListener初始化");
		}
		
	}

}
