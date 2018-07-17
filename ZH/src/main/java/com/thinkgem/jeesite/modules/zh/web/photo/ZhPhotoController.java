/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zh.web.photo;

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
import com.thinkgem.jeesite.modules.zh.entity.photo.ZhPhoto;
import com.thinkgem.jeesite.modules.zh.service.photo.ZhPhotoService;

/**
 * 壁纸图片Controller
 * @author 王子鹏
 * @version 2018-01-22
 */
@Controller
@RequestMapping(value = "${adminPath}/zh/photo/zhPhoto")
public class ZhPhotoController extends BaseController {

	@Autowired
	private ZhPhotoService zhPhotoService;
	
	@ModelAttribute
	public ZhPhoto get(@RequestParam(required=false) String id) {
		ZhPhoto entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zhPhotoService.get(id);
		}
		if (entity == null){
			entity = new ZhPhoto();
		}
		return entity;
	}
	
	@RequiresPermissions("zh:photo:zhPhoto:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZhPhoto zhPhoto, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZhPhoto> page = zhPhotoService.findPage(new Page<ZhPhoto>(request, response), zhPhoto); 
		model.addAttribute("page", page);
		return "modules/zh/photo/zhPhotoList";
	}

	@RequiresPermissions("zh:photo:zhPhoto:view")
	@RequestMapping(value = "form")
	public String form(ZhPhoto zhPhoto, Model model) {
		model.addAttribute("zhPhoto", zhPhoto);
		return "modules/zh/photo/zhPhotoForm";
	}

	@RequiresPermissions("zh:photo:zhPhoto:edit")
	@RequestMapping(value = "save")
	public String save(ZhPhoto zhPhoto, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zhPhoto)){
			return form(zhPhoto, model);
		}
		zhPhotoService.save(zhPhoto);
		addMessage(redirectAttributes, "保存图片成功");
		return "redirect:"+Global.getAdminPath()+"/zh/photo/zhPhoto/?repage";
	}
	
	@RequiresPermissions("zh:photo:zhPhoto:edit")
	@RequestMapping(value = "delete")
	public String delete(ZhPhoto zhPhoto, RedirectAttributes redirectAttributes) {
		zhPhotoService.delete(zhPhoto);
		addMessage(redirectAttributes, "删除图片成功");
		return "redirect:"+Global.getAdminPath()+"/zh/photo/zhPhoto/?repage";
	}

}