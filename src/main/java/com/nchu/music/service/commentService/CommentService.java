package com.nchu.music.service.commentService;

import com.nchu.music.bean.Comments;
import com.nchu.music.bean.Reply;

import java.util.Date;
import java.util.List;

/**
 * @InterfaceName CommentService
 * @Description TODO
 * @Author Lement
 * @Date 2019/9/24 8:30
 */
public interface CommentService {
    int queryCountCommentBySongId(int songId);

    void addComment(int songId, int userId, String commentsContent);

    List<Comments> queryCommentBySongId(int songId, int startNum, int pageNum);

    Comments queryCommentsByCommentsId(int commentsId);

    void addReply(int commentsId, int replyUserId, String replyContent);

    List<Reply> queryReplyByCommentsId(int commentsId);

    void addSecondReply(int commentsId, String userName, String replyUserName, String replyContent);

    Reply queryLatestReply(int commentsId);

    Integer queryCommentsZan(int commentsId);

    int addOneZan(int commentsId);

    int minusOneZan(int commentsId);
}
