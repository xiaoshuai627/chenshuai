package com.chens.stwo.controller;

import com.chens.stwo.entiy.User;
import com.chens.stwo.service.IUserService;
import com.github.pagehelper.PageInfo;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping(value = "/getUser")
    public User getUserById(@RequestParam("id") int id) {
        return userService.getUserById(id);
    }

    @GetMapping(value = "/getUserBook")
    public User getUserAndBookById(@RequestParam("id") int id) {
        return userService.getUserAndBookById(id);
    }

    @GetMapping(value = "/pageHelper")
    public PageInfo<User> getAllUserPageHelper(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize ) {
        return userService.getAllUserByPageS(pageNum,pageSize);
    }

    @GetMapping(value = "/pageUser")
    public List<User> getAllUser(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize ) {
        return userService.getAllUserByPageF(pageNum,pageSize);
    }
}
