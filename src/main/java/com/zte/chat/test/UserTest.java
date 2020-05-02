package com.zte.chat.test;

import com.zte.chat.dao.UserDao;
import com.zte.chat.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author:helloboy
 * Date:2020-05-02 10:21
 * Description:<描述>
 */
public class UserTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");

        // 测试int insert(User user);
        User user1 = new User();
        user1.setUserName("测试用户名");
        user1.setPwd("测试密码");
        user1.setHead("测试头像");
        user1.setSex(1);
        user1.setTime("测试日期");
        int result1 = userDao.insert(user1);
        System.out.println("插入函数insert测试：返回结果为" + result1);
        System.out.println("插入的用户信息为：" + user1);
    }
}