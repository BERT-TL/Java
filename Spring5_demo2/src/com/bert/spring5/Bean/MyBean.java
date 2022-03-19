package com.bert.spring5.Bean;

public class MyBean {
    private String name;

    //无参构造
    public MyBean() {
        System.out.println("第一步：无参构造");
    }


    //调用set方法
    public void setName(String name) {
        this.name = name;
        System.out.println("第二步：调用set方法");
    }

    //第三步配置初始化方法
    public void InitMethod() {
        System.out.println("第三步：配置初始化方法");
    }

    //第五步：配置销毁方法
    public void DestroyMethod() {
        System.out.println("第五步：配置销毁方法");
    }
}
