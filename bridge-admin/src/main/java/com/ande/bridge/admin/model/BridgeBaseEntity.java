package com.ande.bridge.admin.model;

/**
 * @author tingzhanGuo@la-inc.cn
 * @date 2018年5月25日---下午4:22:11
 * @Description 桥梁基础信息的实体类
 */
public class BridgeBaseEntity {
	private Integer bridgeId; // 桥梁ID
	private String bridgeCode; // 桥梁代码
	private String minorRoad; // 次要路线
	private String bridgeSerialNumber; // 顺序号
	private String bridgeManageMaintenanceDep; // 管养单位
	private String bridgeSpanType; // 跨越地物名称
	private String bridgeSpanName; // 跨越地物类型
	private Float bridgeConstructionMilestone; // 施工桩号
	private String bridgeProperty; // 桥梁性质
	private String bridgeNowLoadLevel; // 目前荷载等级
	private String bridgeSuperstructureType; // 上部结构类型
	private String bridgePierType; // 桥墩类型
	private String bridgeAbutmentType; // 桥台类型
	private String bridgeSupportType; // 支座类型
	private String bridgePierPileType; // 桥墩基础类型
	private String bridgeAbutmentPileType; // 桥台基础类型
	private String bridgeDeckType; // 桥面铺装类型
	private String bridgeJointType; // 伸缩缝类型
	private String bridgePurpose; // 桥梁用途
	private String bridgeState; // 桥梁状态
	private String multimediaData; // 多媒体资料
	private String administrativeLevel; // 行政等级
	private String bridgeTownship; // 所属乡镇
	private String bridgeMotherCode; // 母桥代码
	private String bridgeManageCode; // 管理形式码
	private String bridgePrincipal; // 责任人

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

	public String getMinorRoad() {
		return minorRoad;
	}

	public void setMinorRoad(String minorRoad) {
		this.minorRoad = minorRoad == null ? null : minorRoad.trim();
	}

	public String getBridgeSerialNumber() {
		return bridgeSerialNumber;
	}

	public void setBridgeSerialNumber(String bridgeSerialNumber) {
		this.bridgeSerialNumber = bridgeSerialNumber == null ? null : bridgeSerialNumber.trim();
	}

	public String getBridgeManageMaintenanceDep() {
		return bridgeManageMaintenanceDep;
	}

	public void setBridgeManageMaintenanceDep(String bridgeManageMaintenanceDep) {
		this.bridgeManageMaintenanceDep = bridgeManageMaintenanceDep == null ? null : bridgeManageMaintenanceDep.trim();
	}

	public String getBridgeSpanType() {
		return bridgeSpanType;
	}

	public void setBridgeSpanType(String bridgeSpanType) {
		this.bridgeSpanType = bridgeSpanType == null ? null : bridgeSpanType.trim();
	}

	public String getBridgeSpanName() {
		return bridgeSpanName;
	}

	public void setBridgeSpanName(String bridgeSpanName) {
		this.bridgeSpanName = bridgeSpanName == null ? null : bridgeSpanName.trim();
	}

	public Float getBridgeConstructionMilestone() {
		return bridgeConstructionMilestone;
	}

	public void setBridgeConstructionMilestone(Float bridgeConstructionMilestone) {
		this.bridgeConstructionMilestone = bridgeConstructionMilestone;
	}

	public String getBridgeProperty() {
		return bridgeProperty;
	}

	public void setBridgeProperty(String bridgeProperty) {
		this.bridgeProperty = bridgeProperty == null ? null : bridgeProperty.trim();
	}

	public String getBridgeNowLoadLevel() {
		return bridgeNowLoadLevel;
	}

	public void setBridgeNowLoadLevel(String bridgeNowLoadLevel) {
		this.bridgeNowLoadLevel = bridgeNowLoadLevel == null ? null : bridgeNowLoadLevel.trim();
	}

	public String getBridgeSuperstructureType() {
		return bridgeSuperstructureType;
	}

	public void setBridgeSuperstructureType(String bridgeSuperstructureType) {
		this.bridgeSuperstructureType = bridgeSuperstructureType == null ? null : bridgeSuperstructureType.trim();
	}

	public String getBridgePierType() {
		return bridgePierType;
	}

	public void setBridgePierType(String bridgePierType) {
		this.bridgePierType = bridgePierType == null ? null : bridgePierType.trim();
	}

	public String getBridgeAbutmentType() {
		return bridgeAbutmentType;
	}

	public void setBridgeAbutmentType(String bridgeAbutmentType) {
		this.bridgeAbutmentType = bridgeAbutmentType == null ? null : bridgeAbutmentType.trim();
	}

	public String getBridgeSupportType() {
		return bridgeSupportType;
	}

	public void setBridgeSupportType(String bridgeSupportType) {
		this.bridgeSupportType = bridgeSupportType == null ? null : bridgeSupportType.trim();
	}

	public String getBridgePierPileType() {
		return bridgePierPileType;
	}

	public void setBridgePierPileType(String bridgePierPileType) {
		this.bridgePierPileType = bridgePierPileType == null ? null : bridgePierPileType.trim();
	}

	public String getBridgeAbutmentPileType() {
		return bridgeAbutmentPileType;
	}

	public void setBridgeAbutmentPileType(String bridgeAbutmentPileType) {
		this.bridgeAbutmentPileType = bridgeAbutmentPileType == null ? null : bridgeAbutmentPileType.trim();
	}

	public String getBridgeDeckType() {
		return bridgeDeckType;
	}

	public void setBridgeDeckType(String bridgeDeckType) {
		this.bridgeDeckType = bridgeDeckType == null ? null : bridgeDeckType.trim();
	}

	public String getBridgeJointType() {
		return bridgeJointType;
	}

	public void setBridgeJointType(String bridgeJointType) {
		this.bridgeJointType = bridgeJointType == null ? null : bridgeJointType.trim();
	}

	public String getBridgePurpose() {
		return bridgePurpose;
	}

	public void setBridgePurpose(String bridgePurpose) {
		this.bridgePurpose = bridgePurpose == null ? null : bridgePurpose.trim();
	}

	public String getBridgeState() {
		return bridgeState;
	}

	public void setBridgeState(String bridgeState) {
		this.bridgeState = bridgeState == null ? null : bridgeState.trim();
	}

	public String getMultimediaData() {
		return multimediaData;
	}

	public void setMultimediaData(String multimediaData) {
		this.multimediaData = multimediaData == null ? null : multimediaData.trim();
	}

	public String getAdministrativeLevel() {
		return administrativeLevel;
	}

	public void setAdministrativeLevel(String administrativeLevel) {
		this.administrativeLevel = administrativeLevel == null ? null : administrativeLevel.trim();
	}

	public String getBridgeTownship() {
		return bridgeTownship;
	}

	public void setBridgeTownship(String bridgeTownship) {
		this.bridgeTownship = bridgeTownship == null ? null : bridgeTownship.trim();
	}

	public String getBridgeMotherCode() {
		return bridgeMotherCode;
	}

	public void setBridgeMotherCode(String bridgeMotherCode) {
		this.bridgeMotherCode = bridgeMotherCode == null ? null : bridgeMotherCode.trim();
	}

	public String getBridgeManageCode() {
		return bridgeManageCode;
	}

	public void setBridgeManageCode(String bridgeManageCode) {
		this.bridgeManageCode = bridgeManageCode == null ? null : bridgeManageCode.trim();
	}

	public String getBridgePrincipal() {
		return bridgePrincipal;
	}

	public void setBridgePrincipal(String bridgePrincipal) {
		this.bridgePrincipal = bridgePrincipal == null ? null : bridgePrincipal.trim();
	}

	@Override
	public String toString() {
		return "BridgeBaseEntity [bridgeId=" + bridgeId + ", bridgeCode=" + bridgeCode + ", minorRoad=" + minorRoad
				+ ", bridgeSerialNumber=" + bridgeSerialNumber + ", bridgeManageMaintenanceDep="
				+ bridgeManageMaintenanceDep + ", bridgeSpanType=" + bridgeSpanType + ", bridgeSpanName="
				+ bridgeSpanName + ", bridgeConstructionMilestone=" + bridgeConstructionMilestone + ", bridgeProperty="
				+ bridgeProperty + ", bridgeNowLoadLevel=" + bridgeNowLoadLevel + ", bridgeSuperstructureType="
				+ bridgeSuperstructureType + ", bridgePierType=" + bridgePierType + ", bridgeAbutmentType="
				+ bridgeAbutmentType + ", bridgeSupportType=" + bridgeSupportType + ", bridgePierPileType="
				+ bridgePierPileType + ", bridgeAbutmentPileType=" + bridgeAbutmentPileType + ", bridgeDeckType="
				+ bridgeDeckType + ", bridgeJointType=" + bridgeJointType + ", bridgePurpose=" + bridgePurpose
				+ ", bridgeState=" + bridgeState + ", multimediaData=" + multimediaData + ", administrativeLevel="
				+ administrativeLevel + ", bridgeTownship=" + bridgeTownship + ", bridgeMotherCode=" + bridgeMotherCode
				+ ", bridgeManageCode=" + bridgeManageCode + ", bridgePrincipal=" + bridgePrincipal + "]";
	}

}