/**
 * 
 */
package com.ande.bridge.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ande.bridge.admin.dao.BridgeEconomicMapper;
import com.ande.bridge.admin.model.BridgeEconomicEntity;
import com.ande.bridge.admin.service.BridgeEconomicService;
import com.ande.bridge.common.dao.BaseServiceImpl;
import com.ande.bridge.common.dao.IBaseDao;

/**   
 * <pre>  
 * <b> .</b>
 * <b>Author: name@la-inc.cn</b> 
 * <b>date: 2018年5月25日 下午7:11:09   </b> 
 * 
 *   ----------------------------------------------------------------------------
 *   ----------------------------------------------------------------------------
 * <pre>
 */
@Service
public class BridgeEconomicServiceImpl extends BaseServiceImpl<BridgeEconomicEntity> implements BridgeEconomicService {

	@Resource
	private BridgeEconomicMapper bridgeEconomicMapper;
	
	@Override
	protected IBaseDao<BridgeEconomicEntity> getMapper() {
		return bridgeEconomicMapper;
	}

	@Override
	@Transactional
	public void InsertListEntity(List<BridgeEconomicEntity> entityList) {
		bridgeEconomicMapper.insertListEntity(entityList);
		
	}

}
