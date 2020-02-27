package com.mytest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Test1116 {

    Integer a;
    Integer b =a;

    @Test
    public void Test01(){

        short i = 5;
        final int a = 6;
//        i = (short) (i+5); //必须要强制转换因为基本数值类型相加时计算的结果会转型为因数的最大类型
        i =a+5;  //如果因数中有final类型时不必强转
        System.out.println(i);
        i = (short) (i+5);
    }
    @Test
    public void test02(){
        /**
         * 低精度的可以自行向高精度的转换
         * 低位也可以自行向高位转换
         */
        long test = 012;
        double t1 = 0x12;
        float f = -412;
        System.out.println(test);
        System.out.println(t1);
        System.out.println(f);

        //低精度必须强制转换才能复制给低精度
        int a = (int) 1.1f;
        //高位必须强制转换才能赋值给低位的
        int b = (int) 5L;
    }

    float fun1(){
        /*Integer i=1;
        return i; // integer 、int 可以自动转型为float*/

        short i = 5;
        return i;

    }

    float fun2(){
//        long a = 5L;
        Long a = new Long(5);
        return a; // long 、 Long 也会自动转为float
    }

    //double 不能自动隐式的转为float
   /* float fun3(){
        double a = 5.0;
        return a;
    }*/

   @Test
   public void test03(){
       System.out.println(a);
       System.out.println(a==b);
   }

    @Test
    public void test04(){
        Hashtable<String,String> table = new Hashtable<>();
        Map<String,String> map = new HashMap<>();

//        table.put(null,null);  //HashTable 不能存入空键空值
//        table.put("a",null);
        map.put(null,null);

        System.out.println(table.size());
        System.out.println(map.size());

    }

   String aaa = "zmh";
    public static void main(String[] args) {
        //非静态字段不能直接在静态域中使用
//        System.out.println(aaa);
        //可以通过实例化对象后调用
        System.out.println(new Test1116().aaa);
    }
}



/**
 * abstract 和 final 不能同时组合使用
 *
 */
abstract class abs{

//    abstract final void fun();
}

