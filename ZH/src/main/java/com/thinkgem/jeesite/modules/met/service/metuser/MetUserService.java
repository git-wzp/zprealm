/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.met.service.metuser;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.met.entity.metuser.MetUser;
import com.thinkgem.jeesite.modules.met.dao.metuser.MetUserDao;

/**
 * 会议参会人员Service
 * @author 王子鹏
 * @version 2018-06-24
 */
@Service
@Transactional(readOnly = true)
public class MetUserService extends CrudService<MetUserDao, MetUser> {

	public MetUser get(String id) {
		return super.get(id);
	}
	
	public List<MetUser> findList(MetUser metUser) {
		return super.findList(metUser);
	}
	
	public Page<MetUser> findPage(Page<MetUser> page, MetUser metUser) {
		return super.findPage(page, metUser);
	}
	
	@Transactional(readOnly = false)
	public void save(MetUser metUser) {
		super.save(metUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(MetUser metUser) {
		super.delete(metUser);
	}
	
}