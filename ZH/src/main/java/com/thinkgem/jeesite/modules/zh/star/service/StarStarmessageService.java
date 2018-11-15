/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.star.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zh.star.dao.StarPhotoDao;
import com.thinkgem.jeesite.modules.zh.star.dao.StarStarmessageDao;
import com.thinkgem.jeesite.modules.zh.star.entity.StarPhoto;
import com.thinkgem.jeesite.modules.zh.star.entity.StarStarmessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 明星资料Service
 * @author 王子鹏
 * @version 2018-10-31
 */
@Service
@Transactional(readOnly = true)
public class StarStarmessageService extends CrudService<StarStarmessageDao, StarStarmessage> {

	@Autowired
	private StarPhotoDao starPhotoDao;
	public StarStarmessage get(String id) {
		StarStarmessage starStarmessage = super.get(id);
		if(id!=null && id != "" ) {
			StarPhoto starPhoto = new StarPhoto();
			starPhoto.setType("2");
			starPhoto.setStarId(id);
			List<StarPhoto> list = starPhotoDao.findList(starPhoto);
			if (list.size() >= 2) {
				starStarmessage.setAboutPhoto1(list.get(0).getUrl());
				starStarmessage.setAboutPhoto2(list.get(1).getUrl());
			}
		}
		return starStarmessage;
	}
	
	public List<StarStarmessage> findList(StarStarmessage starStarmessage) {
		return super.findList(starStarmessage);
	}
	
	public Page<StarStarmessage> findPage(Page<StarStarmessage> page, StarStarmessage starStarmessage) {
		return super.findPage(page, starStarmessage);
	}
	
	@Transactional(readOnly = false)
	public void save(StarStarmessage starStarmessage) {
		super.save(starStarmessage);
	}
	
	@Transactional(readOnly = false)
	public void delete(StarStarmessage starStarmessage) {
		super.delete(starStarmessage);
	}
	
}