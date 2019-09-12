package com.nchu.music.bean;

/**
 * @ClassName SongList
 * @Description 歌单类
 * @Author Lement
 * @Date 2019/9/12 15:25
 */
public class SongList {
    private int songListId;
    private int songListName;
    private int songId;

    public int getSongListId() {
        return songListId;
    }

    public void setSongListId(int songListId) {
        this.songListId = songListId;
    }

    public int getSongListName() {
        return songListName;
    }

    public void setSongListName(int songListName) {
        this.songListName = songListName;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }
}
