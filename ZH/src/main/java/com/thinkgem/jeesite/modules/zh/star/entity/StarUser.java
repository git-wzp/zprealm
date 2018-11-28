/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.star.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 星迷模块用户Entity
 * @author 王子鹏
 * @version 2018-11-21
 */
public class StarUser extends DataEntity<StarUser> {
	
	private static final long serialVersionUID = 1L;
	private String loginName;		// 昵称
	private String password;		// 密码
	private String name;		// 姓名
	private String sex;		// 性别
	private String email;		// 邮箱
	private String phone;		// 电话
	private String photo;		// 用户头像
	private String starId;		// 守护星
	private String isFansadmin;		// 粉丝团管理员
	private String fansId;		// 管理粉丝团
	private String about;		// 个人简介
	private String loginIp;		// 最后登陆IP
	private Date loginDate;		// 最后登陆时间
	private String loginFlag;		// 是否可登录
	
	public StarUser() {
		super();
	}

	public StarUser(String id){
		super(id);
	}

	@NotNull
	@Length(min=1, max=100, message="昵称长度必须介于 1 和 100 之间")
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	@NotNull
	@Length(min=1, max=100, message="密码长度必须介于 1 和 100 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Length(min=0, max=100, message="姓名长度必须介于 0 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=1, message="性别长度必须介于 0 和 1 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=200, message="邮箱长度必须介于 0 和 200 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=0, max=200, message="电话长度必须介于 0 和 200 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=1000, message="用户头像长度必须介于 0 和 1000 之间")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Length(min=0, max=64, message="守护星长度必须介于 0 和 64 之间")
	public String getStarId() {
		return starId;
	}

	public void setStarId(String starId) {
		this.starId = starId;
	}
	
	@Length(min=0, max=1, message="粉丝团管理员长度必须介于 0 和 1 之间")
	public String getIsFansadmin() {
		return isFansadmin;
	}

	public void setIsFansadmin(String isFansadmin) {
		this.isFansadmin = isFansadmin;
	}
	
	@Length(min=0, max=64, message="管理粉丝团长度必须介于 0 和 64 之间")
	public String getFansId() {
		return fansId;
	}

	public void setFansId(String fansId) {
		this.fansId = fansId;
	}
	
	@Length(min=0, max=500, message="个人简介长度必须介于 0 和 500 之间")
	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	
	@Length(min=0, max=100, message="最后登陆IP长度必须介于 0 和 100 之间")
	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	@Length(min=0, max=64, message="是否可登录长度必须介于 0 和 64 之间")
	public String getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}
	
}