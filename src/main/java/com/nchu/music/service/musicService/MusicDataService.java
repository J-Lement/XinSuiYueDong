package com.nchu.music.service.musicService;

/**
 * @InterfaceName MusicDataService
 * @Description TODO
 * @Author Lement
 * @Date 2019/10/8 11:34
 */
public interface MusicDataService {
    int addDownload(int songId);

    int addPlayVolume(int songId);
}
