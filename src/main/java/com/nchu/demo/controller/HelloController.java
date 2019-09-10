package com.nchu.demo.controller;

import com.nchu.demo.bean.User;
import com.nchu.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author Lement
 * @Date 2019/9/2 15:49
 */
@Controller
public class HelloController {
//    private static ArrayList<User> users = new ArrayList<>();
    @Autowired
    private DemoService demoService;

    @RequestMapping("/boot/hello")
    public @ResponseBody
    String hello(){
        return "spring boot hello";
    }

    @GetMapping("/boot/login")
    public String index(){
        return "login";
    }

    /**
     * @Author Lement
     * @Description //TODO 
     * @Date 10:48 2019/9/9
     * @Param [userName]
     * @return int
     **/
    @RequestMapping("/boot/check")
    public @ResponseBody int check(String userName){
        if (demoService.queryByName(userName) > 0)
            return 1;
        return 0;
    }

    @RequestMapping("/boot/index")
    public String login(@RequestParam("userName") String userName, Model model){
        model.addAttribute("userName", userName);
        return "index";
    }

    @RequestMapping("/boot/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/boot/loginCheck")
    public @ResponseBody int loginCheck(String userName, int password){
//        System.out.println(userName + " : " + password);
        if (demoService.queryUser(userName, password) > 0) {
//                System.out.println("p1: " + users.get(i).getPassword() + " p2: " + password);
            return 1;
        }
        return 0;
    }

    @RequestMapping("/boot/doRegister")
    public String doRegister(String userName, int password, Model model){
//        System.out.println("register:" + password);
        demoService.insertUser(userName, password);
        model.addAttribute("userName", userName);
        return "success";
    }
}
