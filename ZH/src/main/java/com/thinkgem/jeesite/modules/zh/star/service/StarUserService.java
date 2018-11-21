/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.star.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zh.star.entity.StarUser;
import com.thinkgem.jeesite.modules.zh.star.dao.StarUserDao;

/**
 * 星迷模块用户Service
 * @author 王子鹏
 * @version 2018-11-21
 */
@Service
@Transactional(readOnly = true)
public class StarUserService extends CrudService<StarUserDao, StarUser> {

	public StarUser get(String id) {
		return super.get(id);
	}
	
	public List<StarUser> findList(StarUser starUser) {
		return super.findList(starUser);
	}
	
	public Page<StarUser> findPage(Page<StarUser> page, StarUser starUser) {
		return super.findPage(page, starUser);
	}
	
	@Transactional(readOnly = false)
	public void save(StarUser starUser) {
		super.save(starUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(StarUser starUser) {
		super.delete(starUser);
	}
	
}