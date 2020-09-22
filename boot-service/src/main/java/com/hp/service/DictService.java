package com.hp.service;

import java.util.List;

import org.springframework.scheduling.annotation.Async;

import com.hp.base.model.Dict;

public interface DictService {

	
	/**
	 *
	 * @Descripton 获取所有字典
	 * @author 胡鹏
	 * @date 2020年8月12日 下午6:02:02
	 * @return
	 */
	List<Dict> getAllDictList();
	
	/**
	 *
	 * @Descripton 版本号自增1
	 * @author 胡鹏
	 * @date 2020年7月6日 下午9:58:52
	 */
	void updateIncreVersion();
	
	@Async
	void asycnTest();

	Object getListPage();
}
