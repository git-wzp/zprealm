package com.thinkgem.jeesite.modules.zh.star.utils;

import com.thinkgem.jeesite.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.modules.zh.star.entity.StarStarmessage;
import com.thinkgem.jeesite.modules.zh.star.service.StarStarmessageService;

/**
 * @description 星迷模块根据id查询明星名称
 * @author wzp
 * @date 11.09 0009
 */
public class starUtils {

   public static String  getStarName(String id){
       String starName = "";
       StarStarmessageService starStarmessageService =SpringContextHolder.getBean(StarStarmessageService.class);
       StarStarmessage starStarmessage = starStarmessageService.get(id);
       if(starStarmessage!=null){
           starName = starStarmessage.getName();
       }
       return starName;
   }
}
