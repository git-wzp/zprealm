/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.met.entity.metrecorduser;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 会议与专家对照表Entity
 * @author 王子鹏
 * @version 2018-06-24
 */
public class MetRecordUser extends DataEntity<MetRecordUser> {
	
	private static final long serialVersionUID = 1L;
	private String muserId;		// 参会人id
	private String recordId;		// 会议记录id
	
	public MetRecordUser() {
		super();
	}

	public MetRecordUser(String id){
		super(id);
	}

	@Length(min=1, max=64, message="参会人id长度必须介于 1 和 64 之间")
	public String getMuserId() {
		return muserId;
	}

	public void setMuserId(String muserId) {
		this.muserId = muserId;
	}
	
	@Length(min=1, max=64, message="会议记录id长度必须介于 1 和 64 之间")
	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	
}