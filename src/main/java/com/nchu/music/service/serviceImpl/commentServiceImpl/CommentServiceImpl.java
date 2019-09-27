package com.nchu.music.service.serviceImpl.commentServiceImpl;

import com.nchu.music.bean.Comments;
import com.nchu.music.bean.Reply;
import com.nchu.music.dao.commentDao.CommentDao;
import com.nchu.music.service.commentService.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName CommentServiceImpl
 * @Description TODO
 * @Author Lement
 * @Date 2019/9/24 8:31
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;

    @Override
    public int queryCountCommentBySongId(int songId) {
        return commentDao.queryCountCommentBySongId(songId);
    }

    @Override
    public void addComment(int songId, int userId, String commentsContent) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String commentsTime = df.format(new Date());// new Date()为获取当前系统时间
        commentDao.addComment(songId, userId, commentsContent, commentsTime);
    }

    @Override
    public List<Comments> queryCommentBySongId(int songId, int startNum, int pageNum) {
        return commentDao.queryCommentBySongId(songId, startNum, pageNum);
    }

    @Override
    public Comments queryCommentsByCommentsId(int commentsId) {
        return commentDao.queryCommentsByCommentsId(commentsId);
    }

    @Override
    public void addReply(int commentsId, int replyUserId, String replyContent) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String replyTime = df.format(new Date());// new Date()为获取当前系统时间

        commentDao.addReply(commentsId, null, replyUserId, replyContent, replyTime);
    }

    @Override
    public List<Reply> queryReplyByCommentsId(int commentsId) {
        return commentDao.queryReplyByCommentsId(commentsId);
    }

    @Override
    public void addSecondReply(int commentsId, String userName, String replyUserName, String replyContent) {
        System.out.println(userName + " : " + replyUserName);
        int userId = commentDao.queryUserIdByUserName(userName);
        int replyUserId = commentDao.queryUserIdByUserName(replyUserName);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String replyTime = df.format(new Date());// new Date()为获取当前系统时间

        commentDao.addReply(commentsId, userId, replyUserId, replyContent, replyTime);
    }

    @Override
    public Reply queryLatestReply(int commentsId) {
        return commentDao.queryLatestReply(commentsId);
    }
}
