package com.zte.chat.controller;

import com.alibaba.fastjson.JSON;
import com.zte.chat.entity.User;
import com.zte.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:helloboy
 * Date:2020-05-02 9:56
 * Description:<描述>
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/regist")
    private String regist() {
        return "user/regist";
    }

    @RequestMapping("/regist/do")
    @ResponseBody
    private String doRegist(HttpServletRequest req, HttpSession session) {
        Map map = new HashMap<>(4);
        int status;
        String msg;
        // 获取用户名和密码
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String head = req.getParameter("head");
        Integer sex = req.getIntHeader("sex");
        if ( name.length() == 0 || pwd.length() == 0 || head.length() == 0 ) {
            status = 2;
            msg = "未输入用户名或密码！";
            map.put("status", status);
            map.put("msg", msg);
            return JSON.toJSONString(map);
        }
        // 调用Service层进行注册
        int result = userService.regist(name, pwd, head, sex);
        // 用户名已存在
        if ( result == 0 ) {
            status = 0;
            msg = "用户名已存在！";
            map.put("status", status);
            map.put("msg", msg);
            return JSON.toJSONString(map);
        }
        User user = userService.findByName(name);
        session.setAttribute("user", user);
        status = 1;
        msg = "注册成功！";
        map.put("status", status);
        map.put("msg", msg);
        return JSON.toJSONString(map);
    }
}