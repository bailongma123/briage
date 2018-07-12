/**
 * 
 */
package com.ande.bridge.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ande.bridge.admin.dao.BridgeManageMapper;
import com.ande.bridge.admin.model.BridgeManageEntity;
import com.ande.bridge.admin.service.BridgeManageService;
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
public class BridgeManageServiceImpl extends BaseServiceImpl<BridgeManageEntity> implements BridgeManageService {

	@Resource
	private BridgeManageMapper bridgeManageMapper;
	
	@Override
	protected IBaseDao<BridgeManageEntity> getMapper() {
		return bridgeManageMapper;
	}

	@Override
	@Transactional
	public void InsertListEntity(List<BridgeManageEntity> entityList) {
		bridgeManageMapper.insertListEntity(entityList);
		
	}

}
