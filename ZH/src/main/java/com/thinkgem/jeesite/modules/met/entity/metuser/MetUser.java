/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.met.entity.metuser;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 会议参会人员Entity
 * @author 王子鹏
 * @version 2018-06-24
 */
public class MetUser extends DataEntity<MetUser> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 客户姓名
	private String telephoneNumber;		// 客户手机号
	private String bankNumber;		// 银行卡号
	private String bankName;		// 开户行名称
	
	public MetUser() {
		super();
	}

	public MetUser(String id){
		super(id);
	}

	@Length(min=0, max=50, message="客户姓名长度必须介于 0 和 50 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=11, message="客户手机号长度必须介于 0 和 11 之间")
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	
	@Length(min=0, max=26, message="银行卡号长度必须介于 0 和 26 之间")
	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}
	
	@Length(min=0, max=50, message="开户行名称长度必须介于 0 和 50 之间")
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
}