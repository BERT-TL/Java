package com.bert.boot.config;

import com.bert.boot.bean.Car;
import com.bert.boot.bean.Pet;
import com.bert.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

/**
 *     1. 配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例
 *     2. 配置类本身（MyConfig）也是组件
 *     3. proxyBeanMethods：代理bean的方法
 *        Full(proxyBeanMethods = true)
 *        Lite(proxyBeanMethods = false)//轻量级
 *        组件依赖必须是用Full模式默认，其他默认是Lite模式
 *
 *     4. @Import({User.class, DBHelper.class})
 *          给容器自动创建这两个类型的组件，默认组件的名字就是全类名
 *
 *     5. @ConditionalOnBean(name = "tom")条件配置，只有条件成立才装配
 *
 *     6. @ImportResource("classpath:beans.xml")允许导入Spring的配置文件
 */


@Configuration(proxyBeanMethods = true) //告诉Spring Boot这是一个配置类==配置文件
@Import({User.class})
@ConditionalOnBean(name = "tom1")//条件装配，Bean条件装配，只有条件成立才装配
//@ImportResource("classpath:beans.xml")

//@EnableConfigurationProperties(Car.class);//跟@Componen二选一
//1. 开启Car的配置绑定功能
//2. 把Car这个组件自动注册到容器中
public class MyConfig {

    /**
     *  外部无论对配置类中这个组件注册方法调用多少次获取的都是之前容器中注册的单实例对象
     */

    @Bean   //给容器中添加组件。以方法名作为组件id（user）。返回类型就是组件类型。返回的值就是组件在容器在的实例
    public User user() {
        User user = new User("zhangsan", 18);
        //user组件依赖了Pet组件
        user.setPet(tomcatPet());
        return user;
    }

    @Bean("tom")//自定义名称作为id
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }
}
