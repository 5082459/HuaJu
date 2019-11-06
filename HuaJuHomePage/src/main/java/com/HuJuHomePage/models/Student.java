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

    public Student() {
    }

    public Student(Integer studentId, String name, String password, String section, String phoneNum, String weChatNum, String QQNum) {
        this.studentId = studentId;
        this.name = name;
        this.password = password;
        this.section = section;
        this.phoneNum = phoneNum;
        this.weChatNum = weChatNum;
        this.QQNum = QQNum;
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
                '}';
    }
}