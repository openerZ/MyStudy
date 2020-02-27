package com.mytest;

import org.junit.Test;

import java.io.*;
import java.util.*;

public class main {


//    public static void main(String[] args) {
//       /* String a = new String("aaa");
//        String intern = a.intern();
//        String b = "aaa";
//        String c = "aaa";
//        System.out.println(a==b);  //false
//        System.out.println(intern==b); //true
//        System.out.println(b==c); //true*/
//
//       String a = new String("aaa");
//       String d = new String("aaa");
//        System.out.println(a==d);
//        System.out.println(a.hashCode());
//        System.out.println(d.hashCode());
//        System.out.println(a.hashCode()==d.hashCode());
//        HashSet<String> set = new HashSet<>();
//        set.add(a);
//        set.add(d);
//        System.out.println(set.size());
//
//        List<Object> list = new ArrayList<>();
//        list.add("aaa");
//        list.add(15);
//        List<String> li = new ArrayList<>();
//        list.addAll(li);
//    }



    public static void main(String[] args) {
        /*try {
            *//**
             * 反射的三种的实现方式
             *//*
            //1.通过Object的getClass()方法:要有实例对象
            String a = new String("aaa");
            Class<? extends String> aClass = a.getClass();
            //2.Class.forName("全限定类名")
            Class.forName("sa");
            //3.通过关键字class: 类名.class
            Class<String> stringClass = String.class;
            try {
                String s = stringClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        /*int[] a = {1,2,3};
        List<int[]> ints = Arrays.asList(a);  //使用基本类型数组对象作为asList()的参数返回的List的元素是数组对象
        System.out.println(ints.size());
        Integer[] b = {1,2,3};
        List<Integer> integers = Arrays.asList(b);
        System.out.println(integers.size());

        List<Integer> integers1 = Arrays.asList(1, 2, 5, 6);
        System.out.println(integers1.size());

        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> syncList = Collections.synchronizedList(list); //线程安全的List
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("")));
        oos.writeObject(list);*/

       /* System.out.println(128>>>2);
        System.out.println(128>>2);

        System.out.println(64<<1);*/
//        System.out.println(64<<<1); //没有<<<

       /* *//**
         * hashcode 相同不代表对象相同
         * ==为true hashcode一定相同
         *
         *//*
        String a = new String("aaa");
        String d = new String("aaa");
        System.out.println(a == d);
        System.out.println(a.hashCode());
        System.out.println(d.hashCode());
        System.out.println(a.hashCode() == d.hashCode());*/

    }

    @Test
    public void testintern(){
        String s = new String("a"); //创建了两个对象 一个在常量池一个在堆中
        String s2 = s.intern();//返回的是常量池的
        System.out.println(s==s2); //false


        String s3 = new String("a") + new String("a");
        String s4 = s3.intern(); //"aa"在常量池不存在就将s3的引用放到常量池中并返回
        System.out.println(s3==s4); //true

    }

    @Test
    public void testintern2(){
        String s = new String("a"); //创建了两个对象 一个在常量池一个在堆中
        String s2 = s.intern();//返回的是常量池的
        String s1 = "a";
        System.out.println(s==s2); //false
        System.out.println(s==s1); //false
        System.out.println(s1==s2); //true


        String s3 = new String("a") + new String("a");
        String s4 = s3.intern(); //"aa"在常量池不存在就将s3的引用放到常量池中并返回
        System.out.println(s3==s4); //true

    }

}
