package com.nchu.music.controller.musicController;

import com.nchu.music.service.musicService.MusicDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName MusicDataController
 * @Description TODO
 * @Author Lement
 * @Date 2019/10/8 11:36
 */
@Controller
public class MusicDataController {
    @Autowired
    MusicDataService musicDataService;

    @RequestMapping("/addDownload")
    @ResponseBody
    public String addDownload(String songId){
        int songId1 = Integer.parseInt(songId);
        return musicDataService.addDownload(songId1) + "";
    }

    @RequestMapping("/addPlayVolume")
    @ResponseBody
    public String addPlayVolume(String songId){
        int songId1 = Integer.parseInt(songId);
        return musicDataService.addPlayVolume(songId1) + "";
    }
}
