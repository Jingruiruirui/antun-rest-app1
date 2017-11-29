package com.zdjy.bigdata.antun.mapper;

import com.zdjy.bigdata.antun.domain.User;
import com.zdjy.bigdata.antun.domain.UserExample;
import com.zdjy.bigdata.antun.web.model.UserAdd;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserAdd userAdd);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}