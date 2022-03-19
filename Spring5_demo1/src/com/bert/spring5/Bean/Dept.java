package com.bert.spring5.Bean;

public class Dept {
    private String dept;

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dept='" + dept + '\'' +
                '}';
    }
}
