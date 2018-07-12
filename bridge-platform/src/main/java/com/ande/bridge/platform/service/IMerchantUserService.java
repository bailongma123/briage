package com.ande.bridge.platform.service;

import com.ande.bridge.common.dao.IBaseService;
import com.ande.bridge.platform.entity.MerchantUser;

public interface IMerchantUserService extends IBaseService<MerchantUser> {
public MerchantUser login(String userName,String password);
}
