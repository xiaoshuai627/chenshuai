package com.chens.stwo.service;

import com.chens.stwo.entiy.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IUserService {

    User getUserById(int userid);

    User getUserAndBookById(int id);

    List<User> getAllUserByPageF(int pageNum,int pageSize);

    PageInfo<User> getAllUserByPageS(int pageNum, int pageSize);


}
