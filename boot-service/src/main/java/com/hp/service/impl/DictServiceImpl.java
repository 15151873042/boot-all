package com.hp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.base.mapper.DictMapper;
import com.hp.base.model.Dict;
import com.hp.base.qo.BaseQO;
import com.hp.service.DictService;
@Service("dictService")
public class DictServiceImpl implements DictService {
	
	@Autowired
	private DictMapper dictMapper;
	
	@Override
	public List<Dict> getAllDictList() {
		List<Dict> allDictList = dictMapper.getAllDictList();
		return allDictList;
	}
	
	

	@Override
	public void updateIncreVersion() {
		Dict dict = new Dict();
		dict.setId("app0000000000000101");
		dictMapper.updateIncreVersion(dict);
	}

	@Override
	public void asycnTest() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public Object getListPage() {
		BaseQO qo = new BaseQO();
		List<Dict> list = dictMapper.getListPage(qo);
		return list;
	}


	
}
