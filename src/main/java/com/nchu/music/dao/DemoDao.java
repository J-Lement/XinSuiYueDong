package com.nchu.music.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @ClassName DemoDao
 * @Description TODO
 * @Author Lement
 * @Date 2019/9/8 22:02
 */
@Mapper
@Component
public interface DemoDao {
    public int queryUser(String userName, int password);

    public int queryByName(String userName);

    public int insertUser(String userName, int password);
}
