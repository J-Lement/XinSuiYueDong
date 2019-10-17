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

    @Override
    public Song querySongBySongId(int songId) {
        return musicDao.querySongBySongId(songId);
    }

    @Override
    public List<Song> querySongBySongName(String songName) {
        return musicDao.querySongBySongName(songName);
    }

    @Override
    public List<Song> queryLatestSong(int pageNow, int pageNum) {
        return musicDao.queryLatestSong(pageNow, pageNum);
    }

    @Override
    public List<Song> queryByDownload(int pageNow, int pageNum) {
        return musicDao.queryByDownload(pageNow, pageNum);
    }

    @Override
    public List<Song> queryHotestSong(int pageNow, int pageNum) {
        return musicDao.queryHotestSong(pageNow, pageNum);
    }

    @Override
    public int getSongCount() {
        return musicDao.getSongCount();
    }

    @Override
    public List<Song> getMyList(int userId) {
        return musicDao.getMyList(userId);
    }

    @Override
    public String getSongName(int songId) {
        return musicDao.getSongName(songId);
    }

    @Override
    public int addToList(int userId, int songId) {
        String songName = getSongName(songId);
        return musicDao.addToList(userId, songId, songName);
    }

    @Override
    public List<String> queryListSongAddress(int userId) {
        return musicDao.queryListSongAddress(userId);
    }

    @Override
    public int deleteSongFromList(int userId, int songId) {
        return musicDao.deleteSongFromList(userId, songId);
    }
}
