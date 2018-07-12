package com.ande.bridge.admin.model;

/**
 * @author tingzhanGuo@la-inc.cn
 * @date 2018年5月26日---上午11:44:49
 * @Description 桥梁全部信息的实体类>>用于接收前端所有信息
 */
public class BridgeEntity {
	private BridgeMainEntity bridgeMainEntity; // Bridge的主表对象
	private BridgeBaseEntity bridgeBaseEntity; // Bridge的基础信息对象
	private BridgeStructureEntity bridgeStructureEntity; // Bridge的结构表对象
	private BridgeEconomicEntity bridgeEconomicEntity; // Bridge的经济表对象
	private BridgeManageEntity bridgeManageEntity; // Bridge的管理表对象

	public BridgeMainEntity getBridgeMainEntity() {
		return bridgeMainEntity;
	}

	public void setBridgeMainEntity(BridgeMainEntity bridgeMainEntity) {
		this.bridgeMainEntity = bridgeMainEntity;
	}

	public BridgeBaseEntity getBridgeBaseEntity() {
		return bridgeBaseEntity;
	}

	public void setBridgeBaseEntity(BridgeBaseEntity bridgeBaseEntity) {
		this.bridgeBaseEntity = bridgeBaseEntity;
	}

	public BridgeStructureEntity getBridgeStructureEntity() {
		return bridgeStructureEntity;
	}

	public void setBridgeStructureEntity(BridgeStructureEntity bridgeStructureEntity) {
		this.bridgeStructureEntity = bridgeStructureEntity;
	}

	public BridgeEconomicEntity getBridgeEconomicEntity() {
		return bridgeEconomicEntity;
	}

	public void setBridgeEconomicEntity(BridgeEconomicEntity bridgeEconomicEntity) {
		this.bridgeEconomicEntity = bridgeEconomicEntity;
	}

	public BridgeManageEntity getBridgeManageEntity() {
		return bridgeManageEntity;
	}

	public void setBridgeManageEntity(BridgeManageEntity bridgeManageEntity) {
		this.bridgeManageEntity = bridgeManageEntity;
	}

	@Override
	public String toString() {
		return "BridgeEntity [bridgeMainEntity=" + bridgeMainEntity + ", bridgeBaseEntity=" + bridgeBaseEntity
				+ ", bridgeStructureEntity=" + bridgeStructureEntity + ", bridgeEconomicEntity=" + bridgeEconomicEntity
				+ ", bridgeManageEntity=" + bridgeManageEntity + "]";
	}

}
