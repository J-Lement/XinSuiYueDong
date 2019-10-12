package com.nchu.music.controller.songManageController;

import com.nchu.music.bean.Category;
import com.nchu.music.service.songManageService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @time
 */
@Controller
public class CategoryController {


    @Autowired
    CategoryService categoryService;

    @RequestMapping("/cate")
    public    String  listCategory (Model model){
        System.out.println ("heollo");
        List<Category> list  = new ArrayList<> ();
        list= categoryService.queryAllCategory ();
        model.addAttribute ("list",list);
        return  "song_category";


    }
    //添加歌曲类别
    @GetMapping("/add_category")
    public String addCategory(Model model){
        List<Category> list = categoryService.queryAllCategory ();

        model.addAttribute("list",list);
        return "addSongCategory";
    }
    @PostMapping("/add_do_category")
    public String addTeacher(Category category, Integer categoryId, BindingResult result, Model model){

        if (result.hasErrors()) {
            List<Category> list =categoryService.queryAllCategory ();
            model.addAttribute("list",list);
            return "addSongCategory";
        } else {
            Category category1 =categoryService.findById (categoryId);
            //System.out.println(song.getSong_name ());
            //song.setSong_id (song_id);
            categoryService.insertCategory (category);
            return "redirect:/cate";
        }
    }


    //修改歌曲类别
    @RequestMapping("/editcategory/{categoryId}")
    public String editCategory(@PathVariable("categoryId")Integer categoryId, Model model){
        model.addAttribute("category",categoryService.findById(categoryId));
        return "editSongCategory";
    }

    @PostMapping("/editcategory_do")
    public String updateCategory(Category category,Model model){
        // List<song> list  = new ArrayList<> ();
        //model.addAttribute ("list",list);
        categoryService.updateCategory (category);
        //model.addAttribute ("list",list);
        return "redirect:/cate";
    }



  //删除歌曲类别
    @RequestMapping("/deleteCategory/{categoryId}")
    public String  deleteSong(@PathVariable ("categoryId") Integer categoryId){

        categoryService.deleteCategory (categoryId);
        return "redirect:/cate";
    }






}
