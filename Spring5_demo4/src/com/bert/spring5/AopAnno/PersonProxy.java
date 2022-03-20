package com.bert.spring5.AopAnno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)//设置增强类优先级
public class PersonProxy {

    @Before(value = "execution(* com.bert.spring5.AopAnno.User.add(..))")
    public void before() {
        System.out.println("Person before...");
    }

}
