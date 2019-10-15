package com.nchu.music.service.serviceImpl.songManageServiceImpl;

import com.nchu.music.bean.Song;
import com.nchu.music.dao.songManageDao.DemoDao;
import com.nchu.music.service.songManageService.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author
 * @time
 */
@Service
public class SongServiceImpl implements SongService {

    @Autowired
    DemoDao demoDao;


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

    @Override
    public void multiUpload(List<MultipartFile> files, Song song) {
        String filePath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        System.out.println("filePath:" + filePath);
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
                System.out.println(files.size() + "第" + i + "个文件为空");
                continue;
            }
            String fileName = file.getOriginalFilename();

            File dest;
            if(i == 0) {
                dest = new File(filePath + "/static/music/song/" + fileName);
                song.setSongDocument("/music/song/" + fileName);
            }
            else{
                dest = new File(filePath + "/static/music/lyrics/" + fileName);
                song.setLyrics("/music/lyrics/" + fileName);
            }

            try {
                file.transferTo(dest);
                System.out.println("第" + (i + 1) + "个文件上传成功");
            } catch (IOException e) {
                System.out.println(e.toString());
                System.out.println("上传第" + i + "个文件失败");
            }
        }

        demoDao.insertSong(song);
    }
}