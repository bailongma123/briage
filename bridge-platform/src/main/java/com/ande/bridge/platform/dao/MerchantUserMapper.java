package com.ande.bridge.platform.dao;

import com.ande.bridge.common.dao.IBaseDao;
import com.ande.bridge.platform.entity.MerchantUser;

public interface MerchantUserMapper extends IBaseDao<MerchantUser>{
	MerchantUser login(String userName, String password);
}