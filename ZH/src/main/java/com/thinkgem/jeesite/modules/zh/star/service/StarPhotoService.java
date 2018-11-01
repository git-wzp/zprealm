/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.star.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zh.star.entity.StarPhoto;
import com.thinkgem.jeesite.modules.zh.star.dao.StarPhotoDao;

/**
 * star照片Service
 * @author 王子鹏
 * @version 2018-10-31
 */
@Service
@Transactional(readOnly = true)
public class StarPhotoService extends CrudService<StarPhotoDao, StarPhoto> {

	public StarPhoto get(String id) {
		return super.get(id);
	}
	
	public List<StarPhoto> findList(StarPhoto starPhoto) {
		return super.findList(starPhoto);
	}
	
	public Page<StarPhoto> findPage(Page<StarPhoto> page, StarPhoto starPhoto) {
		return super.findPage(page, starPhoto);
	}
	
	@Transactional(readOnly = false)
	public void save(StarPhoto starPhoto) {
		super.save(starPhoto);
	}
	
	@Transactional(readOnly = false)
	public void delete(StarPhoto starPhoto) {
		super.delete(starPhoto);
	}
	
}