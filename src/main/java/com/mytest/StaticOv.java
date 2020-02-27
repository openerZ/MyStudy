package com.mytest;


/**
 * 静态方法(static) 无法被重写、覆盖
 * 即使在子类中写一个相同名字的也非多态，而是洗个子类的同名静态方法
 */
public class StaticOv extends Mi {


    static void B() {
        System.out.println("我是AAA");
    }


    public static void main(String[] args) {
     /*   Mi.A();
        StaticOv.A();
        StaticOv.B();*/

       /* Integer a = 5;
        Integer a1 = 5;
        System.out.println(a == a1);  //true
        int b = 5;
        long c = 5;
        Long d = 5L;

        System.out.println(a == b); //true
        System.out.println(a.equals(b)); //true
        System.out.println("b==c: " + (b == c)); // true
        System.out.println("b==d："+(b==d)); //true
        System.out.println(d.equals(b)); //false
        System.out.println(d.equals(a)); //false
        System.out.println(c == d); //true*/

        /*Integer a = 222;
        Integer b = 222;
        Integer c = Integer.valueOf(222);
        System.out.println(a == b); //false
        System.out.println(a == c); //false
        System.out.println(b == c); //false
        System.out.println(a.equals(b)); //true

        Integer m = 127;
        Integer n= 127;
        System.out.println(m==n); //true·

        Long l = 222L;
//        System.out.println(a==l);  对象类型不同无法进行==比较

        Long a1=127L;
        Long b1=127L;
        System.out.println(a1==b1); //true

        System.out.println(m.equals(a1));*/

       /* System.out.println(Math.round(10.6));
        System.out.println(Math.round(10.4));
        System.out.println(Math.round(-10.6));
        System.out.println(Math.round(-10.4));*/

       //Math.ceil() 天花板数：向上取整  Math.floor() 地板数：向下取整
       /* System.out.println(Math.ceil(10.6)); //11.0
        System.out.println(Math.ceil(10.4)); //11.0
        System.out.println(Math.ceil(-10.6));  //-10.0
        System.out.println(Math.ceil(-10.4));  //-10 .0
        System.out.println(Math.floor(10.6)); // 10.0
        System.out.println(Math.floor(-10.6)); //-11.0
        System.out.println(Math.floor(-10.4)); //-11.0*/

       try{
           System.out.println("正常执行");
       }catch (Exception e){
           System.out.println("异常执行");
       }

        System.out.println("正常执行后的最后执行");
    }
}


class Mi {
    static void A() {
        System.out.println("我是A");
    }

}

abstract class cx{

    public int a=5;
    //抽象类可以有构造方法
    public cx(){

    }
}

abstract class zmh extends cx{

}