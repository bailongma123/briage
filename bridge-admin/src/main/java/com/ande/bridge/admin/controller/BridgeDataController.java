package com.ande.bridge.admin.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ande.bridge.admin.model.BridgeBaseEntity;
import com.ande.bridge.admin.model.BridgeEconomicEntity;
import com.ande.bridge.admin.model.BridgeEntity;
import com.ande.bridge.admin.model.BridgeMainEntity;
import com.ande.bridge.admin.model.BridgeManageEntity;
import com.ande.bridge.admin.model.BridgeStructureEntity;
import com.ande.bridge.admin.service.BridgeBaseService;
import com.ande.bridge.admin.service.BridgeEconomicService;
import com.ande.bridge.admin.service.BridgeMainService;
import com.ande.bridge.admin.service.BridgeManageService;
import com.ande.bridge.admin.service.BridgeStructureService;
import com.ande.bridge.common.AbstractController;
import com.ande.bridge.common.JsonResponse;
import com.ande.bridge.common.SystemCode;

/**
 * @author tingzhanGuo@la-inc.cn
 * @date 2018年5月26日---上午10:13:08
 * @Description 桥梁各项数据的增、删、改、查等；
 */
@RestController
@RequestMapping("/bridge")
public class BridgeDataController extends AbstractController {

	/**
	 * 注入service层接口对象
	 */
	// 桥梁基础信息
	@Resource
	private BridgeBaseService bridgeBaseService;

	// 桥梁经济信息
	@Resource
	private BridgeEconomicService bridgeEconomicService;

	// 桥梁主表信息
	@Resource
	private BridgeMainService bridgeMainService;

	// 梁管理信息
	@Resource
	private BridgeManageService bridgeManageService;

	// 桥梁结构信息
	@Resource
	private BridgeStructureService bridgeStructureService;

	/**
	 * @author tingzhanGuo@la-inc.cn
	 * @title insert
	 * @param bridgeEntity
	 * @return
	 * @throws Exception
	 * @Description 添加---桥梁信息的方法
	 */
	@RequestMapping("/insertBridge")
	public JsonResponse<String> insert(@RequestBody BridgeEntity bridgeEntity) {
		System.out.println(bridgeEntity);
		// 定义返回结果对象
		JsonResponse<String> result = new JsonResponse<>(SystemCode.SUCCESS.getCode(), SystemCode.SUCCESS.getMsg());
		// 获取分类信息实体类对象
		BridgeMainEntity bridgeMain = bridgeEntity.getBridgeMainEntity();
		BridgeBaseEntity bridgeBase = bridgeEntity.getBridgeBaseEntity();
		BridgeStructureEntity bridgeStructure = bridgeEntity.getBridgeStructureEntity();
		BridgeEconomicEntity bridgeEconomic = bridgeEntity.getBridgeEconomicEntity();
		BridgeManageEntity bridgeManage = bridgeEntity.getBridgeManageEntity();

		/**
		 * 存储信息到数据库
		 */
		try {
			// 存储BridgeMainEntity对象数据到数据库内
			bridgeMainService.insertSelective(bridgeMain);
			// 获取 桥梁ID
			Integer bridgeId = bridgeMain.getBridgeId();
			System.out.println(bridgeId);
			// 将桥梁Id值分别赋值给分类对象
			bridgeBase.setBridgeId(bridgeId);
			bridgeStructure.setBridgeId(bridgeId);
			bridgeEconomic.setBridgeId(bridgeId);
			bridgeManage.setBridgeId(bridgeId);
			// 存储数据库
			bridgeBaseService.insertSelective(bridgeBase);
			bridgeStructureService.insertSelective(bridgeStructure);
			bridgeEconomicService.insertSelective(bridgeEconomic);
			bridgeManageService.insertSelective(bridgeManage);
		} catch (Exception e) {
			e.printStackTrace();
			// "for key 'bridge_code'"索引不等-1,说明异常里有bridge_code的错误
			if (e.getMessage().indexOf("for key 'bridge_code'") != -1) {
				result.setRes(1);
				result.setResult("桥梁代码重复");
			}
			logger.error("桥梁添加失败", e);
		}
		return result;
	}

	/**
	 * @author tingzhanGuo@la-inc.cn
	 * @title deleteBridge
	 * @param bridgeId
	 * @return
	 * @Description 查找---桥梁信息的方法
	 */
	@RequestMapping("/selectAllBridge")

	public List<BridgeEntity> selectAllBridge() {

		return null;

	}

	/**
	 * @author tingzhanGuo@la-inc.cn
	 * @title deleteBridge
	 * @param bridgeId
	 * @return
	 * @Description 修改---桥梁信息的方法
	 */
	@RequestMapping("/updateBridge")

	public JsonResponse<String> updateBridge(BridgeEntity bridgeEntity) {

		return null;

	}

	/**
	 * @author tingzhanGuo@la-inc.cn
	 * @title deleteBridge
	 * @param bridgeId
	 * @return
	 * @Description 删除---桥梁信息的方法
	 */
	@RequestMapping("/deletBridge")

	public JsonResponse<String> deleteBridge(Integer bridgeId) {

		return null;

	}
}
