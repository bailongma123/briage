package com.ande.bridge.common;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

/**
 * <pre>
 * <b>Json格式数据处理 辅助工具.</b>
 * <b>Description:</b> 
 *    depend: fastjson-1.1.41.jar
 *            com.iyooc.common.utils-1.0.jar
 *    
 * <b>Author:</b> zhouguangyong@iyooc.cns
 * <b>Date:</b> 2014-01-01 上午10:00:01
 * <b>Copyright:</b> Copyright ©2006-2015 iyooc.cn Technology Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author              Detail
 *   ----------------------------------------------------------------------
 *   1.0   2014-01-01 10:00:01   zhouguangyong@iyooc.cn
 *         new file.
 * </pre>
 */
public abstract class JsonUtil {

	/**
	 * 空对象的的JSON字符串默认值: '{}'.
	 */
	public static final String EMPTY_JSON = "{}";

	protected static String defaultDateFormat = "yyyy-MM-dd HH:mm:ss";
	protected static SerializeConfig mapping = new SerializeConfig();
	/*
	 * QuoteFieldNames———-输出key时是否使用双引号,默认为true
	 * WriteMapNullValue——–是否输出值为null的字段,默认为false
	 * WriteNullNumberAsZero—-数值字段如果为null,输出为0,而非null
	 * WriteNullListAsEmpty—–List字段如果为null,输出为[],而非null
	 * WriteNullStringAsEmpty—字符类型字段如果为null,输出为"",而非null
	 * WriteNullBooleanAsFalse–Boolean字段如果为null,输出为false,而非null
	 */
	protected static SerializerFeature[] features = { SerializerFeature.DisableCircularReferenceDetect,
			SerializerFeature.WriteMapNullValue, SerializerFeature.SortField, SerializerFeature.WriteDateUseDateFormat,
			// SerializerFeature.WriteNullStringAsEmpty,
			SerializerFeature.WriteNullListAsEmpty };
	
	public static SerializerFeature[] featuresStringAsEmpty = { SerializerFeature.DisableCircularReferenceDetect,
		SerializerFeature.WriteMapNullValue, SerializerFeature.SortField, SerializerFeature.WriteDateUseDateFormat,
		SerializerFeature.WriteNullStringAsEmpty,
		SerializerFeature.WriteNullListAsEmpty };
	
	static {
		defaultDateFormat = "yyyy-MM-dd HH:mm:ss";
		mapping.put(Date.class, new SimpleDateFormatSerializer(defaultDateFormat));
	}

	/**
	 * 受保护的构造方法, 防止外部构建对象实例.
	 */
	protected JsonUtil() {
		super();
	}

	/**
	 * 将对象实例obj转为json格式字符串;<br/>
	 * 当null==obj时, 则返回 null.
	 * 
	 * @param obj
	 *            对象实例.
	 * @return String json格式字符串.
	 */
	public static String toJson(Object obj) {
		if (null == obj) {
			return null;
		}
		return JSONObject.toJSONString(obj);
	}
	
	public static String toJson(Object obj,SerializerFeature[] features) {
		if (null == obj) {
			return null;
		}
		return JSONObject.toJSONString(obj,features);
	}

	/**
	 * 将对象格式化为JSONObject;<br/>
	 * 当null==str或str为无效json格式字符串时, 则返回 null.
	 * 
	 * @param obj
	 *            对象
	 * @return JSONObject json封装对象实例.
	 */
	public static JSONObject toJsonObject(Object obj) {
		return JSONObject.parseObject(toJson(obj));
	}


	/**
	 * 将json格式字符串转为Javabean;<br/>
	 * 当null==str或str为无效json格式字符串时, 则返回 null.
	 *
	 * @param str
	 *            json格式字符串.
	 * @return JSONObject json封装对象实例.
	 */
	public static JSONObject toBean(String str) {
		if (!StringUtils.isBlank(str)) {
			try {
				return JSONObject.parseObject(str);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return null;
	}


	/**
	 * 将json格式字符串转为指定类型的Javabean;<br/>
	 * 当null==str或str为无效json格式字符串时, 则返回 null.
	 * 
	 * @param str
	 *            json格式字符串.
	 * @param clazz
	 *            对象的Class 类型
	 * @return T 对应Javabean实例.
	 */
	public static <T> T toBean(String str, Class<T> clazz) {
		if (!StringUtils.isBlank(str)) {
			try {
				return JSONObject.parseObject(str, clazz);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 将json格式字符串转为指定泛型的List;<br/>
	 * 当null==str或str为无效json格式字符串时, 则返回 null.
	 * 
	 * @param str
	 *            json格式字符串.
	 * @param clazz
	 *            对象的Class 类型
	 * @return T 对应泛型的List实例.
	 */
	public static <T> List<T> toList(String str, Class<T> clazz) {
		if (!StringUtils.isBlank(str)) {
			try {
				return JSONObject.parseArray(str, clazz);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 将json格式字符串转为指定类型的Object;<br/>
	 * 当null==str或str为无效json格式字符串时, 则返回 null.<br/>
	 * 例：User dto = JsonUtil.toOject(json, new TypeReference<User>() {});
	 * 
	 * @param str
	 *            json格式字符串.
	 * @param
	 *
	 * @return T 对应Object实例.
	 */
	public static <T> T toOject(String str, TypeReference<T> type) {
		if (!StringUtils.isBlank(str)) {
			try {
				return JSONObject.parseObject(str, type);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 利用Json序列化和反序列化实现任意对象深度克隆.<br/>
	 * 例如: Resources res = JsonUtil.clone(tres, new
	 * TypeReference&ltResources&gt(){});
	 * 
	 * @param <T>
	 * @param obj
	 * @param type
	 * @return
	 */
	public static <T> T clone(Object obj, TypeReference<T> type) {
		if (null != obj) {
			String json = toJson(obj);
			try {
				return JSONObject.parseObject(json, type);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 *   JSONObject 转java bean
	 * @param object
	 * @param clazz
	 * @param <T>
     * @return
     */
//	public static  <T> T  toOject(JSONObject object,Class<T> clazz) {
//		if (!Object.isEmpty(object)) {
//			try {
//				return JSONObject.parseObject(object.toJSONString(), clazz);
//			} catch (JSONException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}

	/**
	 * 打印json格式化日志
	 * @param obj
     */
	public static void printJsonLog(Object obj) {
		System.err.println(JSONObject.toJSONString(obj,SerializerFeature.PrettyFormat,SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat));
	}


	/**
	 * json字符串转List<T> 案例代码
	 */
	private void jsonToListT(){
		String jsonStr = "";
		List<String> list = JsonUtil.toOject(jsonStr, new TypeReference<List<String>>(){});
	}



}
