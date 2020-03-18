package com.weblog.dao;

import com.weblog.pojo.Perimission;
import com.weblog.pojo.PerimissionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PerimissionMapper {
    int countByExample(PerimissionExample example);

    int deleteByExample(PerimissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Perimission record);

    int insertSelective(Perimission record);

    List<Perimission> selectByExample(PerimissionExample example);

    Perimission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Perimission record, @Param("example") PerimissionExample example);

    int updateByExample(@Param("record") Perimission record, @Param("example") PerimissionExample example);

    int updateByPrimaryKeySelective(Perimission record);

    int updateByPrimaryKey(Perimission record);
}