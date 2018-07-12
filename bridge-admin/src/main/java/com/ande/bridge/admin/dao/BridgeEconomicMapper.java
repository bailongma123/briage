package com.ande.bridge.admin.dao;

import java.util.List;

import com.ande.bridge.admin.model.BridgeEconomicEntity;
import com.ande.bridge.common.dao.IBaseDao;
/**
 * @author tingzhanGuo@la-inc.cn 
 * @date 2018年5月25日---下午4:48:44
 * @Description	桥梁经济信息dao
 */
public interface BridgeEconomicMapper extends IBaseDao<BridgeEconomicEntity> {
	
	public void insertListEntity(List<BridgeEconomicEntity> entityList);
}