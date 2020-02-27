package com.offer;

/**
 * 题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class O54 {


    /**
     *1.两个数异或：相当于每一位相加，而不考虑进位；
     *2. 两个数相与，并左移一位：相当于求得进位；
     *3. 将上述两步的结果相加
     */
    public int Add(int num1, int num2) {
        int sum = 0;
        while (num2 != 0) {
            sum = num1 ^ num2; //得到的不进位结果
            num2 = (num1 & num2) << 1; //两数逻辑与然后在左移一位表示的产生的进位
            num1 = sum;
        }
        return num1;
    }

}
