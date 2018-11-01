/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.star.entity;

import com.thinkgem.jeesite.modules.sys.entity.User;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 相册Entity
 * @author 王子鹏
 * @version 2018-10-31
 */
public class StarAlbum extends DataEntity<StarAlbum> {
	
	private static final long serialVersionUID = 1L;
	private User user;		// 所属用户
	private String name;		// 相册名称
	
	public StarAlbum() {
		super();
	}

	public StarAlbum(String id){
		super(id);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Length(min=0, max=255, message="相册名称长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}