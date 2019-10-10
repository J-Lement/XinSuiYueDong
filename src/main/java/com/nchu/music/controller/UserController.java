package com.nchu.music.controller;

import com.nchu.music.bean.User;
import com.nchu.music.dao.UserDao;
import com.nchu.music.service.UserService;
import com.nchu.music.service.serviceImpl.PasswordEditEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("updateUser")
    public String updateUser(){
        return "updateUserPage";
    }

    @PostMapping("updateUser")
    @ResponseBody
    public String updateUser2(String qq, String nation, String province, String city, String is_public, HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        if(user == null)
            return "<script>alert('请先登录');" +
                    "window.location.href='/login'</script>";//跳回主页面

        user.setQq(qq);
        user.setProvince(province);
        user.setNation(nation);
        if("是".equals(is_public))
            user.setIsPublic(1);
        else
            user.setIsPublic(0);
        user.setCity(city);

        if(userService.updateUserById(user)>0) {
            request.getSession().setAttribute("user",user);
            return "<script>alert('修改成功');" +
                    "window.location.href='/personalpage'</script>";
        }
        else
            return "<script>alert('修改失败');" +
                    "window.location.href='/personalpage'</script>";



    }

    @GetMapping("updatePassword")
    public String updatePassword(@SessionAttribute User user){
        new Thread(new PasswordEditEmail(user.getEmail())).start();
        return "redirect:personalpage";
    }

    @GetMapping("editpassword")
    public String editpassword(String email, Model model){
        model.addAttribute("email",email);
        return "edit";
    }

    @PostMapping("editpassword")
    @ResponseBody
    public String editpassword(String email,String password,String surepassword){
        System.out.println(email);
        if("".equals(password)||"".equals(surepassword)||!password.equals(surepassword))
            return "<script>alert('密码修改错误');" +
                    "window.history.back(-1)</script>";
        else {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            if(userService.updatePasswordByEmail(user)>0)
                return "<script>alert('修改成功');" +
                    "window.location.href='/login'</script>";
            else
                return "<script>alert('修改失败');" +
                        "window.history.back(-1)</script>";
        }
    }



}
