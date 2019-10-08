package com.nchu.music.controller;

import com.nchu.music.bean.User;
import com.nchu.music.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService LoginDao;

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @PostMapping("login")
    @ResponseBody
    public String login(String username, String password,HttpServletRequest request){
        User user = LoginDao.login(username,password);
        if(user==null||user.getStatus()==0){
            return "<script>alert('登录失败');" +
                    "window.history.back(-1)</script>" ;
        }
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        return "<script>alert('登录成功');" +
                "window.location.href='/personalpage'</script>";//跳传到主页面
    }

    @RequestMapping("personalpage")
    public String personalpage(){
        return "personalpage";
    }




}
