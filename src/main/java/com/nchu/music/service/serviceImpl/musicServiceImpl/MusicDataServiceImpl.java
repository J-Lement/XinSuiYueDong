package com.nchu.music.service.serviceImpl.musicServiceImpl;

import com.nchu.music.dao.musicDao.MusicDataDao;
import com.nchu.music.service.musicService.MusicDataService;
import com.nchu.music.service.musicService.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName MusicDataServiceImpl
 * @Description TODO
 * @Author Lement
 * @Date 2019/10/8 11:34
 */
@Service
public class MusicDataServiceImpl implements MusicDataService {
    @Autowired
    MusicDataDao musicDataDao;

    @Override
    public int addDownload(int songId) {
        return musicDataDao.addDownload(songId);
    }

    @Override
    public int addPlayVolume(int songId) {
        return musicDataDao.addPlayVolume(songId);
    }
}
