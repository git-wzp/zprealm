/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.star.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 图片相册关联信息Entity
 * @author 王子鹏
 * @version 2018-11-07
 */
public class StarPhotoAlbum extends DataEntity<StarPhotoAlbum> {
	
	private static final long serialVersionUID = 1L;
	private String photoId;		// photo_id
	private String albumId;		// album_id
	
	public StarPhotoAlbum() {
		super();
	}

	public StarPhotoAlbum(String id){
		super(id);
	}

	@Length(min=0, max=32, message="photo_id长度必须介于 0 和 32 之间")
	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}
	
	@Length(min=0, max=32, message="album_id长度必须介于 0 和 32 之间")
	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}
	
}