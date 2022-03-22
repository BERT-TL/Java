package com.bert.boot;

import com.bert.boot.bean.Pet;
import com.bert.boot.bean.User;
import com.bert.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Converter;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *     主程序类
 *     @SpringBootApplication: 告诉程序这是一个Spring Boot应用
 */
@SpringBootApplication
public class mainApplication {

    public static void main(String[] args) {
        //1. 返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(mainApplication.class, args);

        //2. 查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names){
            System.out.println(name);
        }

        //3. 从容器在调用组件
//        Pet tom1 = run.getBean("tom", Pet.class);
//        Pet tom2 = run.getBean("tom", Pet.class);
//        System.out.println("组件"+(tom1 == tom2));
//
//        //4. com.bert.boot.config.MyConfig$$EnhancerBySpringCGLIB$$81436cc1@4642b71d
//        MyConfig myConfig = run.getBean(MyConfig.class);
//        System.out.println(myConfig);
//
//        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法，SpringBoot总会检查这个组件是否在容器中，要保持组件单实例
//        User user01 = run.getBean("user",User.class);
//        User user02 = run.getBean("user",User.class);
//        System.out.println(user01 == user02);
//
//        /**
//         *  proxyBeanMethods = true   ---> true
//         *  proxyBeanMethods = false  ---> false
//         */
//        User user = run.getBean("user",User.class);
//        Pet tom = run.getBean("tom", Pet.class);
//        System.out.println("用户的宠物："+(user.getPet()==tom));
//
//
//        //5. 获取组件
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        System.out.println("=====");
//        for (String name : beanNamesForType){
//            System.out.println(name);
//        }


        //看是否有tom组件
        boolean tom = run.containsBean("tom");
        System.out.println("容器中tom组件："+tom);

        boolean user = run.containsBean("user");
        System.out.println("容器中user组件："+user);


    }

}
