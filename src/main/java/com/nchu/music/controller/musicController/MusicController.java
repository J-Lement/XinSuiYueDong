package com.nchu.music.controller.musicController;

import com.nchu.music.bean.Comments;
import com.nchu.music.bean.Page;
import com.nchu.music.bean.Song;
import com.nchu.music.service.commentService.CommentService;
import com.nchu.music.service.musicService.MusicDataService;
import com.nchu.music.service.musicService.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    MusicDataService musicDataService;

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

    /**
     * @Author Lement
     * @Description //跳转到歌曲主页面
     * @Date 11:12 2019/10/8
     * @Param [songId, model]
     * @return java.lang.String
     **/
    @RequestMapping("/musicHome")
    public String musicHome(String songId, Model model){
        int songId1 = Integer.parseInt(songId);

        musicDataService.addPlayVolume(songId1);

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

    /**
     * @Author Lement
     * @Description //歌曲查询
     * @Date 11:12 2019/10/8
     * @Param [querySong, model]
     * @return java.lang.String
     **/
    @RequestMapping("/querySongByName")
    public String querySongByName(String querySong, Model model){
        List<Song> list = musicService.querySongBySongName(querySong);

        model.addAttribute("querySong", querySong);
        model.addAttribute("allSongs", list);

        return "allSong";
    }

    /**
     * @Author Lement
     * @Description //查询最新歌曲
     * @Date 8:10 2019/10/8
     * @Param []
     * @return java.util.List<com.nchu.music.bean.Song>
     **/
    @RequestMapping("/getLatestSong")
    public String getLatestSong(Model model){
        setPage(model,2, 1);
        return "allSong";
    }

    /**
     * @Author Lement
     * @Description //获取最热歌曲
     * @Date 9:36 2019/10/8
     * @Param [model]
     * @return java.lang.String
     **/
    @RequestMapping("/getHotestSong")
    public String getHotestSong(Model model){
        setPage(model, 1, 1);
        return "allSong";
    }

    /**
     * @Author Lement
     * @Description //获取下载最多歌曲
     * @Date 9:37 2019/10/8
     * @Param [model]
     * @return java.lang.String
     **/
    @RequestMapping("/getSongByDownload")
    public String getSongByDownload(Model model){
        setPage(model, 3, 1);
        return "allSong";
    }

    /**
     * @Author Lement
     * @Description //歌曲页面分页显示
     * @Date 9:13 2019/10/8
     * @Param [pageNow, flag, model]
     * @return java.lang.String
     **/
    @RequestMapping("/songChangePage")
    public String songChangePage(String pageNow, String flag, Model model){
        int pageNow1 = Integer.parseInt(pageNow);
        int flag1 = Integer.parseInt(flag);

        setPage(model, flag1, pageNow1);
        return "allSong";
    }


    /**
     * @Author Lement
     * @Description //设置歌曲查询分页，flag是排序方式，1为热度，2为最新歌曲，3为下载最多
     * @Date 8:39 2019/10/8
     * @Param [model, flag, pageNow]
     * @return void
     **/
    private void setPage(Model model, int flag, int pageNow){
        Page page = new Page();
        page.setPageNow(pageNow);
        page.setPageNum(4);
        page.setTotalNum(musicService.getSongCount());

        List<Song> list = null;
        switch(flag){
            case 1:
                list =  musicService.queryHotestSong((page.getPageNow() - 1) * page.getPageNum(), page.getPageNum());
                break;
            case 2:
                list =  musicService.queryLatestSong((page.getPageNow() - 1) * page.getPageNum(), page.getPageNum());
                break;
            case 3:
                list =  musicService.queryByDownload((page.getPageNow() - 1) * page.getPageNum(), page.getPageNum());
                break;
        }

        int[] num = new int[page.getPages()];
        if(page.getPages() != 0){
            for(int i = 0; i < page.getPages(); i ++)
                num[i] = i + 1;
        }

        model.addAttribute("allSongs", list);
        model.addAttribute("page", page);
        model.addAttribute("num", num);
        model.addAttribute("flag",flag);
    }
}
