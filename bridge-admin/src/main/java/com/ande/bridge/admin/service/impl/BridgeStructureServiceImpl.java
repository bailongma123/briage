/**
 * 
 */
package com.ande.bridge.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ande.bridge.admin.dao.BridgeStructureMapper;
import com.ande.bridge.admin.model.BridgeStructureEntity;
import com.ande.bridge.admin.service.BridgeStructureService;
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
public class BridgeStructureServiceImpl extends BaseServiceImpl<BridgeStructureEntity> implements BridgeStructureService {

	@Resource
	private BridgeStructureMapper bridgeStructureMapper;
	
	@Override
	protected IBaseDao<BridgeStructureEntity> getMapper() {
		return bridgeStructureMapper;
	}

	@Override
	@Transactional
	public void InsertListEntity(List<BridgeStructureEntity> entityList) {
		bridgeStructureMapper.insertListEntity(entityList);
		
	}

}
