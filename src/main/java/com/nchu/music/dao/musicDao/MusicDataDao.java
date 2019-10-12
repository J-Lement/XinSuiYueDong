package com.nchu.music.dao.musicDao;

import org.apache.ibatis.annotations.Mapper;

/**
 * @InterfaceName MusicDataDao
 * @Description TODO
 * @Author Lement
 * @Date 2019/10/8 11:35
 */
@Mapper
public interface MusicDataDao {
    int addDownload(int songId);

    int addPlayVolume(int songId);
}
