/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.star.web;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.zh.star.entity.StarPhoto;
import com.thinkgem.jeesite.modules.zh.star.entity.StarStarmessage;
import com.thinkgem.jeesite.modules.zh.star.service.StarPhotoService;
import com.thinkgem.jeesite.modules.zh.star.service.StarStarmessageService;
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
 * star照片Controller
 * @author 王子鹏
 * @version 2018-11-05
 */
@Controller
@RequestMapping(value = "${adminPath}/star/starPhoto")
public class StarPhotoController extends BaseController {

	@Autowired
	private StarPhotoService starPhotoService;
	@Autowired
	private StarStarmessageService starStarmessageService;
	
	@ModelAttribute
	public StarPhoto get(@RequestParam(required=false) String id) {
		StarPhoto entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = starPhotoService.get(id);
		}
		if (entity == null){
			entity = new StarPhoto();
		}
		return entity;
	}
	
	@RequiresPermissions("star:starPhoto:view")
	@RequestMapping(value = {"list", ""})
	public String list(StarPhoto starPhoto, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StarPhoto> page = starPhotoService.findPage(new Page<StarPhoto>(request, response), starPhoto); 
		model.addAttribute("page", page);
		return "zh/star/starPhotoList";
	}

	@RequiresPermissions("star:starPhoto:view")
	@RequestMapping(value = "form")
	public String form(StarPhoto starPhoto, Model model) {
		if(starPhoto.getId()!=null){
			StarStarmessage starStarmessage = starStarmessageService.get(starPhoto.getStarId());
			starPhoto.setStarName(starStarmessage.getName());
		}
		model.addAttribute("starPhoto", starPhoto);

		return "zh/star/starPhotoForm";
	}

	@RequiresPermissions("star:starPhoto:edit")
	@RequestMapping(value = "save")
	public String save(StarPhoto starPhoto, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, starPhoto)){
			return form(starPhoto, model);
		}
		starPhotoService.save(starPhoto);
		addMessage(redirectAttributes, "保存star照片成功");
		return "redirect:"+Global.getAdminPath()+"/star/starPhoto/?repage";
	}
	
	@RequiresPermissions("star:starPhoto:edit")
	@RequestMapping(value = "delete")
	public String delete(StarPhoto starPhoto, RedirectAttributes redirectAttributes) {
		starPhotoService.delete(starPhoto);
		addMessage(redirectAttributes, "删除star照片成功");
		return "redirect:"+Global.getAdminPath()+"/star/starPhoto/?repage";
	}



}