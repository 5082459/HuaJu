package com.HuJuHomePage.services;

import com.HuJuHomePage.Utilities.DateTool;
import com.HuJuHomePage.mappers.UserMapper;
import com.HuJuHomePage.models.Order;
import com.HuJuHomePage.models.Page;
import com.HuJuHomePage.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional //声明事务
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Page page;

    @Override
    public void saveUser(String name, Integer age) {

        userMapper.insertUser(name,age);
    }

    @Override
    public Student login(String name, String password) {
        return userMapper.findStudent(name,password);
    }


    @Override
    public void submitOrder(Order order) {
        userMapper.insertOrder(order);
    }

    @Override
    public Page findRecordOfOne(Integer currentPage, Integer pageSize, Student student) {
        int rows = userMapper.selectRowNum(student.getStudentId());
        System.out.println("rows = " + rows);
        page.setRows(rows);
        page.setPageSize(pageSize);
        page.setPageNum(currentPage);
        page.setData(userMapper.selectRecordOfOne(page.getIndexNum(),page.getPageSize(),student.getStudentId()));
        return page;
    }

    @Override
    public Page findAllRecord(Integer currentPage, Integer pageSize) {
        int rows = userMapper.selectAllRowNum();
        System.out.println("rows = " + rows);
        page.setRows(rows);
        page.setPageSize(pageSize);
        page.setPageNum(currentPage);
        page.setData(userMapper.selectAllRecord(page.getIndexNum(),page.getPageSize()));
        return page;
    }

    @Override
    public Integer cancelOrder(Integer orderId, String startTime) {
        if (DateTool.isOutDate(startTime)){
            return 0;
        }
        userMapper.deleteOrder(orderId);
        return 1;
    }

    @Override
    public boolean inRight(Student student, String startTime, String endTime) {
        return DateTool.canOrder(student.getDataLimit(),student.getTimeLimit(),startTime,endTime);
    }

    @Override
    public List<Order> findRecentOrder() {
        return userMapper.RecentOrder(DateTool.getCurrentStr());
    }

}
