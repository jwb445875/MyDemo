package com.iwen.excel;

import java.util.Date;

public class ExcelPort {

    private int num;
    private String name;
    private Date date;

    public ExcelPort(int num, String name, Date date) {
        this.num = num;
        this.name = name;
        this.date = date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
