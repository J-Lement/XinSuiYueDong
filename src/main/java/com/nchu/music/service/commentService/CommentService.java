package com.nchu.music.service.commentService;

import com.nchu.music.bean.Comments;

import java.util.Date;
import java.util.List;

/**
 * @InterfaceName CommentService
 * @Description TODO
 * @Author Lement
 * @Date 2019/9/24 8:30
 */
public interface CommentService {
    public int queryCountCommentBySongId(int songId);

    public void addComment(int songId, int userId, String commentsContent);

    public List<Comments> queryCommentBySongId(int songId);
}
