package com.nchu.music.service;


import com.nchu.music.bean.Singer;

import java.util.List;

public interface SingerService {

    //查询所有的歌手信息
    public List<Singer> selectSingerList();

    public int deleteSingerByName(String name);

    public int insertSinger(Singer singer);
}
