/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.met.service.metrecorduser;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.met.entity.metrecorduser.MetRecordUser;
import com.thinkgem.jeesite.modules.met.dao.metrecorduser.MetRecordUserDao;

/**
 * 会议与专家对照表Service
 * @author 王子鹏
 * @version 2018-06-24
 */
@Service
@Transactional(readOnly = true)
public class MetRecordUserService extends CrudService<MetRecordUserDao, MetRecordUser> {

	public MetRecordUser get(String id) {
		return super.get(id);
	}
	
	public List<MetRecordUser> findList(MetRecordUser metRecordUser) {
		return super.findList(metRecordUser);
	}
	
	public Page<MetRecordUser> findPage(Page<MetRecordUser> page, MetRecordUser metRecordUser) {
		return super.findPage(page, metRecordUser);
	}
	
	@Transactional(readOnly = false)
	public void save(MetRecordUser metRecordUser) {
		super.save(metRecordUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(MetRecordUser metRecordUser) {
		super.delete(metRecordUser);
	}
	
}