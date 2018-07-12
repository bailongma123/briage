/**
 * 
 */
package com.ande.bridge.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ande.bridge.admin.dao.BridgeMainMapper;
import com.ande.bridge.admin.model.BridgeMainEntity;
import com.ande.bridge.admin.service.BridgeMainService;
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
public class BridgeMainServiceImpl extends BaseServiceImpl<BridgeMainEntity> implements BridgeMainService {

	@Resource
	private BridgeMainMapper bridgeMainMapper;
	
	@Override
	protected IBaseDao<BridgeMainEntity> getMapper() {
		return bridgeMainMapper;
	}

	@Override
	@Transactional
	public void InsertListEntity(List<BridgeMainEntity> entityList) {
		bridgeMainMapper.insertListEntity(entityList);
		
	}


	@Override
	public Integer selectIDByCode(String bridgeCode) {
		return bridgeMainMapper.selectIDByCode(bridgeCode);
	}

}
