/**
 * 
 */
package com.ande.bridge.admin.service;

import java.util.List;

import com.ande.bridge.admin.model.BridgeBaseEntity;
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
public interface BridgeBaseService extends IBaseService<BridgeBaseEntity> {

	public void insertBaseEntity(BridgeBaseEntity entity);
}
