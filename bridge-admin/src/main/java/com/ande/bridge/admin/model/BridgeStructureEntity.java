package com.ande.bridge.admin.model;

import java.util.Date;

/**
 * @author tingzhanGuo@la-inc.cn
 * @date 2018年5月25日---下午4:22:18
 * @Description 桥梁结构信息实体类
 */
public class BridgeStructureEntity {
	private Integer bridgeId; // 桥梁ID
	private Integer manageObjectId; // 管养对象ID
	private String bridgeStatus; // 状况
	private String bridgeCode; // 桥梁代码
	private Float bridgeTotalSpan; // 跨径总长
	private String isWideroadNarrowbridge; // 是否宽路窄桥
	private String bridgeSpanCombination; // 桥跨组合
	private Date bridgeRebuildDate; // 改建年月
	private String navigationLevel; // 通航等级
	private Float bridgeMaxHeadroom; // 桥梁限高
	private Float bridgeHeight; // 桥高
	private Float bridgeVerticalHeight; // 桥下垂直净高
	private Float bridgeMidspanHeight; // 跨中截面高
	private String bridgeWidthConbination; // 桥宽组合
	private Float bridgeOverallWidth; // 桥面全宽
	private Float bridgeHorizontalRadius; // 桥梁平曲线半径
	private Float bridgeHeadWidth; // 桥头路面净宽
	private String bridgeRiseSpanRatio; // 矢跨比
	private String bridgeLongitudinalSlope; // 桥面纵坡
	private String bridgeLinetype; // 弯坡斜特征
	private String bridgeGradeSeparation; // 立交特征
	private String bridgeIntersect; // 交叉形式

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

	public Float getBridgeTotalSpan() {
		return bridgeTotalSpan;
	}

	public void setBridgeTotalSpan(Float bridgeTotalSpan) {
		this.bridgeTotalSpan = bridgeTotalSpan;
	}

	public String getIsWideroadNarrowbridge() {
		return isWideroadNarrowbridge;
	}

	public void setIsWideroadNarrowbridge(String isWideroadNarrowbridge) {
		this.isWideroadNarrowbridge = isWideroadNarrowbridge == null ? null : isWideroadNarrowbridge.trim();
	}

	public String getBridgeSpanCombination() {
		return bridgeSpanCombination;
	}

	public void setBridgeSpanCombination(String bridgeSpanCombination) {
		this.bridgeSpanCombination = bridgeSpanCombination == null ? null : bridgeSpanCombination.trim();
	}

	public Date getBridgeRebuildDate() {
		return bridgeRebuildDate;
	}

	public void setBridgeRebuildDate(Date bridgeRebuildDate) {
		this.bridgeRebuildDate = bridgeRebuildDate;
	}

	public String getNavigationLevel() {
		return navigationLevel;
	}

	public void setNavigationLevel(String navigationLevel) {
		this.navigationLevel = navigationLevel == null ? null : navigationLevel.trim();
	}

	public Float getBridgeMaxHeadroom() {
		return bridgeMaxHeadroom;
	}

	public void setBridgeMaxHeadroom(Float bridgeMaxHeadroom) {
		this.bridgeMaxHeadroom = bridgeMaxHeadroom;
	}

	public Float getBridgeHeight() {
		return bridgeHeight;
	}

	public void setBridgeHeight(Float bridgeHeight) {
		this.bridgeHeight = bridgeHeight;
	}

	public Float getBridgeVerticalHeight() {
		return bridgeVerticalHeight;
	}

	public void setBridgeVerticalHeight(Float bridgeVerticalHeight) {
		this.bridgeVerticalHeight = bridgeVerticalHeight;
	}

	public Float getBridgeMidspanHeight() {
		return bridgeMidspanHeight;
	}

	public void setBridgeMidspanHeight(Float bridgeMidspanHeight) {
		this.bridgeMidspanHeight = bridgeMidspanHeight;
	}

	public String getBridgeWidthConbination() {
		return bridgeWidthConbination;
	}

	public void setBridgeWidthConbination(String bridgeWidthConbination) {
		this.bridgeWidthConbination = bridgeWidthConbination == null ? null : bridgeWidthConbination.trim();
	}

	public Float getBridgeOverallWidth() {
		return bridgeOverallWidth;
	}

	public void setBridgeOverallWidth(Float bridgeOverallWidth) {
		this.bridgeOverallWidth = bridgeOverallWidth;
	}

	public Float getBridgeHorizontalRadius() {
		return bridgeHorizontalRadius;
	}

	public void setBridgeHorizontalRadius(Float bridgeHorizontalRadius) {
		this.bridgeHorizontalRadius = bridgeHorizontalRadius;
	}

	public Float getBridgeHeadWidth() {
		return bridgeHeadWidth;
	}

	public void setBridgeHeadWidth(Float bridgeHeadWidth) {
		this.bridgeHeadWidth = bridgeHeadWidth;
	}

	public String getBridgeRiseSpanRatio() {
		return bridgeRiseSpanRatio;
	}

	public void setBridgeRiseSpanRatio(String bridgeRiseSpanRatio) {
		this.bridgeRiseSpanRatio = bridgeRiseSpanRatio == null ? null : bridgeRiseSpanRatio.trim();
	}

	public String getBridgeLongitudinalSlope() {
		return bridgeLongitudinalSlope;
	}

	public void setBridgeLongitudinalSlope(String bridgeLongitudinalSlope) {
		this.bridgeLongitudinalSlope = bridgeLongitudinalSlope == null ? null : bridgeLongitudinalSlope.trim();
	}

	public String getBridgeLinetype() {
		return bridgeLinetype;
	}

	public void setBridgeLinetype(String bridgeLinetype) {
		this.bridgeLinetype = bridgeLinetype == null ? null : bridgeLinetype.trim();
	}

	public String getBridgeGradeSeparation() {
		return bridgeGradeSeparation;
	}

	public void setBridgeGradeSeparation(String bridgeGradeSeparation) {
		this.bridgeGradeSeparation = bridgeGradeSeparation == null ? null : bridgeGradeSeparation.trim();
	}

	public String getBridgeIntersect() {
		return bridgeIntersect;
	}

	public void setBridgeIntersect(String bridgeIntersect) {
		this.bridgeIntersect = bridgeIntersect == null ? null : bridgeIntersect.trim();
	}

	@Override
	public String toString() {
		return "BridgeStructureEntity [bridgeId=" + bridgeId + ", manageObjectId=" + manageObjectId + ", bridgeStatus="
				+ bridgeStatus + ", bridgeCode=" + bridgeCode + ", bridgeTotalSpan=" + bridgeTotalSpan
				+ ", isWideroadNarrowbridge=" + isWideroadNarrowbridge + ", bridgeSpanCombination="
				+ bridgeSpanCombination + ", bridgeRebuildDate=" + bridgeRebuildDate + ", navigationLevel="
				+ navigationLevel + ", bridgeMaxHeadroom=" + bridgeMaxHeadroom + ", bridgeHeight=" + bridgeHeight
				+ ", bridgeVerticalHeight=" + bridgeVerticalHeight + ", bridgeMidspanHeight=" + bridgeMidspanHeight
				+ ", bridgeWidthConbination=" + bridgeWidthConbination + ", bridgeOverallWidth=" + bridgeOverallWidth
				+ ", bridgeHorizontalRadius=" + bridgeHorizontalRadius + ", bridgeHeadWidth=" + bridgeHeadWidth
				+ ", bridgeRiseSpanRatio=" + bridgeRiseSpanRatio + ", bridgeLongitudinalSlope="
				+ bridgeLongitudinalSlope + ", bridgeLinetype=" + bridgeLinetype + ", bridgeGradeSeparation="
				+ bridgeGradeSeparation + ", bridgeIntersect=" + bridgeIntersect + "]";
	}

}