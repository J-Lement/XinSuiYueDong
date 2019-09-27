package com.nchu.music.dao.commentDao;

import com.nchu.music.bean.Comments;
import com.nchu.music.bean.Reply;
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
    int queryUserIdByUserName(String userName);

    int queryCountCommentBySongId(int songId);

    void addComment(int songId, int userId, String commentsContent, String commentsTime);

    List<Comments> queryCommentBySongId(int songId,  int startNum, int pageNum);

    Comments queryCommentsByCommentsId(int commentsId);

    void addReply(int commentsId, Integer userId, int replyUserId, String replyContent, String replyTime);

    List<Reply> queryReplyByCommentsId(int commentsId);

    Reply queryLatestReply(int commentsId);
}
