package com.test.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.test.pojo.TbDev;
import com.test.pojo.TbDevExample;

public interface TbDevMapper {
    long countByExample(TbDevExample example);

    int deleteByExample(TbDevExample example);

    int deleteByPrimaryKey(String did);

    int insert(TbDev record);

    int insertSelective(TbDev record);

    List<TbDev> selectByExample(TbDevExample example);

    TbDev selectByPrimaryKey(String did);

    int updateByExampleSelective(@Param("record") TbDev record, @Param("example") TbDevExample example);

    int updateByExample(@Param("record") TbDev record, @Param("example") TbDevExample example);

    int updateByPrimaryKeySelective(TbDev record);

    int updateByPrimaryKey(TbDev record);
}