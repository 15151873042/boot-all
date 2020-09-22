package com.hp.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;

import com.hp.bean.User;

/**
 * 自定义BeanDefinitionRegistryPostProcessor,
 * 1、向容器中注册一个BeanDefinition，
 * 2、并设置autowireMode为AbstractBeanDefinition.AUTOWIRE_BY_TYPE，
 * 3、populateBean的时候会获取类中带有set方法的属性，取容器中找是否有对应的bean对象，并注入到对象中
 * @see AbstractAutowireCapableBeanFactory#autowireByType()
 * @see AbstractAutowireCapableBeanFactory#unsatisfiedNonSimpleProperties() 获取带有set方法的属性值
 * @author 胡鹏
 *
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		RootBeanDefinition beanDefinition = new RootBeanDefinition(User.class);
		beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
		registry.registerBeanDefinition("user", beanDefinition);
	}

}
