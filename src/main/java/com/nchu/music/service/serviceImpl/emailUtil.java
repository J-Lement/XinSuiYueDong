package com.nchu.music.service.serviceImpl;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class emailUtil implements Runnable{
    private String email;

    public emailUtil(String email) {
        this.email = email;
    }

    public  void run(){
        //        写邮件
        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");

        props.put("mail.smtp.host", "smtp.qq.com");

        props.put("mail.smtp.port", "587");

        props.put("mail.user", "438316866@qq.com");

        props.put("mail.password", "fnvlxonqzxlrbjgi");

        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        Session mailSession = Session.getInstance(props, authenticator);
        MimeMessage message = new MimeMessage(mailSession);
        try {

            InternetAddress form = new InternetAddress(
                    props.getProperty("mail.user"));
            message.setFrom(form);
            InternetAddress to = new InternetAddress(email);
            message.setRecipient(Message.RecipientType.TO, to);
            message.setSubject("账号激活提醒");
            message.setContent("<html><head><title>心随悦动</title><head>" +
                    "<body><h1>欢迎您注册成为心随悦动网站的会员<h1><br>" +
                    "您可以点击以下链接激活您的账号:<br>" +
                    "<a href=\"http://localhost:8080/active?email="+email+"\">激活账号</a></body></html>", "text/html;charset=UTF-8");
            Transport.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
