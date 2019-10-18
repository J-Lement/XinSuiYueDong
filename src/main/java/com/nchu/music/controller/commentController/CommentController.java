package com.nchu.music.controller.commentController;

import com.nchu.music.bean.Comments;
import com.nchu.music.bean.Reply;
import com.nchu.music.service.commentService.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * @Author Lement
     * @Description //评论表单提交地址，添加评论，并重定向到音乐主页
     * @Date 10:07 2019/9/26
     * @Param [songId, userId, content]
     * @return java.lang.String
     **/
    @RequestMapping("/addComment")
    public String addComment(String songId, String userId, String content){
        int songId1 = Integer.parseInt(songId);
        int userId1 = Integer.parseInt(userId);

        commentService.addComment(songId1, userId1, content);
        return "redirect:/musicHome?songId=" + songId;
    }

    /**
     * @Author Lement
     * @Description //通过musicHome.js文件中ajax访问此处，添加一条新的评论，然后返回第一页的评论(有bug，返回的页数不变)
     * @Date 15:43 2019/9/26
     * @Param [songId, userId, content, pageNow, pageNum]
     * @return java.util.List<com.nchu.music.bean.Comments>
     **/
    @RequestMapping("/addAndGetComment")
    @ResponseBody
    public List<Comments> addAndGetComment(String songId, String userId, String content, String pageNow, String pageNum){
        int songId1 = Integer.parseInt(songId);
        int userId1 = Integer.parseInt(userId);
        int pageNum1 = Integer.parseInt(pageNum);
        int pageNow1 = Integer.parseInt(pageNow);
        System.out.println("pageNow:" + pageNow1);

        commentService.addComment(songId1, userId1, content);

        List<Comments> list = commentService.queryCommentBySongId(songId1, (pageNow1 - 1) * 10, pageNum1);
        return list;
    }

    /**
     * @Author Lement
     * @Description //通过歌曲id查询所有评论数量
     * @Date 15:46 2019/9/26
     * @Param [songId]
     * @return java.lang.String
     **/
    @RequestMapping("/getCommentsNumber")
    @ResponseBody
    public String getCommentsNumber(String songId){
        int songId1 = Integer.parseInt(songId);
        return commentService.queryCountCommentBySongId(songId1) + "";
    }

    /**
     * @Author Lement
     * @Description //歌曲评论分页
     * @Date 15:49 2019/9/26
     * @Param [songId, pageNum, pageNow]
     * @return java.util.List<com.nchu.music.bean.Comments>
     **/
    @RequestMapping("/changeCommentsPage")
    @ResponseBody
    public List<Comments> changeCommentsPage(String songId, String pageNum, String pageNow){
        int songId1 = Integer.parseInt(songId);
        int pageNum1 = Integer.parseInt(pageNum);
        int pageNow1 = Integer.parseInt(pageNow);

        List<Comments> list = commentService.queryCommentBySongId(songId1, (pageNow1 - 1) * 10, pageNum1);
        return list;
    }

    /**
     * @Author Lement
     * @Description //评论回复页面
     * @Date 15:50 2019/9/26
     * @Param [commentsId, userName, model]
     * @return java.lang.String
     **/
    @RequestMapping("/replyHome")
    public String replyHome(String commentsId, String userName, Model model){
        Comments comments = commentService.queryCommentsByCommentsId(Integer.parseInt(commentsId));
        System.out.println("commentsId:" + Integer.parseInt(commentsId));
        List<Reply> replyList = commentService.queryReplyByCommentsId(Integer.parseInt(commentsId));

        model.addAttribute("comments",comments);
        model.addAttribute("userName",userName);
        model.addAttribute("replyList",replyList);
        return "reply";
    }

    /**
     * @Author Lement
     * @Description //添加一条回复，然后获取所有回复
     * @Date 16:15 2019/9/26
     * @Param [commentsId, replyId, content]
     * @return java.util.List<com.nchu.music.bean.Reply>
     **/
    @RequestMapping("/addAndGetReply")
    @ResponseBody
    public List<Reply> addAndGetReply(String commentsId, String replyId, String content){
        int commentsId1 = Integer.parseInt(commentsId);
        int replyId1 = Integer.parseInt(replyId);

        commentService.addReply(commentsId1, replyId1, content);

        List<Reply> list = commentService.queryReplyByCommentsId(commentsId1);
        System.out.println(list.size());
        return list;
    }

    /**
     * @Author Lement
     * @Description //添加一条二级回复，然后根据评论id返回最新的一条回复
     * @Date 10:21 2019/9/27
     * @Param [commentsId, userName, replyUserName, replyContent]
     * @return com.nchu.music.bean.Reply
     **/
    @RequestMapping("/addAndGetLatestReply")
    @ResponseBody
    public Reply addAndGetLatestReply(String commentsId, String userName, String replyUserName, String replyContent){
        System.out.println("commentsId:" + commentsId + " userName:" + userName + " replyUserName:" + replyUserName);
        commentService.addSecondReply(Integer.parseInt(commentsId), userName, replyUserName, replyContent);

        return commentService.queryLatestReply(Integer.parseInt(commentsId));
    }

    /**
     * @Author Lement
     * @Description //点赞一次
     * @Date 19:13 2019/10/17
     * @Param [commentsId]
     * @return int
     **/
    @RequestMapping("/addOneZan")
    @ResponseBody
    public int addOneZan(String commentsId){
        int commentsId1 = Integer.parseInt(commentsId);

        commentService.addOneZan(commentsId1);
        return commentService.queryCommentsZan(commentsId1);
    }

    /**
     * @Author Lement
     * @Description //取消点赞
     * @Date 19:14 2019/10/17
     * @Param [commentsId]
     * @return int
     **/
    @RequestMapping("/minusOneZan")
    @ResponseBody
    public Integer minusOneZan(String commentsId){
        int commentsId1 = Integer.parseInt(commentsId);

        commentService.minusOneZan(commentsId1);
        return commentService.queryCommentsZan(commentsId1);
    }

}
