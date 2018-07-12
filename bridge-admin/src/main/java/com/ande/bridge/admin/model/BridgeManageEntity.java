package com.ande.bridge.admin.model;

import java.util.Date;

/**
 * @author tingzhanGuo@la-inc.cn
 * @date 2018年5月25日---下午4:22:17
 * @Description 桥梁管理信息实体类
 */
public class BridgeManageEntity {
	private Integer bridgeId; // 桥梁ID
	private String bridgeCode; // 桥梁代码
	private String bridgeDesignDataNum; // 设计资料编号
	private String bridgeCompletionDataNum; // 竣工资料编号
	private String bridgeMaintenanceDataNum; // 养护资料编号
	private String bridgeKeeper; // 保管单位
	private String trafficControlMeasures; // 交通管制措施
	private String assessdLastThreeYears; // 最近三年是否评定
	private Date lastRebuildDate; // 最近改造完工日期
	private String lastRebuildPart; // 最近改造部位
	private String projectNature; // 工程性质
	private String bridgeOwner; // 产权单位名称
	private String bridgeDesigner; // 设计者
	private String bridgeConstructionSupervisor; // 施工负责人
	private String bridgeConstructionDrawings; // 所用标准图
	private String bridgeAcceptanceOpinion; // 竣工验收意见
	private String bridgeMaintenancePhone; // 养护电话
	private String bridgeManagePhone; // 管理电话
	private String bridgeSuperviseDep; // 监管单位
	private String bridgeSupervisePhone; // 监管电话
	private Date lastUpdateDate; // 最后修改日期

	public Integer getBridgeId() {
		return bridgeId;
	}

	public void setBridgeId(Integer bridgeId) {
		this.bridgeId = bridgeId;
	}

	public String getBridgeCode() {
		return bridgeCode;
	}

	public void setBridgeCode(String bridgeCode) {
		this.bridgeCode = bridgeCode == null ? null : bridgeCode.trim();
	}

	public String getBridgeDesignDataNum() {
		return bridgeDesignDataNum;
	}

	public void setBridgeDesignDataNum(String bridgeDesignDataNum) {
		this.bridgeDesignDataNum = bridgeDesignDataNum == null ? null : bridgeDesignDataNum.trim();
	}

	public String getBridgeCompletionDataNum() {
		return bridgeCompletionDataNum;
	}

	public void setBridgeCompletionDataNum(String bridgeCompletionDataNum) {
		this.bridgeCompletionDataNum = bridgeCompletionDataNum == null ? null : bridgeCompletionDataNum.trim();
	}

	public String getBridgeMaintenanceDataNum() {
		return bridgeMaintenanceDataNum;
	}

	public void setBridgeMaintenanceDataNum(String bridgeMaintenanceDataNum) {
		this.bridgeMaintenanceDataNum = bridgeMaintenanceDataNum == null ? null : bridgeMaintenanceDataNum.trim();
	}

	public String getBridgeKeeper() {
		return bridgeKeeper;
	}

	public void setBridgeKeeper(String bridgeKeeper) {
		this.bridgeKeeper = bridgeKeeper == null ? null : bridgeKeeper.trim();
	}

	public String getTrafficControlMeasures() {
		return trafficControlMeasures;
	}

	public void setTrafficControlMeasures(String trafficControlMeasures) {
		this.trafficControlMeasures = trafficControlMeasures == null ? null : trafficControlMeasures.trim();
	}

	public String getAssessdLastThreeYears() {
		return assessdLastThreeYears;
	}

	public void setAssessdLastThreeYears(String assessdLastThreeYears) {
		this.assessdLastThreeYears = assessdLastThreeYears == null ? null : assessdLastThreeYears.trim();
	}

	public Date getLastRebuildDate() {
		return lastRebuildDate;
	}

	public void setLastRebuildDate(Date lastRebuildDate) {
		this.lastRebuildDate = lastRebuildDate;
	}

	public String getLastRebuildPart() {
		return lastRebuildPart;
	}

	public void setLastRebuildPart(String lastRebuildPart) {
		this.lastRebuildPart = lastRebuildPart == null ? null : lastRebuildPart.trim();
	}

	public String getProjectNature() {
		return projectNature;
	}

	public void setProjectNature(String projectNature) {
		this.projectNature = projectNature == null ? null : projectNature.trim();
	}

	public String getBridgeOwner() {
		return bridgeOwner;
	}

	public void setBridgeOwner(String bridgeOwner) {
		this.bridgeOwner = bridgeOwner == null ? null : bridgeOwner.trim();
	}

	public String getBridgeDesigner() {
		return bridgeDesigner;
	}

	public void setBridgeDesigner(String bridgeDesigner) {
		this.bridgeDesigner = bridgeDesigner == null ? null : bridgeDesigner.trim();
	}

	public String getBridgeConstructionSupervisor() {
		return bridgeConstructionSupervisor;
	}

	public void setBridgeConstructionSupervisor(String bridgeConstructionSupervisor) {
		this.bridgeConstructionSupervisor = bridgeConstructionSupervisor == null ? null
				: bridgeConstructionSupervisor.trim();
	}

	public String getBridgeConstructionDrawings() {
		return bridgeConstructionDrawings;
	}

	public void setBridgeConstructionDrawings(String bridgeConstructionDrawings) {
		this.bridgeConstructionDrawings = bridgeConstructionDrawings == null ? null : bridgeConstructionDrawings.trim();
	}

	public String getBridgeAcceptanceOpinion() {
		return bridgeAcceptanceOpinion;
	}

	public void setBridgeAcceptanceOpinion(String bridgeAcceptanceOpinion) {
		this.bridgeAcceptanceOpinion = bridgeAcceptanceOpinion == null ? null : bridgeAcceptanceOpinion.trim();
	}

	public String getBridgeMaintenancePhone() {
		return bridgeMaintenancePhone;
	}

	public void setBridgeMaintenancePhone(String bridgeMaintenancePhone) {
		this.bridgeMaintenancePhone = bridgeMaintenancePhone == null ? null : bridgeMaintenancePhone.trim();
	}

	public String getBridgeManagePhone() {
		return bridgeManagePhone;
	}

	public void setBridgeManagePhone(String bridgeManagePhone) {
		this.bridgeManagePhone = bridgeManagePhone == null ? null : bridgeManagePhone.trim();
	}

	public String getbridgeSuperviseDep() {
		return bridgeSuperviseDep;
	}

	public void setbridgeSuperviseDep(String bridgeSuperviseDep) {
		this.bridgeSuperviseDep = bridgeSuperviseDep == null ? null : bridgeSuperviseDep.trim();
	}

	public String getBridgeSupervisePhone() {
		return bridgeSupervisePhone;
	}

	public void setBridgeSupervisePhone(String bridgeSupervisePhone) {
		this.bridgeSupervisePhone = bridgeSupervisePhone == null ? null : bridgeSupervisePhone.trim();
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@Override
	public String toString() {
		return "BridgeManageEntity [bridgeId=" + bridgeId + ", bridgeCode=" + bridgeCode + ", bridgeDesignDataNum="
				+ bridgeDesignDataNum + ", bridgeCompletionDataNum=" + bridgeCompletionDataNum
				+ ", bridgeMaintenanceDataNum=" + bridgeMaintenanceDataNum + ", bridgeKeeper=" + bridgeKeeper
				+ ", trafficControlMeasures=" + trafficControlMeasures + ", assessdLastThreeYears="
				+ assessdLastThreeYears + ", lastRebuildDate=" + lastRebuildDate + ", lastRebuildPart="
				+ lastRebuildPart + ", projectNature=" + projectNature + ", bridgeOwner=" + bridgeOwner
				+ ", bridgeDesigner=" + bridgeDesigner + ", bridgeConstructionSupervisor="
				+ bridgeConstructionSupervisor + ", bridgeConstructionDrawings=" + bridgeConstructionDrawings
				+ ", bridgeAcceptanceOpinion=" + bridgeAcceptanceOpinion + ", bridgeMaintenancePhone="
				+ bridgeMaintenancePhone + ", bridgeManagePhone=" + bridgeManagePhone + ", bridgeSuperviseDep="
				+ bridgeSuperviseDep + ", bridgeSupervisePhone=" + bridgeSupervisePhone + ", lastUpdateDate="
				+ lastUpdateDate + "]";
	}

}