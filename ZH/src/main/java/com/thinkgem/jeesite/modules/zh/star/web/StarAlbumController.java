/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.star.web;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.zh.star.entity.StarAlbum;
import com.thinkgem.jeesite.modules.zh.star.service.StarAlbumService;
import com.thinkgem.jeesite.modules.zh.star.service.StarPhotoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 相册Controller
 * @author 王子鹏
 * @version 2018-11-06
 */
@Controller
@RequestMapping(value = "${adminPath}/star/starAlbum")
public class StarAlbumController extends BaseController {

	@Autowired
	private StarAlbumService starAlbumService;

	@Autowired
	private StarPhotoService starPhotoService ;

	
	@ModelAttribute
	public StarAlbum get(@RequestParam(required=false) String id) {
		StarAlbum entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = starAlbumService.get(id);
		}
		if (entity == null){
			entity = new StarAlbum();
		}
		return entity;
	}
	
	@RequiresPermissions("star:starAlbum:view")
	@RequestMapping(value = {"list", ""})
	public String list(StarAlbum starAlbum, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StarAlbum> page = starAlbumService.findPage(new Page<StarAlbum>(request, response), starAlbum); 
		model.addAttribute("page", page);
		return "zh/star/starAlbumList";
	}

	@RequiresPermissions("star:starAlbum:view")
	@RequestMapping(value = "form")
	public String form(StarAlbum starAlbum, Model model) {

//		String photoList = starAlbum.getPhotoUrls();
		model.addAttribute("starAlbum", starAlbum);

		return "zh/star/starAlbumForm";
	}

	@RequiresPermissions("star:starAlbum:edit")
	@RequestMapping(value = "save")
	public String save(StarAlbum starAlbum, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, starAlbum)){
			return form(starAlbum, model);
		}
 		starAlbumService.save(starAlbum);

		addMessage(redirectAttributes, "保存相册成功");
		return "redirect:"+Global.getAdminPath()+"/star/starAlbum/?repage";
	}
	
	@RequiresPermissions("star:starAlbum:edit")
	@RequestMapping(value = "delete")
	public String delete(StarAlbum starAlbum, RedirectAttributes redirectAttributes) {
		starAlbumService.delete(starAlbum);
		addMessage(redirectAttributes, "删除相册成功");
		return "redirect:"+Global.getAdminPath()+"/star/starAlbum/?repage";
	}

}