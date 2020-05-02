package com.zte.chat.dao;

import com.zte.chat.entity.User;

/**
 * Author:helloboy
 * Date:2020-05-02 9:53
 * Description:<描述>
 */
public interface UserDao {
    /* 新增一个用户 */
    int insert(User user);
}