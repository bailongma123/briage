/**
 * 
 */
package com.ande.bridge.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ande.bridge.admin.dao.BridgeBaseMapper;
import com.ande.bridge.admin.model.BridgeBaseEntity;
import com.ande.bridge.admin.service.BridgeBaseService;
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
public class BridgeBaseServiceImpl extends BaseServiceImpl<BridgeBaseEntity> implements BridgeBaseService {

	@Resource
	private BridgeBaseMapper bridgeBaseMapper;
	
	@Override
	protected IBaseDao<BridgeBaseEntity> getMapper() {
		return bridgeBaseMapper;
	}

	@Override
	@Transactional
	public void insertBaseEntity(BridgeBaseEntity entity) {
		bridgeBaseMapper.insert(entity);
	}


}
