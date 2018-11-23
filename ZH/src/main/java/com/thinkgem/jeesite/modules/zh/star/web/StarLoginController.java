package com.thinkgem.jeesite.modules.zh.star.web;

import com.thinkgem.jeesite.common.utils.MD5Util;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.zh.star.entity.StarUser;
import com.thinkgem.jeesite.modules.zh.star.service.StarUserService;
import com.thinkgem.jeesite.modules.zh.star.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @description
 * @author wzp
 * @date 11.16 0016
 */
@Controller
@RequestMapping("${frontPath}/star/")
public class StarLoginController extends BaseController {

    @Autowired
    private StarUserService starUserService;

    /**
     * star模块用户登录  前台  ajax访问
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(HttpServletRequest request, HttpServletResponse response, Model model) {

        Result result = new Result();
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        //1、判断当前用户是否登录  如果登录直接返回
        HttpSession session = request.getSession();
        String starUserName = (String)session.getAttribute("starUserName");
        if (starUserName != null && starUserName.toString() != "" && username.equals(starUserName)) {
            System.out.println("-----------WZP.print-----------" + "用户已登录+" + starUserName.toString() + ", 当前类=StarLoginController.login()");
            result.setSuccess(false);
            result.setResultMsg("用户已登录,请勿重复登陆 ");
            return result;
        }
        String requestURI = request.getRequestURI();
        if (username.trim() == null || username.trim() == "" || pass.trim() == null || pass.trim() == "") {
            result.setSuccess(false);
            result.setResultMsg("用户名密码不能为空");
            return result;
        }
        pass = MD5Util.getMD5(pass);
        StarUser starUser = new StarUser();
        starUser.setLoginName(username);
        starUser.setPassword(pass);
        List<StarUser> list = starUserService.findList(starUser);
        if (list.size() > 0) {
            System.out.println("-----------WZP.print-----------" + "用户验证通过" + ", 当前类=StarLoginController.login()");
            starUser = list.get(0);
            session.setAttribute("starUser", starUser);
            session.setAttribute("starUserName", username);
            result.setSuccess(true);
            String lastLoginip = request.getRemoteAddr();
            starUser.setLoginIp(lastLoginip);
            starUser.setLoginDate(new Date());
            starUserService.save(starUser);
            result.setResultMsg("登录成功，即将跳转个人页 3s");
            return result;
        } else {
            result.setSuccess(false);
            result.setResultMsg("用户名密码不正确，请重新输入");
            System.out.println("-----------WZP.print-----------" + "登录失败" + ", 当前类=StarLoginController.login()");
            return result;
        }
    }

    @RequestMapping(value = "loginOut")
    public String loginOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("starUser");
        session.removeAttribute("starUserName");
        return "redirect:"+frontPath;
    }


}
