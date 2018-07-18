/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.met.web.metrecorduser;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.met.entity.metrecorduser.MetRecordUser;
import com.thinkgem.jeesite.modules.met.service.metrecorduser.MetRecordUserService;
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
 * 会议与专家对照表Controller
 * @author 王子鹏
 * @version 2018-06-24
 */
@Controller
@RequestMapping(value = "${adminPath}/met/metrecorduser/metRecordUser")
public class MetRecordUserController extends BaseController {

	@Autowired
	private MetRecordUserService metRecordUserService;
	
	@ModelAttribute
	public MetRecordUser get(@RequestParam(required=false) String id) {
		MetRecordUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = metRecordUserService.get(id);
		}
		if (entity == null){
			entity = new MetRecordUser();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(MetRecordUser metRecordUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MetRecordUser> page = metRecordUserService.findPage(new Page<MetRecordUser>(request, response), metRecordUser); 
		model.addAttribute("page", page);
		return "modules/met/metrecorduser/metRecordUserList";
	}

	@RequestMapping(value = "form")
	public String form(MetRecordUser metRecordUser, Model model) {
		model.addAttribute("metRecordUser", metRecordUser);
		return "modules/met/metrecorduser/metRecordUserForm";
	}

	@RequestMapping(value = "save")
	@RequiresPermissions("met:metrecord:metRecord:edit")
	public String save(MetRecordUser metRecordUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, metRecordUser)){
			return form(metRecordUser, model);
		}
		metRecordUserService.save(metRecordUser);
		addMessage(redirectAttributes, "保存会议-专家对照信息成功");
		return "redirect:"+Global.getAdminPath()+"/met/metrecorduser/metRecordUser/?repage";
	}
	
	@RequestMapping(value = "delete")
    @RequiresPermissions("met:metrecord:metRecord:edit")
	public String delete(MetRecordUser metRecordUser, RedirectAttributes redirectAttributes) {
		metRecordUserService.delete(metRecordUser);
		addMessage(redirectAttributes, "删除会议-专家对照信息成功");
		return "redirect:"+Global.getAdminPath()+"/met/metrecorduser/metRecordUser/?repage";
	}

}