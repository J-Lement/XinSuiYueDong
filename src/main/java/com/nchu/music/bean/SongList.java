package com.nchu.music.bean;

/**
 * @ClassName SongList
 * @Description 歌单类
 * @Author Lement
 * @Date 2019/9/12 15:25
 */
public class SongList {
    private Integer songListId;
    private Integer songListName;
    private Integer songId;

    public Integer getSongListId() {
        return songListId;
    }

    public void setSongListId(Integer songListId) {
        this.songListId = songListId;
    }

    public Integer getSongListName() {
        return songListName;
    }

    public void setSongListName(Integer songListName) {
        this.songListName = songListName;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }
}
