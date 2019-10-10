package com.nchu.music.controller;

import com.nchu.music.bean.User;
import com.nchu.music.service.UserService;
import com.nchu.music.service.serviceImpl.emailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("register")
    public String registerGet(){
        return "register";
    }

    @PostMapping("register")
    public String registerPost(String username,String password1,String email,String phone){
        User user = new User();
        user.setEmail(email);
        user.setUserName(username);
        user.setPhone(phone);
        user.setPassword(password1);
        user.setStatus(0);//状态码,0表示尚未激活

        userService.addUser(user);

        emailUtil emailUtil = new emailUtil(email);
        new Thread(emailUtil).start();

        return "register";//注册成功跳转到主页面
    }

    @RequestMapping("checkname")
    @ResponseBody
    public Boolean checkName(String name){
        return (userService.checkUserName(name)>0);
    }

    @RequestMapping("checkemail")
    @ResponseBody
    public Boolean checkEmail(String email){
        return (userService.checkUserEmail(email)>0);
    }

    @RequestMapping("active")
    public String active(String email){
        userService.updateStatusByEmail(email);
        return "redirect:login";//激活成功跳转到登录页面
    }



}
