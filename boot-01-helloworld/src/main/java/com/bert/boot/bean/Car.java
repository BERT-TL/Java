package com.bert.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@NoArgsConstructor      //无参构造器
//@AllArgsConstructor     //全参构造器

@ToString   //在编译时生成ToString方法
@Data   //lombok注解，生成已有属性的get、set的方法

@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {

    private String brand;
    private Integer price;

//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public Integer getPrice() {
//        return price;
//    }
//
//    public void setPrice(Integer price) {
//        this.price = price;
//    }
//
//    @Override
//    public String toString() {
//        return "Car{" +
//                "brand='" + brand + '\'' +
//                ", price=" + price +
//                '}';
//    }
}
