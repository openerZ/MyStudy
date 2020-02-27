package com.mytest.proxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CgLibProxy implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before.....");
        Object res = methodProxy.invokeSuper(o, objects);
        System.out.println("After");
        return res;
    }

    public static void main(String[] args) {

        CgLibProxy cg = new CgLibProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(XIoami.class);
        enhancer.setCallback(cg);

        XIoami o = (XIoami) enhancer.create();
        o.phone();
        o.Boom();

    }
}

class XIoami{
    public void phone(){
        System.out.println("我是小米手机");
    }

    public void Boom(){
        System.out.println("我会爆炸");
    }
}
