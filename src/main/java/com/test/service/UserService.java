package com.test.service;

import com.test.pojo.TbUsers;

public interface UserService {  
    public TbUsers findUsersByUsername(String userId);

	public boolean isUserExist(String uname);

	public boolean modifyPasswordByUsername(String username, String newpassword);  
}