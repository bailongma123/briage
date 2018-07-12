package com.ande.bridge.admin.model;

import java.util.Date;

/**
 * @author tingzhanGuo@la-inc.cn
 * @date 2018年5月25日---下午4:22:15
 * @Description 桥梁主表热搜信息实体类
 */
public class BridgeMainEntity {
	private Integer bridgeId; // 桥梁ID
	private Integer manageObjectId; // 管养对象ID
	private String bridgeStatus; // 状况
	private String bridgeCode; // 桥梁代码
	private String bridgeName; // 桥梁名称
	private String roadNumber; // 路线号
	private String roadName; // 路线名称
	private String roadType; // 路线类型
	private String bridgeLocation; // 所在地
	private Float bridgeCenterMilestone; // 中心桩号
	private String bridgeType; // 桥型
	private String bridgeClassification; // 桥梁分类
	private String highwayLevel; // 公路技术等级
	private String desiginLoadLevel; // 设计荷载等级
	private Float bridgeLength; // 桥梁全长
	private Float bridgeClearWidth; // 桥面净宽
	private Float bridgeMaxSpan; // 最大跨径
	private String bridgeMaintenance; // 养护单位
	private String bridgeManager; // 管理单位
	private Date bridgeCreateDate; // 建桥年月
	private String bridgeDesignDepartment; // 设计单位
	private String bridgePracticeDepartment; // 施工单位
	private String bridgeSuperviseDepartment; // 监理单位

	public Integer getBridgeId() {
		return bridgeId;
	}

	public void setBridgeId(Integer bridgeId) {
		this.bridgeId = bridgeId;
	}

	public Integer getManageObjectId() {
		return manageObjectId;
	}

	public void setManageObjectId(Integer manageObjectId) {
		this.manageObjectId = manageObjectId;
	}

	public String getBridgeStatus() {
		return bridgeStatus;
	}

	public void setBridgeStatus(String bridgeStatus) {
		this.bridgeStatus = bridgeStatus == null ? null : bridgeStatus.trim();
	}

	public String getBridgeCode() {
		return bridgeCode;
	}

	public void setBridgeCode(String bridgeCode) {
		this.bridgeCode = bridgeCode == null ? null : bridgeCode.trim();
	}

	public String getBridgeName() {
		return bridgeName;
	}

	public void setBridgeName(String bridgeName) {
		this.bridgeName = bridgeName == null ? null : bridgeName.trim();
	}

	public String getRoadNumber() {
		return roadNumber;
	}

	public void setRoadNumber(String roadNumber) {
		this.roadNumber = roadNumber == null ? null : roadNumber.trim();
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName == null ? null : roadName.trim();
	}

	public String getRoadType() {
		return roadType;
	}

	public void setRoadType(String roadType) {
		this.roadType = roadType == null ? null : roadType.trim();
	}

	public String getBridgeLocation() {
		return bridgeLocation;
	}

	public void setBridgeLocation(String bridgeLocation) {
		this.bridgeLocation = bridgeLocation == null ? null : bridgeLocation.trim();
	}

	public Float getBridgeCenterMilestone() {
		return bridgeCenterMilestone;
	}

	public void setBridgeCenterMilestone(Float bridgeCenterMilestone) {
		this.bridgeCenterMilestone = bridgeCenterMilestone;
	}

	public String getBridgeType() {
		return bridgeType;
	}

	public void setBridgeType(String bridgeType) {
		this.bridgeType = bridgeType == null ? null : bridgeType.trim();
	}

	public String getBridgeClassification() {
		return bridgeClassification;
	}

	public void setBridgeClassification(String bridgeClassification) {
		this.bridgeClassification = bridgeClassification == null ? null : bridgeClassification.trim();
	}

	public String getHighwayLevel() {
		return highwayLevel;
	}

	public void setHighwayLevel(String highwayLevel) {
		this.highwayLevel = highwayLevel == null ? null : highwayLevel.trim();
	}

	public String getDesiginLoadLevel() {
		return desiginLoadLevel;
	}

	public void setDesiginLoadLevel(String desiginLoadLevel) {
		this.desiginLoadLevel = desiginLoadLevel == null ? null : desiginLoadLevel.trim();
	}

	public Float getBridgeLength() {
		return bridgeLength;
	}

	public void setBridgeLength(Float bridgeLength) {
		this.bridgeLength = bridgeLength;
	}

	public Float getBridgeClearWidth() {
		return bridgeClearWidth;
	}

	public void setBridgeClearWidth(Float bridgeClearWidth) {
		this.bridgeClearWidth = bridgeClearWidth;
	}

	public Float getBridgeMaxSpan() {
		return bridgeMaxSpan;
	}

	public void setBridgeMaxSpan(Float bridgeMaxSpan) {
		this.bridgeMaxSpan = bridgeMaxSpan;
	}

	public String getBridgeMaintenance() {
		return bridgeMaintenance;
	}

	public void setBridgeMaintenance(String bridgeMaintenance) {
		this.bridgeMaintenance = bridgeMaintenance == null ? null : bridgeMaintenance.trim();
	}

	public String getBridgeManager() {
		return bridgeManager;
	}

	public void setBridgeManager(String bridgeManager) {
		this.bridgeManager = bridgeManager == null ? null : bridgeManager.trim();
	}

	public Date getBridgeCreateDate() {
		return bridgeCreateDate;
	}

	public void setBridgeCreateDate(Date bridgeCreateDate) {
		this.bridgeCreateDate = bridgeCreateDate;
	}

	public String getBridgeDesignDepartment() {
		return bridgeDesignDepartment;
	}

	public void setBridgeDesignDepartment(String bridgeDesignDepartment) {
		this.bridgeDesignDepartment = bridgeDesignDepartment == null ? null : bridgeDesignDepartment.trim();
	}

	public String getBridgePracticeDepartment() {
		return bridgePracticeDepartment;
	}

	public void setBridgePracticeDepartment(String bridgePracticeDepartment) {
		this.bridgePracticeDepartment = bridgePracticeDepartment == null ? null : bridgePracticeDepartment.trim();
	}

	public String getBridgeSuperviseDepartment() {
		return bridgeSuperviseDepartment;
	}

	public void setBridgeSuperviseDepartment(String bridgeSuperviseDepartment) {
		this.bridgeSuperviseDepartment = bridgeSuperviseDepartment == null ? null : bridgeSuperviseDepartment.trim();
	}

	@Override
	public String toString() {
		return "BridgeMainEntity [bridgeId=" + bridgeId + ", manageObjectId=" + manageObjectId + ", bridgeStatus="
				+ bridgeStatus + ", bridgeCode=" + bridgeCode + ", bridgeName=" + bridgeName + ", roadNumber="
				+ roadNumber + ", roadName=" + roadName + ", roadType=" + roadType + ", bridgeLocation="
				+ bridgeLocation + ", bridgeCenterMilestone=" + bridgeCenterMilestone + ", bridgeType=" + bridgeType
				+ ", bridgeClassification=" + bridgeClassification + ", highwayLevel=" + highwayLevel
				+ ", desiginLoadLevel=" + desiginLoadLevel + ", bridgeLength=" + bridgeLength + ", bridgeClearWidth="
				+ bridgeClearWidth + ", bridgeMaxSpan=" + bridgeMaxSpan + ", bridgeMaintenance=" + bridgeMaintenance
				+ ", bridgeManager=" + bridgeManager + ", bridgeCreateDate=" + bridgeCreateDate
				+ ", bridgeDesignDepartment=" + bridgeDesignDepartment + ", bridgePracticeDepartment="
				+ bridgePracticeDepartment + ", bridgeSuperviseDepartment=" + bridgeSuperviseDepartment + "]";
	}

}