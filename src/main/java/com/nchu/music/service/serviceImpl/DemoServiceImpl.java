package com.nchu.music.service.serviceImpl;

import com.nchu.music.dao.DemoDao;
import com.nchu.music.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName DemoServiceImpl
 * @Description TODO
 * @Author Lement
 * @Date 2019/9/8 22:24
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    DemoDao demoDao;

    @Override
    public int queryUser(String userName, int password) {
        return demoDao.queryUser(userName, password);
    }

    @Override
    public int queryByName(String userName) {
        return demoDao.queryByName(userName);
    }

    @Override
    public int insertUser(String userName, int password) {
        return demoDao.insertUser(userName, password);
    }
}
