/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.met.service.metrecord;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.met.entity.metrecord.MetRecord;
import com.thinkgem.jeesite.modules.met.dao.metrecord.MetRecordDao;

/**
 * 会议记录信息Service
 * @author 王子鹏
 * @version 2018-06-24
 */
@Service
@Transactional(readOnly = true)
public class MetRecordService extends CrudService<MetRecordDao, MetRecord> {

	public MetRecord get(String id) {
		return super.get(id);
	}
	
	public List<MetRecord> findList(MetRecord metRecord) {
		return super.findList(metRecord);
	}
	
	public Page<MetRecord> findPage(Page<MetRecord> page, MetRecord metRecord) {
		return super.findPage(page, metRecord);
	}
	
	@Transactional(readOnly = false)
	public void save(MetRecord metRecord) {
		super.save(metRecord);
	}
	
	@Transactional(readOnly = false)
	public void delete(MetRecord metRecord) {
		super.delete(metRecord);
	}
	
}