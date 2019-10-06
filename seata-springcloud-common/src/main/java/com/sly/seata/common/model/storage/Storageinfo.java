package com.sly.seata.common.model.storage;

import java.io.Serializable;

/**
 * 仓储实体类
 * 
 * @author sly
 * @time 2019年6月10日
 */
public class Storageinfo implements Serializable {

	private static final long serialVersionUID = 2354844711437514051L;

	/** varchar(32) NOT NULL主键uuid */
	private String storage2Id;
	/** varchar(32) NULL仓储名称 */
	private String storage2Name;
	/** int(11) NULL数量 */
	private Integer storage2Count;
	/** char(1) NULL逻辑删除 Y:删除 N:未删除 */
	private String logic2Del;
	/** varchar(240) NULL备注 */
	private String remark2;

	public String getStorage2Id() {
		return storage2Id;
	}

	public void setStorage2Id(String storage2Id) {
		this.storage2Id = storage2Id;
	}

	public String getStorage2Name() {
		return storage2Name;
	}

	public void setStorage2Name(String storage2Name) {
		this.storage2Name = storage2Name;
	}

	public Integer getStorage2Count() {
		return storage2Count;
	}

	public void setStorage2Count(Integer storage2Count) {
		this.storage2Count = storage2Count;
	}

	public String getLogic2Del() {
		return logic2Del;
	}

	public void setLogic2Del(String logic2Del) {
		this.logic2Del = logic2Del;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

}
