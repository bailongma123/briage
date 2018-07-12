package com.ande.bridge.platform.controller;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ande.bridge.common.JsonResponse;
import com.ande.bridge.common.SystemCode;
import com.ande.bridge.platform.entity.MerchantUser;
import com.ande.bridge.platform.service.IMerchantUserService;

/**
 * 
 * @author chengzb
 * 2018-06-11
 * 商户管理
 */
@RestController
@RequestMapping("/merchant")
public class MerchantUserController {
	private Logger log=LoggerFactory.getLogger(MerchantUserController.class);
	@Resource
	private IMerchantUserService merchantUserService;
	
	/**
	 * 商户注册
	 * @return
	 */
	@RequestMapping("/regist")
	public JsonResponse<MerchantUser> regist(MerchantUser merchantUser){
		JsonResponse<MerchantUser> result=new JsonResponse<MerchantUser>();
		try {
			merchantUser.setCreateTime(new Date());
			merchantUser.setUpdateTime(new Date());
			merchantUserService.insertSelective(merchantUser);
			result.set(SystemCode.SUCCESS.getCode(), SystemCode.SUCCESS.getMsg());
		} catch (Exception e) {
			log.error("注册商户异常",e);
		}
		return result;
	}
	/**
	 * 商户登录
	 * @return
	 */
	@RequestMapping("/login")
	public JsonResponse<MerchantUser> login(MerchantUser merchantUser,HttpServletRequest request){
		JsonResponse<MerchantUser> result=new JsonResponse<MerchantUser>();
		if(StringUtils.isEmpty(merchantUser.getUsername())||
				StringUtils.isEmpty(merchantUser.getPassword())){
			result.set(SystemCode.PARAM_NOT_RIGHT.getCode(), SystemCode.PARAM_NOT_RIGHT.getMsg());
			return result;
		}
		MerchantUser user = merchantUserService.login(merchantUser.getUsername(), merchantUser.getPassword());
		if(user!=null){
			result.set(SystemCode.SUCCESS.getCode(), SystemCode.SUCCESS.getMsg());
			result.setObj(user);
			request.getSession().setAttribute("merchantUser", user);
		}
		return result;
	}
	/**
	 * 成为开发者
	 * @return
	 */
	@RequestMapping("/becomeDeveloper")
	public JsonResponse<MerchantUser> becomeDeveloper(HttpServletRequest request){
		JsonResponse<MerchantUser> result=new JsonResponse<MerchantUser>();
		MerchantUser user=(MerchantUser) request.getSession().getAttribute("merchantUser");
		if(user==null){
			result.set(SystemCode.NO_LOGIN.getCode(), SystemCode.NO_LOGIN.getMsg());
			return result;
		}
		MerchantUser merchant=new MerchantUser();
		merchant.setMerchantUserId(user.getMerchantUserId());
		merchant.setAppId(generateId());
		merchant.setAppSecret(generateId());
		merchant.setUpdateTime(new Date());
		try {
			merchantUserService.updateByPrimaryKeySelective(merchant);
			result.set(SystemCode.SUCCESS.getCode(), SystemCode.SUCCESS.getMsg());
			result.setObj(merchant);
		} catch (Exception e) {
			log.error("申请成为开发者异常",e);
		}
		return result;
	}
	private String generateId(){
		return UUID.randomUUID().toString().replace("-","");
	}
	public static void main(String[] args) {
		short s1 = 1;s1+=1;
	}
}
