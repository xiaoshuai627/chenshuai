package com.chens.stwo.provider;

import com.alibaba.fastjson.JSON;
import com.chens.stwo.pojo.AccessToken;
import com.chens.stwo.pojo.User;
import okhttp3.*;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class GithubProvider {

    public String getAccessToken(AccessToken accessToken) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        String url = "https://github.com/login/oauth/access_token";
        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessToken));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            //注意是.string()方法，不是toString()
            String string = response.body().string();
//            System.out.println("请求oauth返回的响应："+string);
            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    //获取用户信息
    public User getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?"+accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            //使用JSON将响应的字符串直接转换成Uesr对象
            User user = JSON.parseObject(response.body().string(), User.class);
            return user;
        }catch (IOException e){
            e.printStackTrace();
        }
        return  null;


    }




}
