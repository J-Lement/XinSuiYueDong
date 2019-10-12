package com.nchu.music.service.serviceImpl;

import com.nchu.music.bean.User;
import com.nchu.music.dao.LoginDao;
import com.nchu.music.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public User login(String username, String password) {
        User user = loginDao.checkByNameAndPassword(username,password);
        return user;

    }
}
