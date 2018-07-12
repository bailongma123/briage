package com.ande.bridge.common;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
/**
 * 启动读取配置文件参数的信息
 * @author Administrator
 *
 */
public class ParamsCashe {

	/** 日志记录器 */
	 private final static Logger LOGGER = Logger.getLogger(ParamsCashe.class);
	 
    /** 配置文件参数缓存数据 缓存结构为：<参数名：参数> */
    protected static Map<String, String> paramsData = new HashMap<String, String>();

    public static Object getData() {
        return paramsData;
    }

    static {
        LOGGER.info("开始缓存配置文件数据...");
        Properties prop = new Properties();
        try {
            String path = ParamsCashe.class.getClassLoader().getResource("")
                    .getPath();
            
            
            try {
            	BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(path
				        + "config.properties"),"UTF-8"));
                prop.load(bf);
                Iterator<String> iter = prop.stringPropertyNames().iterator();
                while (iter.hasNext()) {
                    String key = iter.next();
                    paramsData.put(key, prop.getProperty(key));
                }
                bf.close();
            }
            catch (IOException e) {
                LOGGER.error("加载属性列表异常", e);
            }
        }
        catch (Exception e) {
            LOGGER.error("未找到名字为<config.properties>的配置文件", e);
        }
    }

    /**
     * <pre>
     * <b> 根据key值获取缓存中的数据.</b>
     * <b>Description:</b>
     *
     * <b>Author:</b> chenqian@ujifu.com
     * <b>Date:</b> 2017年8月11日 上午11:41:29
     * @param key
     * @return
     * @return String
     * @see
     *
     * <pre>
     */
    public static String getProperty(String key) {
        return paramsData.get(key);
    }
}
