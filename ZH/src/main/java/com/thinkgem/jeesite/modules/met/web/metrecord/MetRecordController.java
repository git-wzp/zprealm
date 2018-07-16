/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.met.web.metrecord;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.modules.met.entity.metrecorduser.MetRecordUser;
import com.thinkgem.jeesite.modules.met.entity.metuser.MetUser;
import com.thinkgem.jeesite.modules.met.service.metrecorduser.MetRecordUserService;
import com.thinkgem.jeesite.modules.met.service.metuser.MetUserService;
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
import com.thinkgem.jeesite.modules.met.entity.metrecord.MetRecord;
import com.thinkgem.jeesite.modules.met.service.metrecord.MetRecordService;

import java.util.List;

/**
 * 会议记录信息Controller
 * @author 王子鹏
 * @version 2018-06-24
 */
@Controller
@RequestMapping(value = "${adminPath}/met/metrecord/metRecord")
public class MetRecordController extends BaseController {

	@Autowired
	private MetRecordService metRecordService;;
	@Autowired
	private MetRecordUserService metRecordUserService;
	@Autowired
    private MetUserService metUserService;

	
	@ModelAttribute
	public MetRecord get(@RequestParam(required=false) String id) {
		MetRecord entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = metRecordService.get(id);
		}
		if (entity == null){
			entity = new MetRecord();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(MetRecord metRecord, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MetRecord> page = metRecordService.findPage(new Page<MetRecord>(request, response), metRecord);
		model.addAttribute("page", page);
		return "modules/met/metrecord/metRecordList";
	}

	@RequestMapping(value = "form")
	public String form(MetRecord metRecord, Model model) {
		model.addAttribute("metRecord", metRecord);
        List<MetUser> mUserList = metUserService.findList(new MetUser());
        model.addAttribute("mUserList",mUserList);

        return "modules/met/metrecord/metRecordForm";
	}

	@RequestMapping(value = "save")
	public String save(MetRecord metRecord, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, metRecord)){
			return form(metRecord, model);
		}
		metRecordService.save(metRecord);
		addMessage(redirectAttributes, "保存会议记录信息成功");
		return "redirect:"+Global.getAdminPath()+"/met/metrecord/metRecord/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(MetRecord metRecord, RedirectAttributes redirectAttributes) {
		metRecordService.delete(metRecord);
		addMessage(redirectAttributes, "删除会议记录信息成功");
		return "redirect:"+Global.getAdminPath()+"/met/metrecord/metRecord/?repage";
	}

}