package com.nchu.music.service.serviceImpl;

import com.nchu.music.bean.Admin;
import com.nchu.music.bean.User;
import com.nchu.music.dao.UserDao;
import com.nchu.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int checkUserName(String name) {
        User user = userDao.checkUserName(name);
        if(user!=null){
            return -1;
        }
        return 1;

    }

    @Override
    public int checkUserEmail(String email) {
        User user = userDao.checkUserEmail(email);
        if(user!=null){
            return -1;
        }
        return 1;
    }

    @Override
    public int updateStatusByEmail(String email) {
        return userDao.updateStatusByEmail(email);

    }

    @Override
    public int updateUserById(User user) {
        return userDao.updateUserById(user);
    }

    @Override
    public int updatePasswordByEmail(User user) {
        return userDao.editPasswordByEmail(user);
    }
}
