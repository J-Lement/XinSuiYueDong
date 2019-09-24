package com.nchu.music.dao.commentDao;

import com.nchu.music.bean.Comments;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @InterfaceName CommentDao
 * @Description TODO
 * @Author Lement
 * @Date 2019/9/24 8:35
 */
@Mapper
public interface CommentDao {
    public int queryCountCommentBySongId(int songId);

    public void addComment(int songId, int userId, String commentsContent, String commentsTime);

    public List<Comments> queryCommentBySongId(int songId);
}
