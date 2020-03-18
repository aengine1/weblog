package com.weblog.dao;

import com.weblog.pojo.Perimission;
import com.weblog.pojo.Roles;
import com.weblog.pojo.User;
import com.weblog.pojo.UserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUserByUserName(@Param("userName") String userName);

    User getRolesByUserName(@Param("userName") String userName);

    List<User> getPermissionsByUserId(Integer userId);
}