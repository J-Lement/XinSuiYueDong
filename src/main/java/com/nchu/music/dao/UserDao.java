package com.nchu.music.dao;

import com.nchu.music.bean.Admin;
import com.nchu.music.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDao {

    //添加用户
    public int addUser(User user);

    //验证用户名
    public User checkUserName(String name);

    //验证邮箱
    public User checkUserEmail(String email);

    //激活邮箱
    public int updateStatusByEmail(String email);

    //补充user的信息
    public int updateUserById(User user);

    //通过邮箱修改密码
    public int editPasswordByEmail(User user);

    User queryUserById(int userId);
}
