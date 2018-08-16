package com.test.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.test.mapper.TbUsersMapper;
import com.test.pojo.TbUsers;

@Service("userService") 
@ComponentScan("com.test.service")
public class UserServiceImpl implements UserService {  
    @Resource  
    private TbUsersMapper usersMapper;  
    
    public TbUsers findUsersByUsername(String uname) {  
        return this.usersMapper.selectByPrimaryKey(uname);  
    }

	@Override
	public boolean isUserExist(String uname) {
		if(this.usersMapper.selectByPrimaryKey(uname)==null)
			return false;
		else 
			return true;
	}

	@Override
	public boolean modifyPasswordByUsername(String username, String password) {
		TbUsers user = new TbUsers();
		user.setUname(username);
		user.setPassword(password);
		if(this.usersMapper.updateByPrimaryKey(user)>0)
			return true;
		return false;
		
	}  
  
}
