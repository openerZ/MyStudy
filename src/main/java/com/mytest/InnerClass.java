package com.mytest;

public class
InnerClass {
    public static void main(String[] args) {
        /*A a = new A();
        A.B b = a.new B();
       A.B.C c = b.new C();
       c.h();*/

        XM xm = new XM();
        Phone rm = xm.getRM();
        rm.phone();
        rm.phone();
        rm.phone();
    }

}

//一个内部类被嵌套多少层不重要，他都能透明访问所有他嵌入的外围类的成员
class A{
    private static void f(){
        System.out.println("第一层");
    }    class B{


        private void g(){
            f();
            System.out.println("第二层");
        }

        public class C{
               void h(){
                   f();
                   g();
                   System.out.println("第三层");
               }
        }
    }

}

interface Phone{
    void phone();
}

class XM{

    private int i=0;
    private void phone(){
        System.out.println("我是小米");
        System.out.println(i++);
    }

    private class RM implements Phone{
        @Override
        public void phone() {
            XM.this.phone();
        }
    }

    Phone getRM(){
        return new RM();
    }
}