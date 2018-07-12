/**
 * 
 */
package com.ande.bridge.admin.service;

import java.util.List;

import com.ande.bridge.admin.model.BridgeStructureEntity;
import com.ande.bridge.common.dao.IBaseService;

/**   
 * <pre>  
 * <b> .</b>
 * <b>Author: name@la-inc.cn</b> 
 * <b>date: 2018年5月25日 下午7:08:42   </b> 
 * 
 *   ----------------------------------------------------------------------------
 *   ----------------------------------------------------------------------------
 * <pre>
 */
public interface BridgeStructureService extends IBaseService<BridgeStructureEntity> {

	public void InsertListEntity(List<BridgeStructureEntity> entityList);
}
