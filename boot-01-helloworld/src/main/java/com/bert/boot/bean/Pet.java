package com.bert.boot.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor      //无参构造器
@AllArgsConstructor     //全参构造器
@ToString
@Data
public class Pet {
    private String name;

//    public Pet(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Pet{" +
//                "name='" + name + '\'' +
//                '}';
//    }
}
