package com.bert.spring5.Service;

import com.bert.spring5.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*
value值可以省略不写
默认名是类名，首字母小写
 */
@Service(value = "userService")//<bean id="" class=""></bean>
public class UserService {

    @Autowired
    @Qualifier(value = "userDaoImpl1")//要与Autowired配合使用，根据名称注入
    private UserDao userDao;

    public void add() {
        System.out.println("service....");
        userDao.add();
    }
}
