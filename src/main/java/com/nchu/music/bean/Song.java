package com.nchu.music.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Song
 * @Description TODO
 * @Author Lement
 * @Date 2019/9/12 15:06
 */
public class Song {
    private int songId;
    private String songName;
    private int singerId;
    private String songDocument;
    private String lyrics;
    private String categoryId;
    private String uploadTime;
    private int playVolume;
    private int download;

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.uploadTime = sdf.format(uploadTime);
    }

    public int getPlayVolume() {
        return playVolume;
    }

    public void setPlayVolume(int playVolume) {
        this.playVolume = playVolume;
    }

    public int getDownload() {
        return download;
    }

    public void setDownload(int download) {
        this.download = download;
    }
}
