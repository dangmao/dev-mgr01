package com.test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.test.mapper.TbDevMapper;
import com.test.pojo.TbDev;
import com.test.pojo.TbDevExample;
import com.test.pojo.TbDevExample.Criteria;

@Service("devService") 
@ComponentScan("com.test.service")
public class DevServiceImpl implements DevService {  
    @Resource  
    private TbDevMapper devMapper;

	@Override
	public HashMap searchDeviceByKeyPageOwner(String key, String pageIndex, String pageSize,String uname) {
		TbDevExample example = new TbDevExample();
		Criteria criteria = example.createCriteria();
		example.setOrderByClause("did");
		criteria.andUnameEqualTo(uname);
		if(key!=null&&key.length()!=0)
			criteria.andDnameLike("%"+key+"%");
		List<TbDev> devlist = new ArrayList<TbDev>();
		long total = devMapper.countByExample(example);
		
		int pSize = Integer.parseInt(pageSize);
		int StartRow = pSize*Integer.parseInt(pageIndex);
		example.setPageSize(pSize);
		example.setStartRow(StartRow);
		devlist = devMapper.selectByExample(example);
		
		HashMap map = new HashMap();
		map.put("total", total);
		map.put("data", devlist);
		return map;
	}

	@Override
	public boolean addDevice(TbDev device) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeDevice(TbDev device) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TbDev searchDeviceByDid(String uname) {
		// TODO Auto-generated method stub
		return null;
	}


}
