package com.zmh;

public class TestNoNameClass {

    public static Base getBase(int i){
        return new Base(i) { //匿名内部类
            @Override
            void f() {
                System.out.println("你妹的");
            }

            //匿名内部类额外创建的方法无法调用
            public void ff(){
                System.out.println("大家好");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(45);
        base.f();

    }
}
