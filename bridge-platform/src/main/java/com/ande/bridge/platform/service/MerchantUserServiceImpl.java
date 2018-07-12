package com.ande.bridge.platform.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ande.bridge.common.dao.BaseServiceImpl;
import com.ande.bridge.common.dao.IBaseDao;
import com.ande.bridge.platform.dao.MerchantUserMapper;
import com.ande.bridge.platform.entity.MerchantUser;
@Service
public class MerchantUserServiceImpl extends BaseServiceImpl<MerchantUser>
		implements IMerchantUserService {
	@Resource
	private MerchantUserMapper merchantUserMapper;
	@Override
	protected IBaseDao<MerchantUser> getMapper() {
		return merchantUserMapper;
	}
	@Override
	public MerchantUser login(String userName, String password) {
		return merchantUserMapper.login(userName,password);
	}
}
