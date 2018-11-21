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
import com.thinkgem.jeesite.modules.zh.star.entity.StarUser;
import com.thinkgem.jeesite.modules.zh.star.service.StarUserService;

/**
 * 星迷模块用户Controller
 * @author 王子鹏
 * @version 2018-11-21
 */
@Controller
@RequestMapping(value = "${adminPath}/star/starUser")
public class StarUserController extends BaseController {

	@Autowired
	private StarUserService starUserService;
	
	@ModelAttribute
	public StarUser get(@RequestParam(required=false) String id) {
		StarUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = starUserService.get(id);
		}
		if (entity == null){
			entity = new StarUser();
		}
		return entity;
	}
	
	@RequiresPermissions("star:starUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(StarUser starUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StarUser> page = starUserService.findPage(new Page<StarUser>(request, response), starUser); 
		model.addAttribute("page", page);
		return "zh/star/starUserList";
	}

	@RequiresPermissions("star:starUser:view")
	@RequestMapping(value = "form")
	public String form(StarUser starUser, Model model) {
		model.addAttribute("starUser", starUser);
		return "zh/star/starUserForm";
	}

	@RequiresPermissions("star:starUser:edit")
	@RequestMapping(value = "save")
	public String save(StarUser starUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, starUser)){
			return form(starUser, model);
		}
		starUserService.save(starUser);
		addMessage(redirectAttributes, "保存用户成功");
		return "redirect:"+Global.getAdminPath()+"/star/starUser/?repage";
	}
	
	@RequiresPermissions("star:starUser:edit")
	@RequestMapping(value = "delete")
	public String delete(StarUser starUser, RedirectAttributes redirectAttributes) {
		starUserService.delete(starUser);
		addMessage(redirectAttributes, "删除用户成功");
		return "redirect:"+Global.getAdminPath()+"/star/starUser/?repage";
	}

}