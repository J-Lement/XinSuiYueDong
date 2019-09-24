package com.nchu.music.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Reply
 * @Description 二级评论类
 * @Author Lement
 * @Date 2019/9/12 15:23
 */
public class Reply {
    private int replyId;
    private int commentId;
    private int userId;
    private int replyUserId;
    private String replyContent;
    private String replyTime;

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(int replyUserId) {
        this.replyUserId = replyUserId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.replyTime = sdf.format(replyTime);
    }
}
