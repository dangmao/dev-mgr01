package com.test.service;

import java.util.HashMap;
import java.util.List;

import com.test.pojo.TbDev;

public interface DevService { 
	public HashMap searchDeviceByKeyPageOwner(String key, String pageIndex, String pageSize, String uname2);
	
	public boolean addDevice(TbDev device);
	
	public boolean removeDevice(TbDev device);
	
	public TbDev searchDeviceByDid(String uname);

	
}