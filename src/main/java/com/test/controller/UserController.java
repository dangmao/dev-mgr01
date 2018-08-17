package com.test.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.pojo.TbUsers;
import com.test.service.UserService;
  
  
@Controller  
public class UserController {
     private static Logger log=LoggerFactory.getLogger(UserController.class);
     @Resource  
     private UserService userService;
     
     @RequestMapping(value={"/","/index"})
     public String index(HttpServletRequest request){
    	 return "index";
     }
     
     @RequestMapping("/login")
     public String login(HttpServletRequest request){
    	 String username = (String) request.getSession().getAttribute("currentUser");
    	 if(username == null||username.equals(""))
    		 return "login";
    	 return "index";
     }
     
     @RequestMapping(value = "/login.do", method = RequestMethod.POST)
     @ResponseBody
 	 public String userlogin(TbUsers user,ModelMap model,HttpServletRequest request) {
 		if (!userService.isUserExist(user.getUname())) {
 			return "login";
 		} else {
 			if (user.getPassword().equals(userService.findUsersByUsername(user.getUname()).getPassword())) {
 				request.getSession().setAttribute("currentUser", user.getUname());
 				return "index";
 			} else {
 				return "login";
 			}
 		}
 	}
     
     @RequestMapping(value = "/modifyPassword")
     public String modifyView(){
    	 return "modifyPassword";
     }
     
     @RequestMapping(value = "/modifyPassword.do", method = RequestMethod.POST)
     @ResponseBody
 	 public String modifyPassword( @RequestParam("pwd_old") String pwd_old, @RequestParam("pwd_new") String pwd_new, @RequestParam("pwd_new2") String pwd_new2, HttpServletRequest request, ModelMap model) {
    	 String username = (String) request.getSession().getAttribute("currentUser");
    	 if(username == null||username.length()==0) return "login";
    	 if(pwd_new==null||!pwd_new.equals(pwd_new2)){
    		 //两次密码输入不一致
    		 return "1";
    	 }
 			if (pwd_old.equals(userService.findUsersByUsername(username).getPassword())) {
 				if(userService.modifyPasswordByUsername(username, pwd_new)){
 					//修改密码成功
 					return "0";
 				}else{
 					//修改密码失败
 					return "2";
 				}
 			} else {
 				//密码错误
 				return "3";
 			}
 		}
     
     
     @RequestMapping("/search")
     public String search(){
    	 return "search";
     }
     
     @RequestMapping("/logout.do")
     public String logout(HttpServletRequest request){
    	 request.getSession().removeAttribute("currentUser");
    	 return "login";
     }
}