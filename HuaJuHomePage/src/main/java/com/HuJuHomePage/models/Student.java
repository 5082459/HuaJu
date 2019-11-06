package com.HuJuHomePage.models;

import org.springframework.stereotype.Component;

@Component
public class Student {

    private Integer studentId;
    private String name;
    private String password;
    private String section;
    private String phoneNum;
    private String weChatNum;
    private String QQNum;
    private int position;
    private int dateLimit;
    private int timeLimit;

    public Student() {
    }

    public Student(Integer studentId, String name, String password, String section, String phoneNum, String weChatNum, String QQNum, int position) {
        this.studentId = studentId;
        this.name = name;
        this.password = password;
        this.section = section;
        this.phoneNum = phoneNum;
        this.weChatNum = weChatNum;
        this.QQNum = QQNum;
        this.position = position;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getWeChatNum() {
        return weChatNum;
    }

    public void setWeChatNum(String weChatNum) {
        this.weChatNum = weChatNum;
    }

    public String getQQNum() {
        return QQNum;
    }

    public void setQQNum(String QQNum) {
        this.QQNum = QQNum;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getDataLimit() {
        if (position == 1){
            dateLimit = 14;
        }else if (position == 2){
            dateLimit = 2;
        }else {
            dateLimit = 365;
        }
        return dateLimit;
    }

    public int getTimeLimit() {
        return 6;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", section='" + section + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", weChatNum='" + weChatNum + '\'' +
                ", QQNum='" + QQNum + '\'' +
                ", position=" + position +
                '}';
    }
}