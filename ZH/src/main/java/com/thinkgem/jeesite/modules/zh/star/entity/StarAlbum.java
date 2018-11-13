/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.star.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;
import org.hibernate.validator.constraints.Length;

import java.util.List;

/**
 * 相册Entity
 * @author 王子鹏
 * @version 2018-11-06
 */
public class StarAlbum extends DataEntity<StarAlbum> {
	
	private static final long serialVersionUID = 1L;
	private User user;		// 所属用户
	private String name;		// 相册名称
	private String starIds;		// 所属star
	private String url;		// 相册封面
	private String isShow;		// 是否公开
	private Integer showCount;		// 浏览次数
	private String  photoUrls;   //相册图片url
	private List<StarPhoto> photoList;  //相册里的图片对象

	@JsonIgnore
	public List<StarPhoto> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<StarPhoto> photoList) {
		this.photoList = photoList;
	}

	public String getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(String photoUrls) {
		this.photoUrls = photoUrls;
	}

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
	
	@Length(min=0, max=255, message="所属star长度必须介于 0 和 255 之间")
	public String getStarIds() {
		return starIds;
	}

	public void setStarIds(String starIds) {
		this.starIds = starIds;
	}
	
	@Length(min=0, max=255, message="相册封面长度必须介于 0 和 255 之间")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Length(min=0, max=1, message="是否公开长度必须介于 0 和 1 之间")
	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	
	public Integer getShowCount() {
		return showCount;
	}

	public void setShowCount(Integer showCount) {
		this.showCount = showCount;
	}
	
}