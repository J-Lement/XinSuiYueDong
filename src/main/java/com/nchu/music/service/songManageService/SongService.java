package com.nchu.music.service.songManageService;

import com.nchu.music.bean.Song;

import java.util.List;

/**
 * @author
 * @time
 */
public interface SongService {
    //插入数据
    int insertSong(Song song);

    //查询数据
    List<Song> queryAllSong();

    //更新数据
    int updateSong(Song song);

    //删除数据
    int deleteSong(Integer songId);
    //查找数据
    Song findById(Integer songId);
}
