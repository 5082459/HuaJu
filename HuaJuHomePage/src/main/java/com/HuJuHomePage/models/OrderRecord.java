package com.HuJuHomePage.models;

import org.springframework.stereotype.Component;

@Component
public class OrderRecord {
    private String recordId;
    private String studentId;
    private String orderId;

    public OrderRecord() {
    }

    public OrderRecord(String recordId, String studentId, String orderId) {
        this.recordId = recordId;
        this.studentId = studentId;
        this.orderId = orderId;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderRecord{" +
                "recordId='" + recordId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
