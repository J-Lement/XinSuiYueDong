package com.nchu.music.dao;

import com.nchu.music.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface LoginDao {

    public User checkByNameAndPassword(String name, String password);


}
