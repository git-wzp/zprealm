/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.service.photo;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zh.entity.photo.ZhPhoto;
import com.thinkgem.jeesite.modules.zh.dao.photo.ZhPhotoDao;

/**
 * 壁纸图片Service
 * @author 王子鹏
 * @version 2018-01-22
 */
@Service
@Transactional(readOnly = true)
public class ZhPhotoService extends CrudService<ZhPhotoDao, ZhPhoto> {

	public ZhPhoto get(String id) {
		return super.get(id);
	}
	
	public List<ZhPhoto> findList(ZhPhoto zhPhoto) {
		return super.findList(zhPhoto);
	}
	
	public Page<ZhPhoto> findPage(Page<ZhPhoto> page, ZhPhoto zhPhoto) {
		return super.findPage(page, zhPhoto);
	}
	
	@Transactional(readOnly = false)
	public void save(ZhPhoto zhPhoto) {
		super.save(zhPhoto);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZhPhoto zhPhoto) {
		super.delete(zhPhoto);
	}
	
}