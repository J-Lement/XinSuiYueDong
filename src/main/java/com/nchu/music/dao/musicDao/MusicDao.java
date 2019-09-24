package com.nchu.music.dao.musicDao;

import com.nchu.music.bean.Song;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @InterfaceName MusicDao
 * @Description TODO
 * @Author Lement
 * @Date 2019/9/18 11:27
 */
@Mapper
public interface MusicDao {
    public List<Song> queryAllSong();
}
