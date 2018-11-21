package com.thinkgem.jeesite.modules.zh.star.web;

import com.thinkgem.jeesite.common.utils.MD5Util;
import com.thinkgem.jeesite.modules.zh.star.entity.StarUser;
import com.thinkgem.jeesite.modules.zh.star.service.StarUserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description
 * @author wzp
 * @date 10.22 0022
 */
public class StarUserControllerTest { 

    @Autowired
    private StarUserService starUserService;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: get(@RequestParam(required=false) String id) 
* 
*/ 
@Test
public void testGet() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: list(StarUser starUser, HttpServletRequest request, HttpServletResponse response, Model model) 
* 
*/ 
@Test
public void testList() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: form(StarUser starUser, Model model) 
* 
*/ 
@Test
public void testForm() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: save(StarUser starUser, Model model, RedirectAttributes redirectAttributes) 
* 
*/ 
@Test
public void testSave() throws Exception {
    StarUserService starUserService =new StarUserService();
    StarUser starUser = new StarUser();
    starUser.setLoginName("wzp");
    starUser.setPassword(MD5Util.getMD5("aaa"));

    starUserService.save(starUser);
} 

/** 
* 
* Method: delete(StarUser starUser, RedirectAttributes redirectAttributes) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here... 
} 


} 
