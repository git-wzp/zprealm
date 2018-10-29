/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.service.star;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zh.entity.star.StarStarmessage;
import com.thinkgem.jeesite.modules.zh.dao.star.StarStarmessageDao;

/**
 * 明星资料Service
 * @author 王子鹏
 * @version 2018-10-29
 */
@Service
@Transactional(readOnly = true)
public class StarStarmessageService extends CrudService<StarStarmessageDao, StarStarmessage> {

	public StarStarmessage get(String id) {
		return super.get(id);
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