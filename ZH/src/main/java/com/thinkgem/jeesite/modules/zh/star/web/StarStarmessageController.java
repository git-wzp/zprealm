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
import com.thinkgem.jeesite.modules.zh.star.entity.StarStarmessage;
import com.thinkgem.jeesite.modules.zh.star.service.StarStarmessageService;
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
 * 明星资料Controller
 * @author 王子鹏
 * @version 2018-10-31
 */
@Controller
@RequestMapping(value = "${adminPath}/star/starStarmessage")
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
	
	@RequiresPermissions("star:starStarmessage:view")
	@RequestMapping(value = {"list", ""})
	public String list(StarStarmessage starStarmessage, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<StarStarmessage> page = starStarmessageService.findPage(new Page<StarStarmessage>(request, response), starStarmessage); 
		model.addAttribute("page", page);
		return "zh/star/starStarmessageList";
	}

	@RequiresPermissions("star:starStarmessage:view")
	@RequestMapping(value = "form")
	public String form(StarStarmessage starStarmessage, Model model) {
		model.addAttribute("starStarmessage", starStarmessage);
		return "zh/star/starStarmessageForm";
	}

	@RequiresPermissions("star:starStarmessage:edit")
	@RequestMapping(value = "save")
	public String save(StarStarmessage starStarmessage, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, starStarmessage)){
			return form(starStarmessage, model);
		}
		starStarmessageService.save(starStarmessage);
		addMessage(redirectAttributes, "保存star资料成功");
		return "redirect:"+Global.getAdminPath()+"/star/starStarmessage/?repage";
	}
	
	@RequiresPermissions("star:starStarmessage:edit")
	@RequestMapping(value = "delete")
	public String delete(StarStarmessage starStarmessage, RedirectAttributes redirectAttributes) {
		starStarmessageService.delete(starStarmessage);
		addMessage(redirectAttributes, "删除star资料成功");
		return "redirect:"+Global.getAdminPath()+"/star/starStarmessage/?repage";
	}

	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<StarStarmessage> list = starStarmessageService.findList(new StarStarmessage());
		for (int i=0; i<list.size(); i++){
			StarStarmessage e = list.get(i);
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", "u_"+e.getId());
			map.put("name", StringUtils.replace(e.getName(), " ", ""));
			mapList.add(map);
		}
		return mapList;
	}

}