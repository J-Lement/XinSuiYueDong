package com.nchu.music.service;

/**
 * @InterfaceName DemoService
 * @Description TODO
 * @Author Lement
 * @Date 2019/9/8 22:23
 */
public interface DemoService {
    int queryUser(String userName, int password);

    int queryByName(String userName);

    int insertUser(String userName, int password);
}
