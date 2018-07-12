package com.ande.bridge.kafka.config;
/**
2018年5月25日上午9:46:40
@author chengzb
消息队列 topic 全局变量
 **/
public enum TopicCode {
	ACCELERATION("acceleration");
private String msg;
private TopicCode(String msg) {
	this.msg = msg;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}

}
