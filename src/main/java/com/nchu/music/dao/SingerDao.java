package com.nchu.music.dao;

import com.nchu.music.bean.Singer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface SingerDao {
    //查询所有的歌手信息
    public List<Singer> selectSingerList();

    public int deleteSingerByName(String name);

    public int insertSinger(String singerName);


}
