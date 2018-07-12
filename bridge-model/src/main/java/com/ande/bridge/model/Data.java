package com.ande.bridge.model;


/**
2018年5月23日上午10:01:44
@author chengzb
数据模型
 **/
public class Data {
private String code;//设备code码 (传感器上报数据 必传)
private String type;//传感器类型 (传感器上报数据 必传)
private String equipmentId;//设备id
private String bridgeId;//桥梁id
private String msgId;//消息id
public String getMsgId() {
	return msgId;
}
public void setMsgId(String msgId) {
	this.msgId = msgId;
}
public String getEquipmentId() {
	return equipmentId;
}
public void setEquipmentId(String equipmentId) {
	this.equipmentId = equipmentId;
}
public String getBridgeId() {
	return bridgeId;
}
public void setBridgeId(String bridgeId) {
	this.bridgeId = bridgeId;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}

}
