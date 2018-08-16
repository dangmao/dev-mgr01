package com.test.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.pojo.TbUsers;
import com.test.service.UserService;
  
  
@Controller  
public class UserController {
     private static Logger log=LoggerFactory.getLogger(UserController.class);
     @Resource  
     private UserService userService;
     
     @RequestMapping(value={"/","/login"})
     public String index(HttpServletRequest request){
    	 String username = (String) request.getSession().getAttribute("currentUser");
    	 if(username == null||username.equals(""))
    		 return "login";
    	 return "index";
     }
     
     @RequestMapping(value = "/login.do", method = RequestMethod.POST)
 	 public String userlogin(TbUsers user,ModelMap model,HttpServletRequest request) {
 		if (!userService.isUserExist(user.getUname())) {
 			model.addAttribute("msg", "用户名密码错误！");
 			return "login";
 		} else {
 			if (user.getPassword().equals(userService.findUsersByUsername(user.getUname()).getPassword())) {
 				model.addAttribute("msg", "登录成功！");
 				request.getSession().setAttribute("currentUser", user.getUname());
 				return "index";
 			} else {
 				model.addAttribute("msg", "用户名密码错误！");
 				return "login";
 			}
 		}
 	}
     @RequestMapping(value = "/modifyPassword")
     public String modifyView(){
    	 return "modifyPassword";
     }
     @RequestMapping(value = "/modifyPassword.do", method = RequestMethod.POST)
 	 public String modifyPassword( @RequestParam("pwd_old") String pwd_old, @RequestParam("pwd_new") String pwd_new, @RequestParam("pwd_new2") String pwd_new2, HttpServletRequest request, ModelMap model) {
    	 String username = (String) request.getSession().getAttribute("currentUser");
    	 if(username == null||username.length()==0) return "login";
    	 if(pwd_new==null||!pwd_new.equals(pwd_new2)){
    		 model.addAttribute("msg", "新密码输入不一致");
    		 return "modifyPassword";
    	 }
 			if (pwd_old.equals(userService.findUsersByUsername(username).getPassword())) {
 				if(userService.modifyPasswordByUsername(username, pwd_new)){
 					model.addAttribute("msg", "修改密码成功！");
 				}else{
 					model.addAttribute("msg", "修改密码失败！");
 				}
 			} else {
 				model.addAttribute("msg", "密码错误！");
 			}
 		return "modifyPassword";
 		}
     @RequestMapping("/logout.do")
     public String logout(HttpServletRequest request){
    	 request.getSession().removeAttribute("currentUser");
    	 return "login";
     }
}