package com.bert.spring5.Bean;

public class Emp {
    private String name;
    private String gender;

    private Dept dept;

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void test() {
        System.out.println(name+":"+gender+":"+dept);
    }
}
