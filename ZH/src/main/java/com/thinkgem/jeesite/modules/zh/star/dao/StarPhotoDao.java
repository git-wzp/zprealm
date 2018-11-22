/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.star.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.zh.star.entity.StarPhoto;
import com.thinkgem.jeesite.modules.zh.star.entity.StarUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * star照片DAO接口
 * @author 王子鹏
 * @version 2018-11-05
 */
@MyBatisDao
public interface StarPhotoDao extends CrudDao<StarPhoto> {

    /**
     * 查询count个数的 背景图片
     */
    List<StarPhoto> findListBGPhoto(@Param("count") String count,@Param("starUser") StarUser starUser);
}