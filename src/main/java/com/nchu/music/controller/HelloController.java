package com.nchu.music.controller;

import com.nchu.music.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author Lement
 * @Date 2019/9/2 15:49
 */
@Controller
public class HelloController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("/home")
    public String home(){
        return "audio";
    }

    @RequestMapping("/boot/hello")
    public @ResponseBody
    String hello(){
        return "spring boot hello";
    }

    /**
     * @Author Lement
     * @Description //TODO 
     * @Date 16:27 2019/9/10
     * @Param [userName, model]
     * @return java.lang.String
     **/
    @RequestMapping("/boot/index")
    public String login(@RequestParam("userName") String userName, Model model){
        model.addAttribute("userName", userName);
        return "index";
    }

    @RequestMapping("/boot/loginCheck")
    public @ResponseBody int loginCheck(String userName, int password){
        if (demoService.queryUser(userName, password) > 0) {
            return 1;
        }
        return 0;
    }

    @RequestMapping("/boot/doRegister")
    public String doRegister(String userName, int password, Model model){
        demoService.insertUser(userName, password);
        model.addAttribute("userName", userName);
        return "success";
    }
}
