package com.test.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.service.DevService;

  
@Controller  
public class DevController {
     private static Logger log=LoggerFactory.getLogger(DevController.class);
     @Resource  
     private DevService devService;
     
//     @RequestMapping(value = "/search",@PathVariable)
     
}