package com.nchu.music.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Comment
 * @Description 一级评论类
 * @Author Lement
 * @Date 2019/9/12 15:20
 */
public class Comments {
    private int commentsId;
    private String commentsContent;
    private String commentsTime;
    private int songId;
    private int userId;
    private String songName;
    private String userName;

    public String getCommentsTime() {
        return commentsTime;
    }

    public void setCommentsTime(String commentsTime) {
        this.commentsTime = commentsTime;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(int commentId) {
        this.commentsId = commentId;
    }

    public String getCommentsContent() {
        return commentsContent;
    }

    public void setCommentsContent(String commentContent) {
        this.commentsContent = commentContent;
    }

    public String getCommentTime() {
        return commentsTime;
    }

    public void setCommentTime(Date commentTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.commentsTime = sdf.format(commentTime);
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
