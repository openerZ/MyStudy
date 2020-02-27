package com.mytest;


import java.io.UnsupportedEncodingException;

public class StringTest {

    public static void main(String[] args) throws UnsupportedEncodingException {

       /* String s = new String("你必须付出一切".getBytes(),"UTF-8" );
        System.out.println(s);*/

        /*String s = "Java 核心技能";
        String substring = s.substring(1, 3); //左闭右开
        System.out.println(s);
        System.out.println(substring.length());*/

        String a ="";
        System.out.println(a.split(",").length); // ","的个数+1
    }
}
