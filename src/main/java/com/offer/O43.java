package com.offer;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class O43 {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array==null ||array.length==0) return list;
        int length = array.length;
        int start = 0,end = length-1;

       while (start<end){
           int curSum = array[start] + array[end];
           if (curSum==sum){
               list.add(array[start]);
               list.add(array[end]);
               return list;
           }else if (curSum<sum){
               start++;
           }else {
               end--;
           }
       }
       return list;
    }
}
