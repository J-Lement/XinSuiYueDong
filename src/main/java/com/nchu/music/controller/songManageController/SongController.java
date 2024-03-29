package com.nchu.music.controller.songManageController;
/**
 * @author
 * @time
 */
import com.nchu.music.bean.Song;
import com.nchu.music.service.songManageService.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SongController {

    @Autowired
    SongService songService;
    @RequestMapping ("/list")
    public    String  listSong (Model model){
         List<Song> list = songService.queryAllSong ();
        //System.out.println ("first:" + list.size ());
         model.addAttribute ("list",list);
        return  "songList";

    }

    @RequestMapping ("/index")
    public String addMusic (){

        return "song_index" ;
    }

   //添加歌曲
    @GetMapping("/add_song")
    public String addSong(Model model){
        return "addSong";
    }

    @RequestMapping("/multiUpload")
    public String multiUpload(List<MultipartFile> files, Song song, BindingResult result, Model model) {

        if (result.hasErrors()) {
            List<Song> list =songService.queryAllSong ();
            model.addAttribute("list",list);
            return "addSong";
        } else {
            songService.multiUpload(files, song);
            return "redirect:/list";
        }
    }


//修改歌曲信息

    @RequestMapping("/edit/{songId}")
    public String editSong(@PathVariable("songId")Integer songId, Model model){
        model.addAttribute("song",songService.findById(songId));
        return "editSong";
    }

    @PostMapping("/edit_do")
    public String updateTeacher(Song song,Model model){
       // List<song> list  = new ArrayList<> ();
        //model.addAttribute ("list",list);
        songService.updateSong (song);
        //model.addAttribute ("list",list);
        return "redirect:/list";
    }




    @RequestMapping("/deletesong/{songId}")
    public String  deleteSong(@PathVariable ("songId") Integer songId){

        songService.deleteSong(songId);
        return "redirect:/list";
    }

}
