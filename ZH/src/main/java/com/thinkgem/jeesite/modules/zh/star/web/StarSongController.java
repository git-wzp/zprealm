/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.star.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.zh.star.entity.StarSong;
import com.thinkgem.jeesite.modules.zh.star.service.StarSongService;

/**
 * star音频Controller
 * @author 王子鹏
 * @version 2018-10-31
 */
@Controller
@RequestMapping(value = "${adminPath}/star/starSong")
public class StarSongController extends BaseController {

	@Autowired
	private StarSongService starSongService;
	
	@ModelAttribute
	public StarSong get(@RequestParam(required=false) String id) {
		StarSong entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = starSongService.get(id);
		}
		if (entity == null){
			entity = new StarSong();
		}
		return entity;
	}
	
	@RequiresPermissions("star:starSong:view")
	@RequestMapping(value = {"list", ""})
	public String list(StarSong starSong, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StarSong> page = starSongService.findPage(new Page<StarSong>(request, response), starSong); 
		model.addAttribute("page", page);
		return "zh/star/starSongList";
	}

	@RequiresPermissions("star:starSong:view")
	@RequestMapping(value = "form")
	public String form(StarSong starSong, Model model) {
		model.addAttribute("starSong", starSong);
		return "zh/star/starSongForm";
	}

	@RequiresPermissions("star:starSong:edit")
	@RequestMapping(value = "save")
	public String save(StarSong starSong, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, starSong)){
			return form(starSong, model);
		}
		starSongService.save(starSong);
		addMessage(redirectAttributes, "保存star音频成功");
		return "redirect:"+Global.getAdminPath()+"/star/starSong/?repage";
	}
	
	@RequiresPermissions("star:starSong:edit")
	@RequestMapping(value = "delete")
	public String delete(StarSong starSong, RedirectAttributes redirectAttributes) {
		starSongService.delete(starSong);
		addMessage(redirectAttributes, "删除star音频成功");
		return "redirect:"+Global.getAdminPath()+"/star/starSong/?repage";
	}

}