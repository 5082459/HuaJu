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

    @Insert("insert into orders(studentId,studentName,startTime,endTime,theme,activityContent) values(#{studentId},#{studentName},#{startTime},#{endTime},#{theme},#{activityContent})")
    void insertOrder(Order order);

    @Select("select count(*) from orders where studentId=#{0}")
    int selectRowNum(Integer studentId);
    @Select("select count(*) FROM orders WHERE startTime > #{0}")
    int selectRecentRowNum(String currentStr);

    @Select("select * from orders where studentId= #{2} ORDER BY startTime DESC LIMIT #{0},#{1}")
    List<Order> selectRecordOfOne(int indexNum, int pageSize, Integer studentId);

    @Select("select count(*) from orders")
    int selectAllRowNum();

    @Select("select * from orders ORDER BY startTime DESC LIMIT #{0},#{1}")
    List<Order> selectAllRecord(int indexNum, int pageSize);

    @Delete("delete from orders where orderId = #{0}")
    void deleteOrder(Integer orderId);

    @Select("select * from orders where startTime >= #{0} ORDER BY startTime DESC LIMIT #{1},#{2}")
    List<Order> selectRecentRecord(String currentStr, int indexNum, int pageSize);

    @Select("select * FROM orders \n" +
            "WHERE startTime < #{0} AND endTime > #{0} \n" +
            "OR startTime < #{1} AND endTime > #{1} \n" +
            "OR startTime < #{0} AND endTime > #{1} \n" +
            "OR startTime > #{0} AND endTime < #{1} \n" +
            "OR startTime = #{0} AND endTime = #{1} \n" +
            "OR startTime > #{0} AND startTime < #{1} \n" +
            "OR endTime > #{0} AND endTime < #{1} \n" +
            "ORDER BY startTime DESC; ")
    List<Order> selectInConflict(String startTime, String endTime);

    @Select("select * from students where studentId = #{0}")
    Student selectStudentById(Integer studentId);


}
