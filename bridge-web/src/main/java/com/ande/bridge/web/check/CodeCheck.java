package com.ande.bridge.web.check;

import org.springframework.stereotype.Service;

import com.ande.bridge.model.Data;

/**
2018年5月23日上午10:29:59
@author chengzb
code码校验
 **/
@Service
public class CodeCheck implements Check{
	@Override
	public Data check(String code) {
		Data data=new Data();
		//此处暂写死 后期 通过code码去数据库查询
		data.setBridgeId("0000001");
		data.setEquipmentId("000000001");
		return data;
	}
}
