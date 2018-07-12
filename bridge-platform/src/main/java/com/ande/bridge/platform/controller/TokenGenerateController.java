package com.ande.bridge.platform.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;






import com.ande.bridge.common.SystemCode;
import com.ande.bridge.common.JsonResponse;
import com.ande.bridge.common.MD5Util;
import com.ande.bridge.common.RedisUtil;

/**
 * 
 * @author chengzb
 * 2018-06-04
 * token生成
 */
@RestController
@RequestMapping("/token")
public class TokenGenerateController {
	private Logger log=LoggerFactory.getLogger(TokenGenerateController.class);
	private static final int RETRY_NUM=3; //重试次数
	private static final int LOCK_TIMEOUT=2;//锁超时时间 (秒为单位)
	private static final long TOKEN_PERIOD=60*60*2;//2小时
	private static final String TOKEN_PREFIX="token:";
	private static final String APPID_PREFIX="appId:";
	@Resource
	private RedisUtil redisUtil;
	@RequestMapping("/generate")
	public JsonResponse<String> generate(String appId,String appSecret){
		JsonResponse<String> json=new JsonResponse<String>();
		if(StringUtils.isEmpty(appId)||StringUtils.isEmpty(appSecret)){
			json.set(SystemCode.PARAM_NOT_RIGHT.getCode(),SystemCode.PARAM_NOT_RIGHT.getMsg());
			return json;
		}
		//验证 appId,appSecret是否存在
		String secret=(String) redisUtil.get(APPID_PREFIX+appId);
		if(StringUtils.isEmpty(secret)||!appSecret.equals(secret)){
			json.set(SystemCode.APPID_NOT_EXITS.getCode(),SystemCode.APPID_NOT_EXITS.getMsg());
			return json;
		}
		//获取token
		String token=getToken(appId, appSecret);
		if(StringUtils.isEmpty(token)){
			json.set(SystemCode.SYSTEM_EXCEPTION.getCode(),SystemCode.SYSTEM_EXCEPTION.getMsg());
		}else{
			json.set(SystemCode.SUCCESS.getCode(), SystemCode.SUCCESS.getMsg());
			json.setObj(token);
		}
		return json;
	}
	private String getToken(String appId,String appSecret) {
		String token=(String)redisUtil.get(TOKEN_PREFIX+appId);
		if(StringUtils.isEmpty(token)){
			checkDeadLockAndRelease(appId);//先检测锁是否释放
			//token 过期(默认两小时)重新获取
			if(redisUtil.setNx("nx:appId:"+appId,System.currentTimeMillis(),LOCK_TIMEOUT)){
				//分布式锁获取成功
					token=MD5Util.MD5EncodeBySalt(appId+appSecret,System.currentTimeMillis()+"");
					redisUtil.set(TOKEN_PREFIX+appId, token, TOKEN_PERIOD);
			}else{
				//没有获取到锁,直接获取token
				int i=0;
				return getToken(appId, appSecret,i);
			}
		}
		return token;
	}
	private String getToken(String appId,String appSecret,int i){
		if(i>=RETRY_NUM){
			log.error("获取token重试"+RETRY_NUM+"次后异常");
			return "";//重试指定次数后直接返回
		}
		String token=(String)redisUtil.get(TOKEN_PREFIX+appId);
		if(StringUtils.isEmpty(token)){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				log.error("获取token重试异常",e);
			}
			getToken(appId, appSecret,i++);
		}
		return token;
	}
	//检测死锁 并释放
	private void checkDeadLockAndRelease(String appId){
		Object obj=redisUtil.get("nx:appId:"+appId);
		if(obj!=null){
			long timeMillis=(long)obj;
			if(System.currentTimeMillis()-timeMillis>LOCK_TIMEOUT*1000){
				//超过2秒 说明死锁了(也就是之前的线程没有给key成功设置超时时间)
				redisUtil.remove("nx:appId:"+appId);
			}
		}
	}
}
