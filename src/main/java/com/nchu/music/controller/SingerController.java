package com.nchu.music.controller;

import com.nchu.music.bean.Singer;
import com.nchu.music.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SingerController {

    @Autowired
    private SingerService singerService;

    @GetMapping("showsinger")
    public String showsinger(Model model){
        List<Singer> singers = singerService.selectSingerList();
        model.addAttribute("list",singers);
        return "showsinger";
    }

    @GetMapping("deletesinger")
    public String deletesinger(String name){
        singerService.deleteSingerByName(name);
        return "redirect:showsinger";
    }


    @GetMapping("addsinger")
    public String addsinger(String name){
        Singer singer = new Singer();
        singer.setSingerName(name);
        singerService.insertSinger(singer);

        return "redirect:showsinger";
    }


}
