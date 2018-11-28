/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.star.web;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.zh.star.entity.StarUser;
import com.thinkgem.jeesite.modules.zh.star.service.StarUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

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


	/**
	 * 选择star用户
	 <sys:treeselect id="starUser" name="id" value="${starUser.id}" labelName="name"
	                              labelValue="${fnz:getStarUserName(starUser.id)}"
	                              title="用户" url="/star/starUser/treeData" cssClass="" allowClear="true"
	                              notAllowSelectParent="true"/>
	 * @param response
	 * @return
	 */
	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<StarUser> list = starUserService.findList(new StarUser());
		for (int i=0; i<list.size(); i++){
			StarUser e = list.get(i);
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", "u_"+e.getId());
			map.put("name", StringUtils.replace(e.getLoginName(), " ", ""));
			mapList.add(map);
		}
		return mapList;
	}


}