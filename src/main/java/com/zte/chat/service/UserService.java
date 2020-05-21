package com.zte.chat.service;

import com.zte.chat.entity.User;

/**
 * Author:helloboy
 * Date:2020-05-02 9:56
 * Description:<描述>
 */
public interface UserService {
    /**
     * 根据用户名查询某个用户
     * @param name
     * @return 用户
     */
    User findByName(String name);

    /**
     * 用户注册
     * @param name
     * @param pwd
     * @param head
     * @param sex
     * @return 新增人数
     */
    int regist(String name, String pwd, String head, Integer sex);

    /**
     * 检查登录
     * @param name
     * @param pwd
     * @return 用户
     */
    User checkLogin(String name, String pwd);
}