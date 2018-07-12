package com.ande.bridge.middle;

import javax.annotation.Resource;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.ande.bridge.common.JsonUtil;
import com.ande.bridge.hbase.config.HbaseUtil;
import com.ande.bridge.model.DataAcceleration;

/**
2018年5月24日下午2:16:39
@author chengzb
 **/
@Component
public class KafkaConsumer {
	@Resource
	private HbaseUtil hbaseUtil;
	private int i;
	   @KafkaListener(topics = {"acceleration3"})
	    public void receive(String message){
		   System.out.println("app_log--消费消息:");
	        DataAcceleration bean = JsonUtil.toBean(message,DataAcceleration.class);
	        //bean.getBridgeId()+bean.getEquipmentId()+System.currentTimeMillis()
	        hbaseUtil.multiPutRowByRowKey("demo",bean.getMsgId(),"info",new String[]{"v"}, new String[]{String.valueOf(bean.getValue())});
	        System.out.println("app_log--消费消息:" + message+"----"+i++);
	   }
}
