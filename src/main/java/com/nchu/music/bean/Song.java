package com.nchu.music.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Song
 * @Description 歌曲信息类
 * @Author Lement
 * @Date 2019/9/12 15:06
 */
public class Song {
    private Integer songId;
    private Integer singerId;
    private Integer categoryId;
    private String songName;
    private String singerName;
    private String songDocument;
    private String lyrics;
    private String categoryName;
    private String uploadTime;
    private Integer playVolume;
    private Integer download;

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongDocument() {
        return songDocument;
    }

    public void setSongDocument(String songDocument) {
        this.songDocument = songDocument;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.uploadTime = sdf.format(uploadTime);
    }

    public Integer getPlayVolume() {
        return playVolume;
    }

    public void setPlayVolume(Integer playVolume) {
        this.playVolume = playVolume;
    }

    public Integer getDownload() {
        return download;
    }

    public void setDownload(Integer download) {
        this.download = download;
    }
}
