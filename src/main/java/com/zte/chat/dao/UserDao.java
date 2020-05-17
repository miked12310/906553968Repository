package com.zte.chat.dao;

import com.zte.chat.entity.User;

import java.util.List;

/**
 * Author:helloboy
 * Date:2020-05-02 9:53
 * Description:<描述>
 */
public interface UserDao {
    /* 新增一个用户 */
    int insert(User user);

    /* 根据ID删除一个用户 */
    int deleteById(Integer id);

    /* 更新一个用户的信息，可修改用户名、密码、头像 */
    int update(User user);

    /* 查询所有用户信息 */
    List<User> selectAll();

    /* 根据ID查询某个用户信息 */
    User selectById(Integer id);

    /* 根据用户名查询某个用户信息 */
    User selectByName(String name);
}