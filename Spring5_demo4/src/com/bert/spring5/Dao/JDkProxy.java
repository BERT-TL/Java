package com.bert.spring5.Dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDkProxy {

    public static void main(String[] args) {
        //创建接口实现类代理对象
        Class[] interfaces = {UserDao.class};
//        Proxy.newProxyInstance(JDkProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });

        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDkProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int result = dao.add(1,2);
        System.out.println("result="+result);
    }
}

//创建代理对象代码
class UserDaoProxy implements InvocationHandler {

    //把创建的是谁的代理对象，把谁传进来
    //有参构造传递
    private Object obj;
    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    //增强逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //方法之前
        System.out.println("方法之前执行："+method.getName()+"：传递参数："+ Arrays.toString(args));

        //被增强的方法执行
        Object ret = method.invoke(obj,args);

        //方法之后
        System.out.println("方法之后执行："+obj);

        return ret;
    }
}

