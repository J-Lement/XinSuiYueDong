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
    private int songId;
    private String songName;
    private String singerName;
    private String songDocument;
    private String lyrics;
    private String categoryName;
    private String uploadTime;
    private int playVolume;
    private int download;

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
