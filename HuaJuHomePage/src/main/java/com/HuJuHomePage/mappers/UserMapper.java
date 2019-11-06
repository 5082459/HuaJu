package com.HuJuHomePage.mappers;


import com.HuJuHomePage.models.Order;
import com.HuJuHomePage.models.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Insert("insert into users(name,age) values(#{0},#{1})")
    void insertUser(String name, Integer age);

    @Select("select * from students where name = #{0} and password = #{1}")
    Student findStudent(String name, String password);

    @Insert("insert into orders(studentId,startTime,endTime,theme,activityContent) values(#{studentId},#{startTime},#{endTime},#{theme},#{activityContent})")
    void insertOrder(Order order);

    @Select("select count(*) from orders where studentId=#{0}")
    int selectRowNum(Integer studentId);

    @Select("select * from orders where studentId= #{2} ORDER BY orderId DESC LIMIT #{0},#{1}")
    List<Order> selectRecordOfOne(int indexNum, int pageSize, Integer studentId);

    @Select("select count(*) from orders")
    int selectAllRowNum();

    @Select("select * from orders ORDER BY orderId DESC LIMIT #{0},#{1}")
    List<Order> selectAllRecord(int indexNum, int pageSize);

    @Delete("delete from orders where orderId = #{0}")
    void deleteOrder(Integer orderId);

    @Select("select * from orders where startTime >= #{0}")
    List<Order> RecentOrder(String currentStr);
}
