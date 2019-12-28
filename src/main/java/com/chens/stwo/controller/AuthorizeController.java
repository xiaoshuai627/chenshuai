package com.chens.stwo.controller;

import com.chens.stwo.mapper.UserMapper;
import com.chens.stwo.pojo.AccessToken;
import com.chens.stwo.pojo.User;
import com.chens.stwo.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${user.id}")
    private String client_id;

    @Value("${user.client_secret}")
    private String client_secret;

    @Value("${user.redirect_uri}")
    private String redirect_uri;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request) {

        System.out.println("点击登陆后回跳到callback,AuthorizeController");

        AccessToken accessToken = new AccessToken();
        accessToken.setClient_id(client_id);
        accessToken.setClient_secret(client_secret);
        accessToken.setCode(code);
        accessToken.setRedirect_uri(redirect_uri);
        accessToken.setState(state);

        System.out.println("打印accessToken：" + accessToken);

        String access = githubProvider.getAccessToken(accessToken);
        User gituser = githubProvider.getUser(access);
/*
        System.out.println(user.getName());
        User user = (User) userMapper.findUserByName(gituser.getName());
        System.out.println(user);
         登陆用户展示
        if (gituser != null && user.getName().equals(gituser.getName())) {
            request.getSession().setAttribute("user", gituser);
            return "redirect:/";
        } else {
            return "redirect:/";
        }*/

        if (gituser!=null){
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(gituser.getName());
            user.setAccount_id(String.valueOf(gituser.getAccount_id()));
            user.setGtmcreate(System.currentTimeMillis());
            user.setGtmmodify(user.getGtmmodify());
            userMapper.insertUser(user);
            System.out.println("mapper interface.....");
            //登录成功，写cookie和session
            request.getSession().setAttribute("user",gituser);
            System.out.println("request......");
            return "redirect:/";
        }else{
            //登录失败，重新登录
            return "redirect:/";
        }


    }


}
