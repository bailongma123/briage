package com.ande.bridge.admin.dao;

import java.util.List;

import com.ande.bridge.admin.model.BridgeMainEntity;
import com.ande.bridge.common.dao.IBaseDao;

/**
 * @author tingzhanGuo@la-inc.cn
 * @date 2018年5月25日---下午4:49:12
 * @Description 桥梁主表信息dao
 */
public interface BridgeMainMapper extends IBaseDao<BridgeMainEntity> {
	public void insertListEntity(List<BridgeMainEntity> entityList);

	public Integer selectIDByCode(String bridgeCode);
}