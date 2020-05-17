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

//        // 测试int insert(User user);
//        User user1 = new User();
//        user1.setUserName("测试用户名");
//        user1.setPwd("测试密码");
//        user1.setHead("测试头像");
//        user1.setSex(1);
//        user1.setTime("测试日期");
//        int result1 = userDao.insert(user1);
//        System.out.println("插入函数insert测试：返回结果为" + result1);
//        System.out.println("插入的用户信息为：" + user1);
//        int insertId = user1.getUserId();
//        int insertSex = user1.getSex();
//        String insertTime = user1.getTime();
//
//        // 测试deleteById(Integer id)
//        int result2 = userDao.deleteById(1);
//        System.out.println("删除函数deleteById测试：返回结果为" + result2);
//
//        // 测试update(User user)
//        User user2 = new User();
//        user2.setUserId(insertId);
//        user2.setUserName("测试修改用户名");
//        user2.setPwd("测试修改密码");
//        user2.setHead("测试修改头像");
//        user2.setSex(insertSex);
//        user2.setTime(insertTime);
//        int result3 = userDao.update(user2);
//        System.out.println("更新函数update测试：返回结果为" + result3);
//        System.out.println("更新后的用户信息为：" + user2);

        //  测试selectByName(String name)
        User user3 = new User();
        user3 = userDao.selectByName("mike");
        System.out.println("Test:" + user3);

    }
}