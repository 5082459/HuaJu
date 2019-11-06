package com.HuJuHomePage.models;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Page {
    private List<Order> data;
    private int pageNum;//当前页数
    private int pageSize;//当前页显示条数
    private int rows;//总行数

    // 数据总条数可以用sql语句select count（*）from table 获得
    // select * from table limit 开始索引，显示条数

    public Page(int pageNum, int pageSize, int rows) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.rows = rows;
    }
    public Page() {
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        if(pageNum > getTotalPage())
        {
            this.pageNum = getTotalPage();
        }
        else {
            this.pageNum = pageNum;
        }
        if(pageNum < 1)
        {
            this.pageNum=1;
        }
    }

    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        //计算总页数
        if(rows % pageSize == 0)
        {
            return rows / pageSize;
        }
        else {
            return rows/pageSize + 1;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getIndexNum() {
        //获取索引值
        return pageSize * (pageNum - 1);
    }

    public List<Order> getData() {
        return data;
    }

    public void setData(List<Order> data) {
        this.data = data;
    }
}
