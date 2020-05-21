package com.zte.chat.service.impl;

import com.zte.chat.dao.UserDao;
import com.zte.chat.entity.User;
import com.zte.chat.service.UserService;
import com.zte.chat.utils.CurrentDate;
import com.zte.chat.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author:helloboy
 * Date:2020-05-02 9:56
 * Description:<描述>
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findByName(String name) {
        return userDao.selectByName(name);
    }

    @Override
    public int regist(String name, String pwd, String head, Integer sex) {
        User user = new User();
        user.setUserName(name);
        String md5Pwd = MD5Util.MD5Encode(pwd);
        user.setPwd(md5Pwd);
        user.setHead(head);
        user.setSex(sex);
        user.setTime(CurrentDate.getCurrentDate());
        // 在数据库中查找是否有用户名重复
        User check = userDao.selectByName(name);
        if ( check != null ) {
            return 0;
        }
        return userDao.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User checkLogin(String name, String pwd) {
        // 先将传入的密码进行MD5加密
        String md5Pwd = MD5Util.MD5Encode(pwd);
        // 根据传入的用户名查询得到用户实体类
        User user = userDao.selectByName(name);
        // 判断用户名和密码是否正确
        // System.out.print(user);
        if (user != null && user.getPwd().equals(md5Pwd)) {
            return user;
        }
        return null;
    }
}