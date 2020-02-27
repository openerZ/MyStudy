package com.mytest;

public class AnonymousInner {


    Color getColor(String str){

        //匿名内部类类
        return new Color() {
//            匿名内部类不能有静态成员和静态方法
//            public static int a=5;
            private String color = str;
            @Override
            public String getColor() {
                return color;
            }
        };

    }

    static class A{
        public void f(){

        }
    }

    class B extends A{

        public void ff(){
            f();
        }
    }

    public static Base geBase(int i){

        return new Base(i) {
            @Override
            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        /*AnonymousInner anonymousInner = new AnonymousInner();
        Color red = anonymousInner.getColor("ss");
        System.out.println(red.getColor());*/

        Base base = AnonymousInner.geBase(12);
        base.f();
    }
}


interface Color{
    String getColor();
}

abstract class Base{
    public Base(int i){
        System.out.println("Base constructor,i= "+i);
    }
    public abstract void f();
}

