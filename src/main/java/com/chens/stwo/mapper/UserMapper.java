package com.chens.stwo.mapper;

import com.chens.stwo.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    /*@Results({
            @Result(property="gtmcreate",column="gtm_create"),
            @Result(property="gtmmodify",column="gtm_modify")
    })*/

    @Select("select id,name,sex from user where id=#{id}")
     User findUserById(int id);

    @Select("select * from user where username=#{name} ")
     List<User> findUserByName(String name);

    //注意：gtm_create字段跟user类属性不对应
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modify) values(#{name}," +
            "#{account_id},#{token},#{gtmcreate},#{gtmmodify})")
     void insertUser(User user);

}
