package com.nchu.music.controller.musicController;

import com.nchu.music.bean.Comments;
import com.nchu.music.bean.Page;
import com.nchu.music.bean.Song;
import com.nchu.music.service.commentService.CommentService;
import com.nchu.music.service.musicService.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName musicController
 * @Description TODO
 * @Author Lement
 * @Date 2019/9/18 11:23
 */
@Controller
public class MusicController {
    @Autowired
    MusicService musicService;

    @Autowired
    CommentService commentService;

    @RequestMapping("/common")
    public String common(){
        return "common";
    }

    @RequestMapping("/allMusic")
    public String allMusic(Model model){
        ArrayList<Song> list = (ArrayList<Song>) musicService.queryAllSong();
        model.addAttribute("allSongs",list);
        return "allSong";
    }

    @RequestMapping("/musicHome")
    public String musicHome(String songId, Model model){
        int songId1 = Integer.parseInt(songId);
        int commentsNum = commentService.queryCountCommentBySongId(songId1);
        Song song = musicService.querySongBySongId(songId1);
        Page page = new Page();
        page.setTotalNum(commentsNum);
        page.setPageNow(1);
        List<Comments> commentsList = commentService.queryCommentBySongId(songId1, (page.getPageNow() - 1) * page.getPageNum(), page.getPageNum());

        //显示页数
        int[] num = new int[page.getPages()];
        for(int i = 0; i < page.getPages(); i ++){
            num[i] = i + 1;
        }

        model.addAttribute("songId",songId);
        model.addAttribute("song",song);
        model.addAttribute("commentsNum",commentsNum);
        model.addAttribute("commentsList",commentsList);
        model.addAttribute("page",page);
        model.addAttribute("num",num);

//        Date date = new Date();
//        Timestamp time = new Timestamp(date.getTime());
//        System.out.println("当前util时间：" + new Date() + " 当前sql时间：" + time);// new Date()为获取当前系统时间
        return "musicHome";
    }
}
