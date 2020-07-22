package com.chens.stwo.mapper;

import com.chens.stwo.entiy.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface UserMapper {


    // one to one
    @Select("select * from user where userId=#{userId}")
    @Results({
            @Result(id = true, column = "userId", property = "userId"),
            @Result(column = "userName", property = "userName"),
            @Result(column = "userPassword", property = "userPassword"),
            @Result(column = "userAge", property = "userAge"),
            @Result(column = "userEmail", property = "userEmail"),
            @Result(column = "userId", property = "userAddress",
        //配置用户查询的方式 column代表的传入的字段，一对一查询用one select 代表使用的方法的全限定名， fetchType表示查询的方式为立即加载还是懒加载
                    one = @One(select = "com.chens.stwo.mapper.AddressMapper.getAddressByUserId", fetchType = FetchType.EAGER))
    })
    User findUserById(int userId);

    // one to many
    @Select("select * from user where userId=#{userId}")
    @Results({
            @Result(id = true, column = "userId", property = "userId"),
            @Result(column = "userName", property = "userName"),
            @Result(column = "userPassword", property = "userPassword"),
            @Result(column = "userAge", property = "userAge"),
            @Result(column = "userEmail", property = "userEmail"),
            @Result(column = "userId", property = "userAddress",
                    one = @One(select = "com.chens.stwo.mapper.AddressMapper.getAddressByUserId", fetchType = FetchType.EAGER)),
            @Result(column = "userId", property = "books",
                    many = @Many(select = "com.chens.stwo.mapper.BookMapper.getBooksByUserId", fetchType = FetchType.EAGER))
    })
    User getUserAndBooksById(int userId);


    @Select("select * from user where username=#{name} ")
    List<User> findUserByName(String name);

    //注意：gtm_create字段跟user类属性不对应
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modify) values(#{name}," +
            "#{account_id},#{token},#{gtmcreate},#{gtmmodify})")
    void insertUser(User user);

    @Select("select * from user")
    List<User> queryUserInfo();
}
