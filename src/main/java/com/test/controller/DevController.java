package com.test.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.pojo.DeviceSearch;
import com.test.pojo.TbDev;
import com.test.service.DevService;

  
@Controller  
public class DevController {
     private static Logger log=LoggerFactory.getLogger(DevController.class);
     @Resource  
     private DevService devService;
     
     @RequestMapping(value = "/DeviceWindow")
     public String window(){
    	 return "DeviceWindow";
     }
     
     @RequestMapping(value = "/searchDevices",produces = "application/json;charset=UTF-8")
     @ResponseBody
     public HashMap search(HttpServletRequest request){
    	 String key = (String) request.getParameter("key");
    	 String pageIndex = (String) request.getParameter("pageIndex");
    	 String pageSize = (String) request.getParameter("pageSize");
    	 String uname = (String) request.getSession().getAttribute("currentUser");
    	 HashMap map = devService.searchDeviceByKeyPageOwner(key,pageIndex,pageSize,uname);
    	 return map;
     }
//     @RequestMapping
     
}