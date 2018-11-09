/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.star.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.zh.star.dao.StarAlbumDao;
import com.thinkgem.jeesite.modules.zh.star.dao.StarPhotoAlbumDao;
import com.thinkgem.jeesite.modules.zh.star.dao.StarPhotoDao;
import com.thinkgem.jeesite.modules.zh.star.entity.StarAlbum;
import com.thinkgem.jeesite.modules.zh.star.entity.StarPhoto;
import com.thinkgem.jeesite.modules.zh.star.entity.StarPhotoAlbum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 相册Service
 * @author 王子鹏
 * @version 2018-11-06
 */
@Service
@Transactional(readOnly = true)
public class StarAlbumService extends CrudService<StarAlbumDao, StarAlbum> {

    @Autowired
    private StarAlbumDao starAlbumDao;
    @Autowired
    private StarPhotoAlbumDao starPhotoAlbumDao;
    @Autowired
    private StarPhotoDao starPhotoDao;

    public StarAlbum get(String id) {
        StarAlbum starAlbum = super.get(id);
        List photoUrls = starAlbumDao.getPhotoUrls(id);
        starAlbum.setPhotoUrls(photoUrls.toString().replace(",", "|").replace("[", "").replace("]", ""));
        return starAlbum;
    }

    public List<StarAlbum> findList(StarAlbum starAlbum) {
        return super.findList(starAlbum);
    }

    public Page<StarAlbum> findPage(Page<StarAlbum> page, StarAlbum starAlbum) {
        return super.findPage(page, starAlbum);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(StarAlbum starAlbum) {
        List list1 = new ArrayList();
        for (String s : starAlbum.getPhotoUrls().split("\\|")) {
            if (!"".equals(s) ){
                StarPhoto starP = new StarPhoto();
//        1:保存图片
                    starP.setUrl(s);
                    starP.preInsert();
                    starP.setStarId(starAlbum.getStarIds());
                    starP.setType("3"); //默认设置类型为生活照片
                    starP.setRemarks("保存相册时添加图片");
                    starPhotoDao.insert(starP);
                list1.add(s);
            }
        }


//      2:保存相册
        super.save(starAlbum);

//		3:添加关联关系
        StarPhotoAlbum starPhotoAlbum = new StarPhotoAlbum();
        starPhotoAlbum.setAlbumId(starAlbum.getId());
        List<StarPhotoAlbum> list = starPhotoAlbumDao.findList(starPhotoAlbum);
        for (StarPhotoAlbum s : list) {
            starPhotoAlbumDao.delete(s);
        }
        starPhotoAlbum.setCreateBy(UserUtils.getUser());
        starPhotoAlbum.setUpdateBy(UserUtils.getUser());
        starPhotoAlbum.setCreateDate(new Date());
        starPhotoAlbum.setUpdateDate(new Date());
        if(list1.size()>0){
            starPhotoAlbumDao.insert(starPhotoAlbum, list1);
        }

    }

    @Transactional(readOnly = false)
    public void delete(StarAlbum starAlbum) {
        super.delete(starAlbum);
    }

}