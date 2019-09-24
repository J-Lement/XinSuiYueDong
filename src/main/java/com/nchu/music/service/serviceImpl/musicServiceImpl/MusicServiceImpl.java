package com.nchu.music.service.serviceImpl.musicServiceImpl;

import com.nchu.music.bean.Song;
import com.nchu.music.dao.musicDao.MusicDao;
import com.nchu.music.service.musicService.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MusicServiceImpl
 * @Description TODO
 * @Author Lement
 * @Date 2019/9/18 11:28
 */
@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    MusicDao musicDao;

    @Override
    public List<Song> queryAllSong() {
        return musicDao.queryAllSong();
    }
}
