package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class leetcode66 {

    public int[] plusOne(int[] digits) {

        int len = digits.length - 1;
        digits[len]++;
        int a=0,b=0;
        for (int i = len; i>=0; i--) {
           a=(digits[i]+b)%10;
           b=(digits[i]+b)/10;
           digits[i]=a;
        }
        if (b>0){
            int[] arr = new int[digits.length+1];
            arr[0]=b;
            return arr;
        }
        return digits;
    }
}
