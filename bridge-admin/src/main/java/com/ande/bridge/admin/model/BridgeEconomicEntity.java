package com.ande.bridge.admin.model;

/**
 * @author tingzhanGuo@la-inc.cn
 * @date 2018年5月25日---下午4:22:13
 * @Description 桥梁经济信息实体类
 */
public class BridgeEconomicEntity {
	private Integer bridgeId; // 桥梁ID
	private String bridgeStatus; // 状况
	private String bridgeCode; // 桥梁代码
	private Integer bridgeConstructionPeriod; // 施工工期
	private Float bridgeCost; // 总造价
	private Float bridgeDeckElevation; // 桥面中心标高
	private String designedFloodFrequency; // 设计洪水频率
	private Float designedScourElevation; // 设计冲刷标高
	private Float bridgeBaseElevation; // 主桥基底标高
	private Float historyFloodElevation; // 历史最大洪水
	private String avgTraffic; // 年日均交通量
	private String bridgeProtectProject; // 防护工程类型
	private String bridgeAgainstType; // 墩台防撞设施类型
	private String bridgeGeology; // 地基地质
	private String bridgeAntiknock; // 抗震设防
	private String bridgeAuxiliary; // 桥上附设
	private String bridgeSeparator; // 分隔带
	private String bridgeCharge; // 收费情况
	private Integer designedSpeed; // 设计时速
	private Integer bridgeCoordinate; // 桥梁与环境协调度
	private String bridgeEnvironment; // 环境条件

	public Integer getBridgeId() {
		return bridgeId;
	}

	public void setBridgeId(Integer bridgeId) {
		this.bridgeId = bridgeId;
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

	public Integer getBridgeConstructionPeriod() {
		return bridgeConstructionPeriod;
	}

	public void setBridgeConstructionPeriod(Integer bridgeConstructionPeriod) {
		this.bridgeConstructionPeriod = bridgeConstructionPeriod;
	}

	public Float getBridgeCost() {
		return bridgeCost;
	}

	public void setBridgeCost(Float bridgeCost) {
		this.bridgeCost = bridgeCost;
	}

	public Float getBridgeDeckElevation() {
		return bridgeDeckElevation;
	}

	public void setBridgeDeckElevation(Float bridgeDeckElevation) {
		this.bridgeDeckElevation = bridgeDeckElevation;
	}

	public String getDesignedFloodFrequency() {
		return designedFloodFrequency;
	}

	public void setDesignedFloodFrequency(String designedFloodFrequency) {
		this.designedFloodFrequency = designedFloodFrequency == null ? null : designedFloodFrequency.trim();
	}

	public Float getDesignedScourElevation() {
		return designedScourElevation;
	}

	public void setDesignedScourElevation(Float designedScourElevation) {
		this.designedScourElevation = designedScourElevation;
	}

	public Float getBridgeBaseElevation() {
		return bridgeBaseElevation;
	}

	public void setBridgeBaseElevation(Float bridgeBaseElevation) {
		this.bridgeBaseElevation = bridgeBaseElevation;
	}

	public Float getHistoryFloodElevation() {
		return historyFloodElevation;
	}

	public void setHistoryFloodElevation(Float historyFloodElevation) {
		this.historyFloodElevation = historyFloodElevation;
	}

	public String getAvgTraffic() {
		return avgTraffic;
	}

	public void setAvgTraffic(String avgTraffic) {
		this.avgTraffic = avgTraffic == null ? null : avgTraffic.trim();
	}

	public String getBridgeProtectProject() {
		return bridgeProtectProject;
	}

	public void setBridgeProtectProject(String bridgeProtectProject) {
		this.bridgeProtectProject = bridgeProtectProject == null ? null : bridgeProtectProject.trim();
	}

	public String getBridgeAgainstType() {
		return bridgeAgainstType;
	}

	public void setBridgeAgainstType(String bridgeAgainstType) {
		this.bridgeAgainstType = bridgeAgainstType == null ? null : bridgeAgainstType.trim();
	}

	public String getBridgeGeology() {
		return bridgeGeology;
	}

	public void setBridgeGeology(String bridgeGeology) {
		this.bridgeGeology = bridgeGeology == null ? null : bridgeGeology.trim();
	}

	public String getBridgeAntiknock() {
		return bridgeAntiknock;
	}

	public void setBridgeAntiknock(String bridgeAntiknock) {
		this.bridgeAntiknock = bridgeAntiknock == null ? null : bridgeAntiknock.trim();
	}

	public String getBridgeAuxiliary() {
		return bridgeAuxiliary;
	}

	public void setBridgeAuxiliary(String bridgeAuxiliary) {
		this.bridgeAuxiliary = bridgeAuxiliary == null ? null : bridgeAuxiliary.trim();
	}

	public String getBridgeSeparator() {
		return bridgeSeparator;
	}

	public void setBridgeSeparator(String bridgeSeparator) {
		this.bridgeSeparator = bridgeSeparator == null ? null : bridgeSeparator.trim();
	}

	public String getBridgeCharge() {
		return bridgeCharge;
	}

	public void setBridgeCharge(String bridgeCharge) {
		this.bridgeCharge = bridgeCharge == null ? null : bridgeCharge.trim();
	}

	public Integer getDesignedSpeed() {
		return designedSpeed;
	}

	public void setDesignedSpeed(Integer designedSpeed) {
		this.designedSpeed = designedSpeed;
	}

	public Integer getBridgeCoordinate() {
		return bridgeCoordinate;
	}

	public void setBridgeCoordinate(Integer bridgeCoordinate) {
		this.bridgeCoordinate = bridgeCoordinate;
	}

	public String getBridgeEnvironment() {
		return bridgeEnvironment;
	}

	public void setBridgeEnvironment(String bridgeEnvironment) {
		this.bridgeEnvironment = bridgeEnvironment == null ? null : bridgeEnvironment.trim();
	}

	@Override
	public String toString() {
		return "BridgeEconomicEntity [bridgeId=" + bridgeId + ", bridgeStatus=" + bridgeStatus + ", bridgeCode="
				+ bridgeCode + ", bridgeConstructionPeriod=" + bridgeConstructionPeriod + ", bridgeCost=" + bridgeCost
				+ ", bridgeDeckElevation=" + bridgeDeckElevation + ", designedFloodFrequency=" + designedFloodFrequency
				+ ", designedScourElevation=" + designedScourElevation + ", bridgeBaseElevation=" + bridgeBaseElevation
				+ ", historyFloodElevation=" + historyFloodElevation + ", avgTraffic=" + avgTraffic
				+ ", bridgeProtectProject=" + bridgeProtectProject + ", bridgeAgainstType=" + bridgeAgainstType
				+ ", bridgeGeology=" + bridgeGeology + ", bridgeAntiknock=" + bridgeAntiknock + ", bridgeAuxiliary="
				+ bridgeAuxiliary + ", bridgeSeparator=" + bridgeSeparator + ", bridgeCharge=" + bridgeCharge
				+ ", designedSpeed=" + designedSpeed + ", bridgeCoordinate=" + bridgeCoordinate + ", bridgeEnvironment="
				+ bridgeEnvironment + "]";
	}
}