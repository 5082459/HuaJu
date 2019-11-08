package com.HuJuHomePage.controllers;

import com.HuJuHomePage.models.Student;
import com.HuJuHomePage.models.User;
import com.HuJuHomePage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("loginPage")
public class LoginController {

    @Autowired
    private User user;

    @Autowired
    private Student student;

    @Autowired
    private UserService userService;
    /**
     * 登录功能
     * http://localhost:8080/HuaJu/loginPage/login
     * @param name 姓名 String
     * @param password 密码 String
     * @return code : 0 登录失败，1 登录成功
     */
    @RequestMapping("/login")
    @ResponseBody
    public Map<String,Integer> login(String name, String password, HttpSession session){
        Map<String,Integer> returnMap = new HashMap<>();
//        System.out.println(name + "============" + password);
        student = userService.login(name,password);
        returnMap.put("code",0);
        if (student != null){
            session.setAttribute("loginUser",student);
            returnMap.put("code",1);
        }
        return returnMap;
    }
    /**
     * 获取登录用户对象
     * http://localhost:8080/HuaJu/loginPage/getOpenId
     * @return 登录用户对象 Student
     */
    @RequestMapping("/getOpenId")
    @ResponseBody
    public int getOpenId(){
        return -1;
    }

    /**
     * 用户注销
     * http://localhost:8080/HuaJu/loginPage/logout
     * @return code = 1 注销成功，code = -1 系统异常
     */
    @RequestMapping("/logout")
    @ResponseBody
    public Map<String,Integer> logout(HttpSession session){
        Map<String,Integer> map = new HashMap<>();
        session.removeAttribute("loginUser");
        map.put("code",1);
        return map;
    }
}
