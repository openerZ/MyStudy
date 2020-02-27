package com.test;

public class SumNum {

    public int SumNUmbers(int a,int b){
        int c=0;
        while (b!=0){
            c=a^b; //两数异或的结果是不进制的结果
            b = (a&b)<<1; //两数相与并左移1位是进制数
            a=c;
        }
        return a;

    }

    public static void main(String[] args) {
//        SumNum a = new SumNum();

//        System.out.println(a.SumNUmbers(112,-3));
        /*byte b = (byte) 128;
        System.out.println(b);*/
        System.out.println(Integer.toBinaryString(-42));
        System.out.println(Integer.toBinaryString(42));
        System.out.println(Integer.toOctalString(42));
        System.out.println(Integer.toHexString(42));

    }
}
