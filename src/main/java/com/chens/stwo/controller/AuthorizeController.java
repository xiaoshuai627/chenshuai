package com.chens.stwo.controller;

import com.chens.stwo.pojo.AccessToken;
import com.chens.stwo.pojo.GitUser;
import com.chens.stwo.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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
        GitUser user = githubProvider.getUser(access);
//        System.out.println(user.getName());

        // 登陆用户展示
        if (user != null) {
            request.getSession().setAttribute("user", user);
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }


}
