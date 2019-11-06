package com.HuJuHomePage.services;

import com.HuJuHomePage.models.Order;
import com.HuJuHomePage.models.Page;
import com.HuJuHomePage.models.Student;

public interface UserService {

    void saveUser(String name, Integer age);

    Student login(String name, String password);

    void submitOrder(Order order);

    Page findRecordOfOne(Integer pageNum, Integer pageSize, Student student);

    Page findAllRecord(Integer pageNum, Integer pageSize);

    Integer cancelOrder(Integer orderId, String startTime);
}
