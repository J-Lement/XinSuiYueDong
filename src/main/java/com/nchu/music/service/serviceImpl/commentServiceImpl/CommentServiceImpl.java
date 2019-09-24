package com.nchu.music.service.serviceImpl.commentServiceImpl;

import com.nchu.music.bean.Comments;
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
    public List<Comments> queryCommentBySongId(int songId) {
        return commentDao.queryCommentBySongId(songId);
    }
}
