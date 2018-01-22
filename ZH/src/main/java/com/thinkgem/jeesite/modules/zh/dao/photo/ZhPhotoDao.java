/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.dao.photo;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.zh.entity.photo.ZhPhoto;

/**
 * 壁纸图片DAO接口
 * @author 王子鹏
 * @version 2018-01-22
 */
@MyBatisDao
public interface ZhPhotoDao extends CrudDao<ZhPhoto> {
	
}