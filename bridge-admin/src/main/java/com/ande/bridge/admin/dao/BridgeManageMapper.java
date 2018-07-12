package com.ande.bridge.admin.dao;

import java.util.List;

import com.ande.bridge.admin.model.BridgeManageEntity;
import com.ande.bridge.common.dao.IBaseDao;

/**
 * @author tingzhanGuo@la-inc.cn
 * @date 2018年5月25日---下午4:49:48
 * @Description 桥梁管理信息dao
 */
public interface BridgeManageMapper extends IBaseDao<BridgeManageEntity> {
	public void insertListEntity(List<BridgeManageEntity> entityList);
}