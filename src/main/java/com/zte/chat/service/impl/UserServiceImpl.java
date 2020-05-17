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
        user.setTime(CurrentDate.getCurrentDate());
        // 在数据库中查找是否有用户名重复
        User check = userDao.selectByName(name);
        if ( check != null ) {
            return 0;
        }
        return userDao.insert(user);
    }
}