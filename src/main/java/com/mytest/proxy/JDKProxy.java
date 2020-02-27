package com.mytest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy {

    public static void main(String[] args) {
        User user = new UserImpl();
        //面向的是接口
        User userProxy = (User) Proxy.newProxyInstance(user.getClass().getClassLoader(), user.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("chang")) {
                    System.out.println("我是蔡徐坤");
                    Object invoke = method.invoke(user, args);
                    System.out.println("长达两年半的练习生");
                    return invoke;
                }else {
                    System.out.println("谢谢大家我的表演挖鼻");
                    Object invoke = method.invoke(user, args);

                    return invoke;
                }

            }
        });
        userProxy.chang();
        userProxy.tiao();

    }

}


interface User{

    void chang();

    void tiao();

}

class UserImpl implements User{

    @Override
    public void chang() {
        System.out.println("鸡你太美");
    }


    @Override
    public void tiao() {
        System.out.println("On Baby");
    }
}