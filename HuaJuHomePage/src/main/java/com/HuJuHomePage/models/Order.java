package com.HuJuHomePage.models;

import org.springframework.stereotype.Component;

@Component
public class Order {
    private int orderId;
    private int studentId;
    private String studentName;
    private String startTime;
    private String endTime;
    private String theme;
    private String activityContent;
    private int cancelStage;

    public Order() {
    }

    public Order(int orderId, int studentId, String studentName, String startTime, String endTime, String theme, String activityContent, int cancelStage) {
        this.orderId = orderId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.theme = theme;
        this.activityContent = activityContent;
        this.cancelStage = cancelStage;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime.split("\\.")[0];
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime.split("\\.")[0];
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }

    public int getCancelStage() {
        return cancelStage;
    }

    public void setCancelStage(int cancelStage) {
        this.cancelStage = cancelStage;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", theme='" + theme + '\'' +
                ", activityContent='" + activityContent + '\'' +
                ", cancelStage=" + cancelStage +
                '}';
    }
}
