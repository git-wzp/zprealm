/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.star.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zh.star.entity.StarSong;
import com.thinkgem.jeesite.modules.zh.star.dao.StarSongDao;

/**
 * star音频Service
 * @author 王子鹏
 * @version 2018-10-31
 */
@Service
@Transactional(readOnly = true)
public class StarSongService extends CrudService<StarSongDao, StarSong> {

	public StarSong get(String id) {
		return super.get(id);
	}
	
	public List<StarSong> findList(StarSong starSong) {
		return super.findList(starSong);
	}
	
	public Page<StarSong> findPage(Page<StarSong> page, StarSong starSong) {
		return super.findPage(page, starSong);
	}
	
	@Transactional(readOnly = false)
	public void save(StarSong starSong) {
		super.save(starSong);
	}
	
	@Transactional(readOnly = false)
	public void delete(StarSong starSong) {
		super.delete(starSong);
	}
	
}