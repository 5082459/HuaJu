package com.HuJuHomePage.controllers;

import com.HuJuHomePage.models.Order;
import com.HuJuHomePage.models.Page;
import com.HuJuHomePage.models.Student;
import com.HuJuHomePage.models.User;
import com.HuJuHomePage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public User saveUser(String name ,Integer age){
        System.out.println(name + "=====" + age);
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
     * @param startTime 开始时间 String
     * @param endTime 结束时间 String
     * @param theme 主题 String
     * @param activityContent 活动内容 String
     * @return  code: 0 提交失败 1 提交成功 int
     */
    @RequestMapping("/submitOrder")
    @ResponseBody
    public Map<String,Integer> submitOrder(String startTime,String endTime,String theme,String activityContent,HttpSession session){
        Map<String,Integer> returnMap = new HashMap<>();
        student = (Student) session.getAttribute("loginUser");
        System.out.println(student);
        order.setStudentId(student.getStudentId());
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
     * 我的预约
     * http://localhost:8080/HuaJu/orderPage/findRecordOfOne
     * @param pageNum 当前页数 int
     * @param pageSize 每一页显示数据 int
     * @return 返回一页的数据 List<Order>
     */
    @RequestMapping("/findRecordOfOne")
    @ResponseBody
    public Page findRecordOfOne(Integer pageNum,Integer pageSize, HttpSession session){
        student = (Student)session.getAttribute("loginUser");
        return userService.findRecordOfOne(pageNum,pageSize,student);
    }

    /**
     * 查找所有预约
     * http://localhost:8080/HuaJu/orderPage/findAllRecord
     * @param pageNum pageNum 当前页数 int
     * @param pageSize 每一页显示数据 int
     * @return 返回一页的数据 List<Order>
     */
    @RequestMapping("/findAllRecord")
    @ResponseBody
    public Page findAllRecord(Integer pageNum,Integer pageSize){
        return userService.findAllRecord(pageNum,pageSize);
    }

    /**
     * 取消预约
     * @param orderId 预约id String
     * @param startTime 预约时间 String
     * @return code: 0 取消失败 1 取消成功 int
     */
    @RequestMapping("/cancelOrder")
    @ResponseBody
    public  Map<String,Integer> cancelOrder(Integer orderId,String startTime){
        Map<String,Integer> returnMap = new HashMap<>();
        returnMap.put("code",userService.cancelOrder(orderId,startTime));
        return returnMap;
    }
}
