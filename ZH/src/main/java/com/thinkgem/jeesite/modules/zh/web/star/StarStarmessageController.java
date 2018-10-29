/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.web.star;

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
import com.thinkgem.jeesite.modules.zh.entity.star.StarStarmessage;
import com.thinkgem.jeesite.modules.zh.service.star.StarStarmessageService;

/**
 * 明星资料Controller
 * @author 王子鹏
 * @version 2018-10-29
 */
@Controller
@RequestMapping(value = "${adminPath}/zh/star/starStarmessage")
public class StarStarmessageController extends BaseController {

	@Autowired
	private StarStarmessageService starStarmessageService;
	
	@ModelAttribute
	public StarStarmessage get(@RequestParam(required=false) String id) {
		StarStarmessage entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = starStarmessageService.get(id);
		}
		if (entity == null){
			entity = new StarStarmessage();
		}
		return entity;
	}
	
	@RequiresPermissions("zh:star:starStarmessage:view")
	@RequestMapping(value = {"list", ""})
	public String list(StarStarmessage starStarmessage, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StarStarmessage> page = starStarmessageService.findPage(new Page<StarStarmessage>(request, response), starStarmessage); 
		model.addAttribute("page", page);
		return "modules/zh/star/starStarmessageList";
	}

	@RequiresPermissions("zh:star:starStarmessage:view")
	@RequestMapping(value = "form")
	public String form(StarStarmessage starStarmessage, Model model) {
		model.addAttribute("starStarmessage", starStarmessage);
		return "modules/zh/star/starStarmessageForm";
	}

	@RequiresPermissions("zh:star:starStarmessage:edit")
	@RequestMapping(value = "save")
	public String save(StarStarmessage starStarmessage, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, starStarmessage)){
			return form(starStarmessage, model);
		}
		starStarmessageService.save(starStarmessage);
		addMessage(redirectAttributes, "保存star资料成功");
		return "redirect:"+Global.getAdminPath()+"/zh/star/starStarmessage/?repage";
	}
	
	@RequiresPermissions("zh:star:starStarmessage:edit")
	@RequestMapping(value = "delete")
	public String delete(StarStarmessage starStarmessage, RedirectAttributes redirectAttributes) {
		starStarmessageService.delete(starStarmessage);
		addMessage(redirectAttributes, "删除star资料成功");
		return "redirect:"+Global.getAdminPath()+"/zh/star/starStarmessage/?repage";
	}

}