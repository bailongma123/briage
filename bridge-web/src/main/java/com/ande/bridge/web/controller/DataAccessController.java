package com.ande.bridge.web.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ande.bridge.common.JsonResponse;
import com.ande.bridge.common.JsonUtil;
import com.ande.bridge.common.SystemCode;
import com.ande.bridge.kafka.config.KafkaUtil;
import com.ande.bridge.model.Data;
import com.ande.bridge.model.Sensor;
import com.ande.bridge.web.check.Check;

/**
 * 2018年5月23日上午11:04:35
 * 
 * @author chengzb 数据接入层
 **/
@RestController
@RequestMapping("/dataAccess")
public class DataAccessController {
	private Logger log = LoggerFactory.getLogger(DataAccessController.class);
	@Resource
	private Check check;
	@Resource
	private KafkaUtil kafkaUtil;

	/**
	 * 
	 * 
	 * 传 com.ande.bridge.model.Data的子类
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/access")
	public JsonResponse<Data> access(@RequestParam Map<String, Object> map) {
		// 检验
		JsonResponse<Data> data = checkParam(map);
		if (data.getRes() != SystemCode.SUCCESS.getCode()) {
			return data;
		}
		String topicName = data.getObj().getType();
		map.put("msgId", data.getObj().getBridgeId()
				+ data.getObj().getEquipmentId() + System.currentTimeMillis());
		// 入队列
		kafkaUtil.send(topicName, JsonUtil.toJson(map));
		// result.set(res, result);
		return data;
	}

	private JsonResponse<Data> checkParam(Map<String, Object> map) {
		JsonResponse<Data> result = new JsonResponse<Data>(
				SystemCode.SUCCESS.getCode(), SystemCode.SUCCESS.getMsg());
		String type = (String) map.get("type");
		String code = (String) map.get("code");
		// 判空
		if (code == null || type == null) {
			result.set(SystemCode.PARAM_NOT_RIGHT.getCode(),
					SystemCode.PARAM_NOT_RIGHT.getMsg());
			return result;
		}
		// 判断 type是否合法
		String topicName = Sensor.map.get(type);
		if (topicName == null) {
			result.set(SystemCode.TYPE_NOT_EXITS.getCode(),
					SystemCode.TYPE_NOT_EXITS.getMsg());
			return result;
		}
		Data data = check.check(code);
		if (data == null) {
			// code 码校验不通过
			log.error("数据校验失败");
			result.set(SystemCode.CODE_NOT_RIGHT.getCode(),
					SystemCode.CODE_NOT_RIGHT.getMsg());
			return result;
		}
		data.setType(topicName);
		result.setObj(data);
		return result;
	}
}
