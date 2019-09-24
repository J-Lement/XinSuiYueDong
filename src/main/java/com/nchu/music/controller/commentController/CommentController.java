package com.nchu.music.controller.commentController;

import com.nchu.music.service.commentService.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName CommentController
 * @Description TODO
 * @Author Lement
 * @Date 2019/9/24 8:46
 */
@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping("/addComment")
    public String addComment(String songId, String userId, String content){
        int songId1 = Integer.parseInt(songId);
        int userId1 = Integer.parseInt(userId);

        commentService.addComment(songId1, userId1, content);
        return "redirect:/musicHome?songId=" + songId;
    }
}
