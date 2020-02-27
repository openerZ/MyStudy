package com.zmh;

import org.junit.Test;

public class Test01 {

    @Test
    public void test() {
        Class<String> stringClass = String.class;
        Class<String> stringClass1 = String.class;
        System.out.println(stringClass);
        System.out.println(stringClass1);
        System.out.println(stringClass==stringClass1);
    }

    @Test
    public void testIntern(){
        // 第一次，创建了两个对象，一个是堆中的string对象，一个是常量池中的"abc"
        String a = new String("abc");
        // 第二次，创建一个对象，堆中的另外一个string对象
        String b = new String("abc");

        String c = "abc";
        System.out.println("a==b : "+(a==b)); //fasle
        System.out.println(a.intern() == b.intern());// true
        System.out.println( a.intern() == b);// false
        System.out.println(a.intern()==a); //false
    }

    @Test
    public void test02(){
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");

        System.out.println(str5.equals(str3));
        System.out.println(str5 == str3);
        System.out.println(str5.intern() == str3);
        System.out.println(str5.intern() == str4);
    }

    @Test
    public void test03(){
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2; //在运行时才可知str4的值
        String str5 = "a"+"b";  //常量拼接，编译期已经确定str5的值

        System.out.println(str5.equals(str3)); //true
        System.out.println(str5 == str3); //true
        System.out.println(str5.intern() == str3); //true
        System.out.println(str5.intern() == str4); //false
        System.out.println(str5==str4); //false
    }
}
