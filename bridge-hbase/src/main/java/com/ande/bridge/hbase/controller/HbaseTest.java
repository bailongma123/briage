package com.ande.bridge.hbase.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ande.bridge.hbase.config.HbaseUtil;

//@RestController
//@RequestMapping("/hbase")
public class HbaseTest {
@Resource
private HbaseUtil h;
@SuppressWarnings("deprecation")
@RequestMapping("/test")
public void test(){
	/*for(KeyValue v:h.getRowByRowKey("demo","1").getColumn(Bytes.toBytes("info"),Bytes.toBytes("service"))){
		System.out.println(v.getKeyString()+"---"+Bytes.toString(v.getValue()));
	}*/
	h.multiPutRowByRowKey("demo","2","info",new String[]{"name","age"}, new String[]{"cheng","28"});
	/*Result rowByRowKey = h.getRowByRowKey("demo","3");
	for(KeyValue v:rowByRowKey.getColumn(Bytes.toBytes("info"),Bytes.toBytes("name"))){
		System.out.println(v.getKeyString()+"---"+Bytes.toString(v.getValue()));
	}
	for(KeyValue v:rowByRowKey.getColumn(Bytes.toBytes("info"),Bytes.toBytes("age"))){
		System.out.println(v.getKeyString()+"---"+Bytes.toString(v.getValue()));
	}*/
}

}
