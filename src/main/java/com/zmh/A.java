package com.zmh;

public class A {
    private int a=5;
    private static int q=6;

    //普通方法也可以与类名相同
    public static void A() {
        System.out.println("a");
    }

    A() {
        A();
    }

    public static void main(String[] args) {
        new A();
    }

    /**
     * 静态内部类不能调用外部的非静态成员与方法
     * 静态内部类可以被继承
     */
    static class B {
        String str= "sda";
//        int b=a;
    }

    /**
     * 非静态内部类可以调用外部的所有成员与方法
     */
    class C{
//        非静态内部类不能静创建态成员
//        public static Integer a=5;
        int z = a;
    }
}
