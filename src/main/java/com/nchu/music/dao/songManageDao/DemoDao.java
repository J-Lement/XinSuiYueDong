package com.nchu.music.dao.songManageDao;

import com.nchu.music.bean.Song;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author
 * @time
 */
@Mapper
public interface DemoDao {
        //增加数据
        int insertSong(Song song);

        //查询数据
        List<Song> queryAllSong();

        //更新数据
        int updateSong(Song song);

        //删除数据
        int deleteSong(Integer song_id);

        //查找数据
        Song findById(Integer song_id);

}
