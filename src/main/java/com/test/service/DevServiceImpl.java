package com.test.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.test.mapper.TbDevMapper;

@Service("devService") 
@ComponentScan("com.test.service")
public class DevServiceImpl implements DevService {  
    @Resource  
    private TbDevMapper devMapper; 
}
