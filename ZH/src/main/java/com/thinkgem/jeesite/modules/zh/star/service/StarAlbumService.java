/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.star.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zh.star.entity.StarAlbum;
import com.thinkgem.jeesite.modules.zh.star.dao.StarAlbumDao;

/**
 * 相册Service
 * @author 王子鹏
 * @version 2018-10-31
 */
@Service
@Transactional(readOnly = true)
public class StarAlbumService extends CrudService<StarAlbumDao, StarAlbum> {

	public StarAlbum get(String id) {
		return super.get(id);
	}
	
	public List<StarAlbum> findList(StarAlbum starAlbum) {
		return super.findList(starAlbum);
	}
	
	public Page<StarAlbum> findPage(Page<StarAlbum> page, StarAlbum starAlbum) {
		return super.findPage(page, starAlbum);
	}
	
	@Transactional(readOnly = false)
	public void save(StarAlbum starAlbum) {
		super.save(starAlbum);
	}
	
	@Transactional(readOnly = false)
	public void delete(StarAlbum starAlbum) {
		super.delete(starAlbum);
	}
	
}