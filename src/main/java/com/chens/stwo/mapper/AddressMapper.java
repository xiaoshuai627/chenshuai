package com.chens.stwo.mapper;

import com.chens.stwo.entiy.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AddressMapper {

    @Select("select * from address where userId=#{userId}")
    public Address getAddressByUserId(int userId);
}
