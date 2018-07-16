/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.met.dao.metuser;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.met.entity.metuser.MetUser;

/**
 * 会议参会人员DAO接口
 * @author 王子鹏
 * @version 2018-06-24
 */
@MyBatisDao
public interface MetUserDao extends CrudDao<MetUser> {
	
}