package com.chens.stwo.mapper;

import com.chens.stwo.entiy.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("select * from book where userId = #{userId}")
    List<Book> getBooksByUserId(int userId);
}
