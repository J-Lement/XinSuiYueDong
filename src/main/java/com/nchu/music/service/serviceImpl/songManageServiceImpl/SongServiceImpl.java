package com.nchu.music.service.serviceImpl.songManageServiceImpl;

import com.nchu.music.bean.Song;
import com.nchu.music.dao.songManageDao.DemoDao;
import com.nchu.music.service.songManageService.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @time
 */
@Service
public class SongServiceImpl implements SongService {


    @Autowired
    public DemoDao demoDao;


    @Override
    public int insertSong(Song song) {
        return   demoDao.insertSong(song);

    }

    @Override
    public List<Song> queryAllSong() {
        return  demoDao.queryAllSong ();
    }

    @Override
    public int updateSong(Song song) {
        return demoDao.updateSong (song);
    }


    @Override
    public int deleteSong(Integer songId) {
        return   demoDao.deleteSong (songId);
    }

    @Override
    public Song findById(Integer songId) {
        return demoDao.findById (songId);
    }
}