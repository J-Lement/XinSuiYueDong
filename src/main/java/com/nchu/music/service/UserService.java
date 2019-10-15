package com.nchu.music.service;


import com.nchu.music.bean.Admin;
import com.nchu.music.bean.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public int addUser(User user);

    public int checkUserName(String name);

    public int checkUserEmail(String email);

    public int updateStatusByEmail(String email);

    public int updateUserById(User user);

    public int updatePasswordByEmail(User user);

    User queryUserById(int userId);

}
