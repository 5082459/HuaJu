package com.HuJuHomePage.controllers;

import com.HuJuHomePage.models.Order;
import com.HuJuHomePage.models.Page;
import com.HuJuHomePage.models.Student;
import com.HuJuHomePage.models.User;
import com.HuJuHomePage.services.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("orderPage")
public class UserController {

    @Autowired
    private User user;

    @Autowired
    private Student student;

    @Autowired
    private Order order;

    @Autowired
    private Page page;

    @Autowired
    private UserService userService;

    @RequestMapping("/saveUser")
    @ResponseBody
    public User saveUser(String name , Integer age){
        user.setName(name);
        user.setAge(age);
        userService.saveUser(name,age);
        return user;
    }

    @RequestMapping("/saveStudent")
    @ResponseBody
    public String  saveStudent(){
        System.out.println("访问成功....");
        return "访问成功...";
    }

    /**
     * 提交预定
     * http://localhost:8080/HuaJu/orderPage/submitOrder
     * startTime 开始时间 String
     * endTime 结束时间 String
     * theme 主题 String
     * activityContent 活动内容 String
     * @return  code: -1 提交失败(系统异常) 0 不能预订 1 提交成功 2 预订冲突 int
     *          预订冲突时同时返回冲突订单：key = orderList  value = 冲突订单集合 List
     */
    @RequestMapping("/submitOrder")
    @ResponseBody
    public Map<String,Object> submitOrder(@RequestBody JSONObject param, HttpSession session){
        String startTime = param.getString("startTime");
        String endTime = param.getString("endTime");
        String theme = param.getString("theme");
        String activityContent = param.getString("activityContent");
        Map<String,Object> returnMap = new HashMap<>();
        student = (Student) session.getAttribute("loginUser");
        if (!userService.inRight(student,startTime,endTime)){
            returnMap.put("code",0);
            return returnMap;
        }
        List<Order> orderList = userService.isInConflict(startTime,endTime);
        if (orderList != null && orderList.size() != 0){
            returnMap.put("code",2);
            returnMap.put("orderList",orderList);
            return returnMap;
        }
        order.setStudentId(student.getStudentId());
        order.setStudentName(student.getName());
        order.setStartTime(startTime);
        order.setEndTime(endTime);
        order.setTheme(theme);
        order.setActivityContent(activityContent);
        System.out.println(order);
        userService.submitOrder(order);
        returnMap.put("code",1);
        return returnMap;
    }

    /**
     * 最近未过期预约
     * http://localhost:8080/HuaJu/orderPage/findRecentOrder
     * @param pageNum 页数
     * @param pageSize 每页显示数据
     * @return 预约单 Page
     */
    @RequestMapping("/findRecentOrder")
    @ResponseBody
    public Page findRecentOrder(Integer pageNum, Integer pageSize){
        return userService.findRecentOrder(pageNum,pageSize);
    }


    /**
     * 我的预约
     * http://localhost:8080/HuaJu/orderPage/findRecordOfOne
     * @param pageNum 当前页数 int
     * @param pageSize 每一页显示数据 int
     * @return 返回一页的数据 Page 系统异常返回 code : -1
     */
    @RequestMapping("/findRecordOfOne")
    @ResponseBody
    public Page findRecordOfOne(Integer pageNum, Integer pageSize, HttpSession session){
        student = (Student)session.getAttribute("loginUser");
        return userService.findRecordOfOne(pageNum,pageSize,student);
    }

    /**
     * 查找所有预约
     * http://localhost:8080/HuaJu/orderPage/findAllRecord
     * @param pageNum pageNum 当前页数 int
     * @param pageSize 每一页显示数据 int
     * @return 返回一页的数据 Page 系统异常返回 code : -1
     */
    @RequestMapping("/findAllRecord")
    @ResponseBody
    public Page findAllRecord(Integer pageNum, Integer pageSize){
        return userService.findAllRecord(pageNum,pageSize);
    }

    /**
     * 取消预约
     * http://localhost:8080/HuaJu/orderPage/cancelOrder
     * @param orderId 预约id String
     * @param startTime 预约时间 String
     * @return code: 0 过时不能取消 -1 取消失败（系统异常） 1 取消成功 int
     */
    @RequestMapping("/cancelOrder")
    @ResponseBody
    public  Map<String,Integer> cancelOrder(Integer orderId,String startTime){
        Map<String,Integer> returnMap = new HashMap<>();
        returnMap.put("code",userService.cancelOrder(orderId,startTime));
        return returnMap;
    }

    /**
     * 获取登录用户对象
     * http://localhost:8080/HuaJu/orderPage/getOnlineUser
     * @return 登录用户对象 Student
     */
    @RequestMapping("/getOnlineUser")
    @ResponseBody
    public Student getOnlineUser(HttpSession session){
        return (Student)session.getAttribute("loginUser");
    }

    /**
     * 获取登录用户对象
     * http://localhost:8080/HuaJu/orderPage/getStudentById
     * @param studentId  Integer
     * @return 对象 Student 查询失败返回 studentId = -1,其他属性为null
     */
    @RequestMapping("/getStudentById")
    @ResponseBody
    public Student getStudentById(Integer studentId) throws Exception{
        Student student = userService.findStudentBuId(studentId);
        if (student == null){
            student = new Student(-1);
        }
        return student;
    }

}
