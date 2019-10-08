package com.nchu.music.dao.musicDao;

import com.nchu.music.bean.Song;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName MusicDao
 * @Description TODO
 * @Author Lement
 * @Date 2019/9/18 11:27
 */
@Mapper
public interface MusicDao {
    List<Song> queryAllSong();

    Song querySongBySongId(int songId);

    List<Song> querySongBySongName(String songName);

    List<Song> queryLatestSong(@Param("pageNow") int pageNow, @Param("pageNum") int PageNum);

    List<Song> queryByDownload(int pageNow, int pageNum);

    List<Song> queryHotestSong(int pageNow, int pageNum);

    int getSongCount();
}
