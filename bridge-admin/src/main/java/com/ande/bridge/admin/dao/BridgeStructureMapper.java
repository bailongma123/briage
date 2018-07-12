package com.ande.bridge.admin.dao;

import java.util.List;

import com.ande.bridge.admin.model.BridgeStructureEntity;
import com.ande.bridge.common.dao.IBaseDao;

/**
 * @author tingzhanGuo@la-inc.cn
 * @date 2018年5月25日---下午4:50:13
 * @Description 桥梁结构信息dao
 */
public interface BridgeStructureMapper extends IBaseDao<BridgeStructureEntity> {
	public void insertListEntity(List<BridgeStructureEntity> entityList);
}