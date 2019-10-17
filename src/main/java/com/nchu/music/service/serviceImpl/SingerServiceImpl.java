package com.nchu.music.service.serviceImpl;

import com.nchu.music.bean.Singer;
import com.nchu.music.dao.SingerDao;
import com.nchu.music.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerDao singerDao;

    @Override
    public List<Singer> selectSingerList() {
        return singerDao.selectSingerList();
    }

    @Override
    public int deleteSingerByName(String name) {
        return singerDao.deleteSingerByName(name);
    }

    @Override
    public int insertSinger(Singer singer) {
        return singerDao.insertSinger(singer.getSingerName());
    }
}
