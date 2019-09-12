package com.nchu.music.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Comment
 * @Description TODO
 * @Author Lement
 * @Date 2019/9/12 15:20
 */
public class Comment {
    private int commentId;
    private String commentContent;
    private String commentTime;
    private int songId;
    private int userId;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.commentTime = sdf.format(commentTime);
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
