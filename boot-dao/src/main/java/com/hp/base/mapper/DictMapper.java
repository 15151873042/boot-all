package com.hp.base.mapper;


import java.util.List;

import com.hp.base.model.Dict;
import com.hp.base.qo.BaseQO;

public interface DictMapper {

    /**
     * 查询所有字典集合，用于缓存初始化
     * 
     * @return
     */
    List<Dict> getAllDictList();
    
    /**
     *
     * @Descripton 更新所有版本号加1
     * @author 胡鹏
     * @date 2020年7月6日 下午9:56:09
     * @return
     */
    int updateIncreVersion(Dict dict);

	/**
	 *
	 * @Descripton 分页列表查询
	 * @author 胡鹏
	 * @date 2020年8月24日 下午6:00:50
	 * @param qo
	 * @return
	 */
	List<Dict> getListPage(BaseQO qo);

    
}