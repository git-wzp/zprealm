package com.thinkgem.jeesite.modules.zh.star.utils;

import com.thinkgem.jeesite.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.modules.zh.star.entity.StarStarmessage;
import com.thinkgem.jeesite.modules.zh.star.entity.StarUser;
import com.thinkgem.jeesite.modules.zh.star.service.StarStarmessageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @description 星迷模块根据id查询明星名称
 * @author wzp
 * @date 11.09 0009
 */
public class starUtils {

    public static String getStarName(String id) {
        String starName = "";
        StarStarmessageService starStarmessageService = SpringContextHolder.getBean(StarStarmessageService.class);
        StarStarmessage starStarmessage = starStarmessageService.get(id);
        if (starStarmessage != null) {
            starName = starStarmessage.getName();
        }
        return starName;
    }

    /**
     * 判断当前用户是否登录
     */
    public static boolean isStarLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        StarUser starUser = (StarUser) session.getAttribute("starUser");
        return starUser != null ? true : false;
    }

    /**
     * 获取当前star登录用户
     */
    public static StarUser getCurrentUser(HttpServletRequest request) {
        if(isStarLogin(request)){
            StarUser starUser = (StarUser) request.getSession().getAttribute("starUser");
            return starUser;
        }else {
            return null;
        }
    }

}
