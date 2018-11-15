package com.neuedu.sell.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.neuedu.sell.utils.WeixinResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/weixin")
public class WeixinController {

    @GetMapping("/auth")
    public ModelAndView auth(@RequestParam("code") String code, @RequestParam("state") String state) throws UnsupportedEncodingException {
        System.out.println("收到微信的回调");
        System.out.println("code: " + code);
        System.out.println("state: " + state);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxab19363432fd0ef0&secret=5008d1bb8e1190dc72b5854a0fecd922&code=" + code + "&grant_type=authorization_code";
        // 向url请求
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        System.out.println("第二次请求回来的结果: " + result);

        // 将result转化为java对象
        Gson gson = new Gson();
        WeixinResult weixinResult = gson.fromJson(result,new TypeToken<WeixinResult>(){}.getType());

        // 获取用户信息的url
        String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + weixinResult.getAccess_token() + "&openid=" + weixinResult.getOpenid() + "&lang=zh_CN";
        String info = restTemplate.getForObject(infoUrl, String.class);
        info = new String(info.getBytes("ISO-8859-1"), "UTF-8");
        System.out.println(info);

        ModelAndView model = new ModelAndView("redirect:/seller/order/list");
        return model;
    }

}
