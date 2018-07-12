package com.ande.bridge.model;


/**
2018年5月23日上午10:15:26
@author chengzb
加速度数据模型
 **/
public class DataAcceleration extends Data{
private double value;//值
/*private static class SingletonHolder {  
    private static final DataAcceleration INSTANCE = new DataAcceleration();  
}
public static final DataAcceleration getInstance() {  
    return SingletonHolder.INSTANCE;  
   }  */
public double getValue() {
	return value;
}
public void setValue(double value) {
	this.value = value;
}
}
