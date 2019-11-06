package com.HuJuHomePage.services;

import com.HuJuHomePage.Utilities.DataTool;
import com.HuJuHomePage.mappers.UserMapper;
import com.HuJuHomePage.models.Order;
import com.HuJuHomePage.models.Page;
import com.HuJuHomePage.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
        if (DataTool.outData(startTime)){
            return -1;
        }
        userMapper.deleteOrder(orderId);
        return 1;
    }

}