package com.mytest;

public class TestPrint {
    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    public TestPrint() {
        System.out.println("3");
    }

    public static void main(String[] args) {

        /**
         * 先加载启动类的静态属性，
         * 在逐级加载对象类的原始父类的静态属性
         * 在逐级加载层级父类的普通初始块和构造函数
         */
        H h = new H();
//        new TestPrint();
        /*Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println(x == y); // false
        Integer z = Integer.valueOf(222);
        Integer k = Integer.valueOf(222);
        Integer a = 6;
        Integer b = 6;
        Short q = 8;
        short p = 8;
        System.out.println(z == k); // fasle
        System.out.println(a==b);
        System.out.println(q==p);*/

        /*String a = "abc";
        String b = "abc";
        System.out.println(a==b);*/

    }
}


class Z{
    public Z() {
        System.out.println("6");
    }

    static {
        System.out.println("2");
    }

    {
        System.out.println("5");
    }
}

class M extends Z {

    static {
        System.out.println("3");
    }

    {
        System.out.println("7");
    }
    public M() {
        System.out.println("8");
    }
}

class H extends M{
    static {
        System.out.println("4");
    }

    {
        System.out.println("9");
    }

    public H() {
        System.out.println("10");
    }
}

