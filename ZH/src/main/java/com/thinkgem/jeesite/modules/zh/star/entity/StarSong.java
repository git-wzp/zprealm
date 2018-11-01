/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.star.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * star音频Entity
 * @author 王子鹏
 * @version 2018-10-31
 */
public class StarSong extends DataEntity<StarSong> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 歌曲名
	private String url;		// 请求路径
	
	public StarSong() {
		super();
	}

	public StarSong(String id){
		super(id);
	}

	@Length(min=0, max=50, message="歌曲名长度必须介于 0 和 50 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="请求路径长度必须介于 0 和 255 之间")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}