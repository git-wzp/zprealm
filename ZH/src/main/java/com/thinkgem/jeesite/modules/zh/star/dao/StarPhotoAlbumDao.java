/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.star.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.zh.star.entity.StarAlbum;
import com.thinkgem.jeesite.modules.zh.star.entity.StarPhoto;
import com.thinkgem.jeesite.modules.zh.star.entity.StarPhotoAlbum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 图片相册关联信息DAO接口
 * @author 王子鹏
 * @version 2018-11-07
 */
@MyBatisDao
public interface StarPhotoAlbumDao extends CrudDao<StarPhotoAlbum> {

    /**
     * 通过url查询到photoID  写在一个sql里 提高效率
     */
    int insert(@Param("entity")StarPhotoAlbum entity,@Param("photoUrls") List urls);

    List<StarPhoto> findListByAlbum(@Param("starAlbum")StarAlbum starAlbum);
}