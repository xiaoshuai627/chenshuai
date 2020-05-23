package com.chens.stwo.service.imp;

import com.chens.stwo.entiy.User;
import com.chens.stwo.mapper.UserMapper;
import com.chens.stwo.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int userid) {
        return userMapper.findUserById(userid);
    }

    @Override
    public User getUserAndBookById(int id) {
        return userMapper.getUserAndBooksById(id);
    }

    @Override
    public List<User> getAllUserByPageF(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> lists = userMapper.queryUserInfo();
        return lists;
    }

    @Override
    public PageInfo<User> getAllUserByPageS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> lists = userMapper.queryUserInfo();
        PageInfo<User> pageInfo = new PageInfo<>(lists);
        return pageInfo;
    }


}
