package com.ande.bridge.admin.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ande.bridge.admin.model.BridgeBaseEntity;
import com.ande.bridge.admin.model.BridgeEconomicEntity;
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
import com.ande.bridge.common.JsonUtil;
import com.ande.bridge.common.SystemCode;

import util.POIUtil;

/**
 * <pre>
 * <b> Excl文件导入，解析存入数据库.</b> 
 * <b>Author: tianhua.lan@la-inc.cn </b>
 * <b>date:2018年5月24日 下午1:48:01 </b>
 * ----------------------------------------------------------------------------
 * ----------------------------------------------------------------------------
 * 
 * <pre>
 */
@RestController
@RequestMapping("/brige")
public class ExcelUp extends AbstractController {

	/** 桥梁基础信息 */
	@Resource
	private BridgeBaseService bridgeBaseService;

	/** 桥梁经济信息 */
	@Resource
	private BridgeEconomicService bridgeEconomicService;

	/** 桥梁主表信息 */
	@Resource
	private BridgeMainService bridgeMainService;

	/** 桥梁管理信息 */
	@Resource
	private BridgeManageService bridgeManageService;

	/** 桥梁结构信息 */
	@Resource
	private BridgeStructureService bridgeStructureService;

	
	/**
	 * @author tingzhanGuo@la-inc.cn
	 * @title upExcel
	 * @param request
	 * @return
	 * @Description 解析上传的Excel文件保存数据到数据库
	 */
	@RequestMapping("/upexcle")
	public JsonResponse<String> upExcel(HttpServletRequest request) {

		// 定义返回的结果对象
		JsonResponse<String> result = new JsonResponse<String>(SystemCode.SUCCESS.getCode(),
				SystemCode.SUCCESS.getMsg());

		// 接收上传的文件
		MultipartHttpServletRequest r = (MultipartHttpServletRequest) request;
		MultipartFile mFile = r.getFile("file");
		List<String[]> list = null;
		try {
			List<BridgeEconomicEntity> bridgeEconomicEntityList = new ArrayList<BridgeEconomicEntity>();
			List<BridgeMainEntity> bridgeMainList = new ArrayList<BridgeMainEntity>();
			List<BridgeManageEntity> bridgeManageEntityList = new ArrayList<BridgeManageEntity>();
			List<BridgeStructureEntity> bridgeStructureEntityList = new ArrayList<BridgeStructureEntity>();
			list = POIUtil.readExcel(mFile);
			System.out.println(list.size());
			for(int i = 0;i<=1;i++ ){
				BridgeBaseEntity entity = saveBridgeBaseEntity(list.get(i));
				bridgeBaseService.insertSelective(entity);
				Integer id = entity.getBridgeId();
				
				bridgeEconomicEntityList = saveBridgeEconomicEntity(list.get(i),bridgeEconomicEntityList ,id);
				System.out.println(bridgeEconomicEntityList.size());
				bridgeMainList = saveBridgeMainEntity(list.get(i),bridgeMainList,id);
				System.out.println(bridgeEconomicEntityList.size());
				bridgeManageEntityList = saveBridgeManageEntity(list.get(i),bridgeManageEntityList,id);
				System.out.println(bridgeEconomicEntityList.size());
				bridgeStructureEntityList = saveBridgeStructureEntity(list.get(i),bridgeStructureEntityList,id);
				System.out.println(bridgeEconomicEntityList.size());
			}
			
					
			
			bridgeEconomicService.InsertListEntity(bridgeEconomicEntityList);
			
			bridgeMainService.InsertListEntity(bridgeMainList);
			
			bridgeManageService.InsertListEntity(bridgeManageEntityList);
			
			bridgeStructureService.InsertListEntity(bridgeStructureEntityList);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.setRes(SystemCode.SUCCESS.getCode());
		result.setResult(SystemCode.SUCCESS.getMsg());
		return result;
	}
	
	
	/**
	 * 桥梁基础信息数据
	 * @param a
	 * @param bridgeBaseEntityList
	 * @return
	 */
	public BridgeBaseEntity saveBridgeBaseEntity(String[] a){
		BridgeBaseEntity bridgeBaseEntity = new BridgeBaseEntity();
		bridgeBaseEntity.setBridgeCode("桥梁工程代码1"+String.valueOf(Math.random()));
		bridgeBaseEntity.setMinorRoad(a[0]);
		bridgeBaseEntity.setBridgeSerialNumber(a[1]);
		bridgeBaseEntity.setBridgeManageMaintenanceDep(a[2]);
		bridgeBaseEntity.setBridgeSpanType(a[3]);
		bridgeBaseEntity.setBridgeSpanName(a[4]);
		bridgeBaseEntity.setBridgeConstructionMilestone(Float.parseFloat(a[5]));
		bridgeBaseEntity.setBridgeProperty(a[6]);
		bridgeBaseEntity.setBridgeNowLoadLevel(a[7]);
		bridgeBaseEntity.setBridgeSuperstructureType(a[8]);
		bridgeBaseEntity.setBridgePierType(a[9]);
		bridgeBaseEntity.setBridgeAbutmentType(a[10]);
		bridgeBaseEntity.setBridgeSupportType(a[11]);
		bridgeBaseEntity.setBridgePierPileType(a[12]);
		bridgeBaseEntity.setBridgeAbutmentPileType(a[13]);
		bridgeBaseEntity.setBridgeDeckType(a[14]);
		bridgeBaseEntity.setBridgeJointType(a[15]);
		bridgeBaseEntity.setBridgePurpose(a[16]);
		bridgeBaseEntity.setBridgeState(a[17]);
		bridgeBaseEntity.setMultimediaData("D/SRC");
		bridgeBaseEntity.setAdministrativeLevel(a[18]);
		bridgeBaseEntity.setBridgeTownship(a[19]);
		bridgeBaseEntity.setBridgeMotherCode(a[20]);
		bridgeBaseEntity.setBridgeManageCode(a[21]);
		bridgeBaseEntity.setBridgePrincipal(a[22]);
		return bridgeBaseEntity;
		
	}
	
	
	
	
	/**
	 * 桥梁经济信息 数据集合
	 * @param a
	 * @param bridgeEconomicEntityList
	 * @return
	 */
	public List<BridgeEconomicEntity> saveBridgeEconomicEntity(String[] a,List<BridgeEconomicEntity> bridgeEconomicEntityList,Integer id){
		BridgeEconomicEntity bridgeEconomicEntity = new BridgeEconomicEntity();
		bridgeEconomicEntity.setBridgeId(id);
		bridgeEconomicEntity.setAvgTraffic(a[23]);
		bridgeEconomicEntity.setBridgeAgainstType(a[24]);
		bridgeEconomicEntity.setBridgeAntiknock(a[25]);
		bridgeEconomicEntity.setBridgeAuxiliary(a[26]);
		bridgeEconomicEntity.setBridgeBaseElevation(Float.parseFloat(a[27]));
		bridgeEconomicEntity.setBridgeCharge(a[28]);
		bridgeEconomicEntity.setBridgeConstructionPeriod(Integer.parseInt(a[30]));
		bridgeEconomicEntity.setBridgeCoordinate(Integer.parseInt(a[31]));
		bridgeEconomicEntity.setBridgeCost(Float.parseFloat(a[32]));
		bridgeEconomicEntity.setBridgeDeckElevation(Float.parseFloat(a[33]));
		bridgeEconomicEntity.setBridgeEnvironment(a[34]);
		bridgeEconomicEntity.setBridgeGeology(a[35]);
		bridgeEconomicEntity.setBridgeProtectProject(a[36]);
		bridgeEconomicEntity.setBridgeSeparator(a[37]);
		bridgeEconomicEntity.setBridgeStatus(a[38]);
		bridgeEconomicEntity.setDesignedFloodFrequency(a[39]);
		bridgeEconomicEntity.setDesignedScourElevation(Float.parseFloat(a[40]));
		bridgeEconomicEntity.setDesignedSpeed(Integer.parseInt(a[41]));
		bridgeEconomicEntity.setHistoryFloodElevation(Float.parseFloat(a[42]));
		bridgeEconomicEntityList.add(bridgeEconomicEntity);
		
		return bridgeEconomicEntityList;
	}
	
	public List<BridgeMainEntity> saveBridgeMainEntity(String[] a,List<BridgeMainEntity> bridgeMainEntityList,Integer id){
		BridgeMainEntity bridgeMainEntity = new BridgeMainEntity();
		bridgeMainEntity.setBridgeId(id);
		bridgeMainEntity.setBridgeCenterMilestone(Float.parseFloat(a[43]));
		bridgeMainEntity.setBridgeClassification(a[44]);
		bridgeMainEntity.setBridgeClearWidth(Float.parseFloat(a[45]));
		bridgeMainEntity.setBridgeCreateDate(new Date());
		bridgeMainEntity.setBridgeDesignDepartment(a[46]);
		bridgeMainEntity.setBridgeLength(Float.parseFloat(a[47]));
		bridgeMainEntity.setBridgeLocation(a[48]);
		bridgeMainEntity.setBridgeMaintenance(a[49]);
		bridgeMainEntity.setBridgeManager(a[50]);
		bridgeMainEntity.setBridgeMaxSpan(Float.parseFloat(a[51]));
		bridgeMainEntity.setBridgeName(a[52]);
		bridgeMainEntity.setBridgePracticeDepartment(a[53]);
		bridgeMainEntity.setBridgeStatus(a[54]);
		bridgeMainEntity.setBridgeSuperviseDepartment(a[55]);
		bridgeMainEntity.setBridgeType(a[56]);
		bridgeMainEntity.setDesiginLoadLevel(a[57]);
		bridgeMainEntity.setHighwayLevel(a[58]);
		bridgeMainEntity.setManageObjectId(Integer.parseInt(a[59]));
		bridgeMainEntity.setRoadName(a[60]);
		bridgeMainEntity.setRoadNumber(a[61]);
		bridgeMainEntity.setRoadType(a[62]);
		bridgeMainEntityList.add(bridgeMainEntity);
		return bridgeMainEntityList;
	}
	
	
	public List<BridgeManageEntity> saveBridgeManageEntity(String[] a,List<BridgeManageEntity> bridgeManageEntityList,Integer id){
		BridgeManageEntity bridgeManageEntity = new BridgeManageEntity();
		bridgeManageEntity.setBridgeId(id);
		bridgeManageEntity.setAssessdLastThreeYears(a[63]);
		bridgeManageEntity.setBridgeAcceptanceOpinion(a[64]);
		bridgeManageEntity.setBridgeCompletionDataNum(a[65]);
		bridgeManageEntity.setBridgeConstructionDrawings(a[66]);
		bridgeManageEntity.setBridgeConstructionSupervisor(a[67]);
		bridgeManageEntity.setBridgeDesignDataNum(a[68]);
		bridgeManageEntity.setBridgeDesigner(a[69]);
		bridgeManageEntity.setBridgeKeeper(a[70]);
		bridgeManageEntity.setBridgeMaintenanceDataNum(a[71]);
		bridgeManageEntity.setBridgeMaintenancePhone(a[72]);
		bridgeManageEntity.setBridgeManagePhone(a[73]);
		bridgeManageEntity.setBridgeOwner(a[74]);
		bridgeManageEntity.setbridgeSuperviseDep(a[75]);
		bridgeManageEntity.setBridgeSupervisePhone(a[76]);
		bridgeManageEntity.setLastRebuildDate(new Date());
		bridgeManageEntity.setLastRebuildPart(a[77]);
		bridgeManageEntity.setLastUpdateDate(new Date());
		bridgeManageEntity.setProjectNature(a[78]);
		bridgeManageEntity.setTrafficControlMeasures(a[79]);
		bridgeManageEntityList.add(bridgeManageEntity);
		
		return bridgeManageEntityList;
	}
	
	/**
	 * <pre>
	* <b> .</b>
	* <b>Author: name@la-inc.cn</b> 
	* <b>date: 2018年5月28日 下午2:38:44 </b>
	* <b>@param:
	*<pre>
	 */
	public List<BridgeStructureEntity> saveBridgeStructureEntity(String[] a,List<BridgeStructureEntity> bridgeStructureEntityList,Integer id){
		BridgeStructureEntity bridgeStructureEntity = new BridgeStructureEntity();
		bridgeStructureEntity.setBridgeId(id);
		bridgeStructureEntity.setBridgeGradeSeparation(a[80]);
		bridgeStructureEntity.setBridgeHeadWidth(Float.parseFloat(a[81]));
		bridgeStructureEntity.setBridgeHeight(Float.parseFloat(a[82]));
		bridgeStructureEntity.setBridgeHorizontalRadius(Float.parseFloat(a[83]));
		bridgeStructureEntity.setBridgeIntersect(a[84]);
		bridgeStructureEntity.setBridgeLinetype(a[85]);
		bridgeStructureEntity.setBridgeLongitudinalSlope(a[86]);
		bridgeStructureEntity.setBridgeMaxHeadroom(Float.parseFloat(a[87]));
		bridgeStructureEntity.setBridgeMidspanHeight(Float.parseFloat(a[88]));
		bridgeStructureEntity.setBridgeOverallWidth(Float.parseFloat(a[89]));
		bridgeStructureEntity.setBridgeRebuildDate(new Date());
		bridgeStructureEntity.setBridgeRiseSpanRatio(a[90]);
		bridgeStructureEntity.setBridgeSpanCombination(a[91]);
		bridgeStructureEntity.setBridgeStatus(a[92]);
		bridgeStructureEntity.setBridgeTotalSpan(Float.parseFloat(a[93]));
		bridgeStructureEntity.setBridgeVerticalHeight(Float.parseFloat(a[94]));
		bridgeStructureEntity.setBridgeWidthConbination(a[95]);
		bridgeStructureEntity.setIsWideroadNarrowbridge(a[96]);
		bridgeStructureEntity.setManageObjectId(Integer.parseInt(a[29]));
		bridgeStructureEntity.setNavigationLevel(a[97]);
		bridgeStructureEntityList.add(bridgeStructureEntity);
		return bridgeStructureEntityList;
	}
	
	
	
//	
//	@RequestMapping("/id")
//	public void testDatasource() throws Exception{
//		File file = new File("D:/aaa.xls");
//		List<String[]> list = POIUtil.readExcel(file);
//		System.out.println(JsonUtil.toJson(list));
//		List<BridgeEconomicEntity> bridgeEconomicEntityList = new ArrayList<BridgeEconomicEntity>();
//		List<BridgeMainEntity> bridgeMainList = new ArrayList<BridgeMainEntity>();
//		List<BridgeManageEntity> bridgeManageEntityList = new ArrayList<BridgeManageEntity>();
//		List<BridgeStructureEntity> bridgeStructureEntityList = new ArrayList<BridgeStructureEntity>();
//		for(int i = 0;i<=1;i++ ){
//			BridgeBaseEntity entity = saveBridgeBaseEntity(list.get(i));
//			bridgeBaseService.insertSelective(entity);
//			Integer id = entity.getBridgeId();
//			
//			bridgeEconomicEntityList = saveBridgeEconomicEntity(list.get(i),bridgeEconomicEntityList ,id);
//			System.out.println(bridgeEconomicEntityList.size());
//			bridgeMainList = saveBridgeMainEntity(list.get(i),bridgeMainList,id);
//			System.out.println(bridgeEconomicEntityList.size());
//			bridgeManageEntityList = saveBridgeManageEntity(list.get(i),bridgeManageEntityList,id);
//			System.out.println(bridgeEconomicEntityList.size());
//			bridgeStructureEntityList = saveBridgeStructureEntity(list.get(i),bridgeStructureEntityList,id);
//			System.out.println(bridgeEconomicEntityList.size());
//		}
//		
//				
//		
//		bridgeEconomicService.InsertListEntity(bridgeEconomicEntityList);
//		
//		bridgeMainService.InsertListEntity(bridgeMainList);
//		
//		bridgeManageService.InsertListEntity(bridgeManageEntityList);
//		
//		bridgeStructureService.InsertListEntity(bridgeStructureEntityList);
//		
//	}
//	
//	
	
	
//	@RequestMapping("/downExcel")
//	public JsonResponse<String> downExcel(HttpServletRequest request) {
//		JsonResponse<String> result = new JsonResponse<String>();
//		List<String[]> list = new ArrayList<String[]>();
//		String[] a = {"1","2","3","4","5","6","7","8","9","10","11","12"};
//		list.add(a);
//		String finalXlsxPath = "";
//		POIUtil.writeExcel(list,finalXlsxPath);
//		System.out.println(1);
//		return result;
//	}
	

}
