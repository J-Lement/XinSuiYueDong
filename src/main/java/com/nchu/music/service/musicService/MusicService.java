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
}
