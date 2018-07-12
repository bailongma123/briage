package com.ande.bridge.admin.dao;

import com.ande.bridge.admin.model.BridgeBaseEntity;
import com.ande.bridge.common.dao.IBaseDao;

/**
 * @author tingzhanGuo@la-inc.cn
 * @date 2018年5月25日---下午4:47:58
 * @Description 桥梁基础信息dao
 */
public interface BridgeBaseMapper extends IBaseDao<BridgeBaseEntity> {
	public void insert(BridgeBaseEntity entity);
}