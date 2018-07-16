/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.met.web.metuser;

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
import com.thinkgem.jeesite.modules.met.entity.metuser.MetUser;
import com.thinkgem.jeesite.modules.met.service.metuser.MetUserService;

/**
 * 会议参会人员Controller
 * @author 王子鹏
 * @version 2018-06-24
 */
@Controller
@RequestMapping(value = "${adminPath}/met/metuser/metUser")
public class MetUserController extends BaseController {

	@Autowired
	private MetUserService metUserService;
	
	@ModelAttribute
	public MetUser get(@RequestParam(required=false) String id) {
		MetUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = metUserService.get(id);
		}
		if (entity == null){
			entity = new MetUser();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(MetUser metUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MetUser> page = metUserService.findPage(new Page<MetUser>(request, response), metUser); 
		model.addAttribute("page", page);
		return "modules/met/metuser/metUserList";
	}

	@RequestMapping(value = "form")
	public String form(MetUser metUser, Model model) {
		model.addAttribute("metUser", metUser);
		return "modules/met/metuser/metUserForm";
	}

	@RequestMapping(value = "save")
	public String save(MetUser metUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, metUser)){
			return form(metUser, model);
		}
		metUserService.save(metUser);
		addMessage(redirectAttributes, "保存会议参会人员成功");
		return "redirect:"+Global.getAdminPath()+"/met/metuser/metUser/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(MetUser metUser, RedirectAttributes redirectAttributes) {
		metUserService.delete(metUser);
		addMessage(redirectAttributes, "删除会议参会人员成功");
		return "redirect:"+Global.getAdminPath()+"/met/metuser/metUser/?repage";
	}

}