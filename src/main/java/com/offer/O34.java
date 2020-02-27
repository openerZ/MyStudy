package com.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class O34 {

    /**
     * 拼接得到的数的位数是固定的所以就要求最大位数值最小的作为拼接的最高位
     * 当多个位数的最大位
     *
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return "";

        int length = numbers.length;
        //转换成String两两进行拼接比较
        String[] strs = new String[length];
        for (int i = 0; i < length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
        //制定自己的排序规则
        Arrays.sort(strs, new Comparator<String>() {
            /**
             * 规则是：比较每个数的最高位位数，位数小的在前
             * 排序规则如下：
             *   若ab > ba 则 a > b，
             *   若ab < ba 则 a < b，
             *   若ab = ba 则 a = b；
             */
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });

        StringBuilder s = new StringBuilder();

        for (String str : strs) {
            s.append(str);
        }

        return s.toString();


    }


    public String PrintMinNumber1(int[] numbers) {
        StringBuilder str = new StringBuilder();
        //冒泡排序变种，根据题目自己定义排序规则
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int a = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int b = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if (a > b) {
                    int t = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = t;
                }

            }
        }
        for (int i = 0; i < numbers.length; i++) {
            str.append(numbers[i]);
        }
        return str.toString();
    }
}
