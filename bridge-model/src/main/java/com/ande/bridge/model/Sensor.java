package com.ande.bridge.model;

import java.util.HashMap;
import java.util.Map;

/**
2018年5月23日上午11:58:34
@author chengzb
传感器类型
 **/
public class Sensor {
	public static Map<String,String> map=new HashMap<String,String>();
	static{
		map.put("1","acceleration3");//key--接口接入层传入的type参数  value--topic名称
		//map.put("2","test"); 新增传感器类型时需要加一行代码
	}
}
