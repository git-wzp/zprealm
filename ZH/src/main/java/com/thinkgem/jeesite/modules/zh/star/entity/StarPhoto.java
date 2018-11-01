/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.star.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * star照片Entity
 * @author 王子鹏
 * @version 2018-10-31
 */
public class StarPhoto extends DataEntity<StarPhoto> {
	
	private static final long serialVersionUID = 1L;
	private String starId;		// 明星id
	private String url;		// 路径
	private String title;		// 标题
	
	public StarPhoto() {
		super();
	}

	public StarPhoto(String id){
		super(id);
	}

	@Length(min=0, max=32, message="明星id长度必须介于 0 和 32 之间")
	public String getStarId() {
		return starId;
	}

	public void setStarId(String starId) {
		this.starId = starId;
	}
	
	@Length(min=0, max=255, message="路径长度必须介于 0 和 255 之间")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Length(min=0, max=255, message="标题长度必须介于 0 和 255 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}