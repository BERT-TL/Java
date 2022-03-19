package com.bert.spring5.Bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPost implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String var2)
            throws BeansException{
        System.out.println("在初始化之前执行的");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String var2) throws BeansException{
        System.out.println("在初始化之后执行的");
        return bean;
    }
}
