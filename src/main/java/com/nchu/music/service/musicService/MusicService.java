package com.nchu.music.service.musicService;

import com.nchu.music.bean.Song;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @InterfaceName musicService
 * @Description TODO
 * @Author Lement
 * @Date 2019/9/18 11:27
 */
public interface MusicService {
    List<Song> queryAllSong();

    Song querySongBySongId(int songId);

    List<Song> querySongBySongName(String songName);

    List<Song> queryLatestSong(int pageNow, int pageNum);

    List<Song> queryByDownload(int pageNow, int pageNum);

    List<Song> queryHotestSong(int pageNow, int pageNum);

    int getSongCount();

    List<Song> getMyList(int userId);

    String getSongName(int songId);

    int addToList(int userId, int songId);

    List<String> queryListSongAddress(int userId);
}
