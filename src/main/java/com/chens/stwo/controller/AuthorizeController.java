package com.chens.stwo.controller;

import com.chens.stwo.pojo.AccessToken;
import com.chens.stwo.pojo.GitUser;
import com.chens.stwo.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client_id}")
    private String client_id;

    @Value("${github.client_secret}")
    private String client_secret;

    @Value("${github.redirect_dir}")
    private String redirect_dir;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state) {

        System.out.println("点击登陆后回跳到callback,AuthorizeController");
        AccessToken accessToken = new AccessToken();
        accessToken.setClient_id(client_id);
        accessToken.setClient_secret(client_secret);
        accessToken.setCode(code);
        accessToken.setRedirect_uri(redirect_dir);
        accessToken.setState(state);
        System.out.println("打印accessToken："+accessToken);
        String  access = githubProvider.getAccessToken(accessToken);
        GitUser user = githubProvider.getUser(access);
        System.out.println(user.getName());
        return "index";
    }


}
