package com.offer;

import java.util.HashSet;

/**
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class O40 {

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashSet<Integer> set = new HashSet<>();

        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (set.contains(array[i])) {
                set.remove(array[i]);
            } else {
                set.add(array[i]);
            }
        }

        Integer[] a = (Integer[]) set.toArray();
        num1[0] = a[0];
        num2[0] = a[1];

    }

    /**
     * 利用异或的特性：相同为为0，不同为1 ，任何数字和自己异或为0，和0异或为本身
     */
    public void FindNumsAppearOnce1(int[] array, int num1[], int num2[]) {

        int result = 0;

        //对数组所有的元素异或，最后的结果是连个不同元素的异或结果
        //因为相同得到都被抵消了
        for (int i : array) {
            result ^= i;
        }

        //找出异或结果的二进制最低位上的1的位置
        int index = 1; //表示两个结果从倒数第几位上开始不同
        while ((result & 1) != 1) {
            index++;
            result >>= 1;
        }
        //用来比较将数组分为两部分，index位上位1的一部分，不为1的一部分
        //因为相同的数必被分到一组，而两个不同的数必被分到两组
        int t = 1 << (index - 1);
        for (int i : array) {
            if ((i & t) == t) {
                num1[0] ^= i;
            } else {
                num2[0] ^= i;
            }

        }
    }

    /**
     * 两个不相等的元素在位级表示上必定会有一位存在不同，
     * 将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
     *
     * diff &= -diff 得到出 diff 最右侧不为 0 的位，
     * 也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，
     * 利用这一位就可以将两个元素区分开来。
     */
    public void FindNumsAppearOnce2(int[] nums, int num1[], int num2[]) {
        int diff = 0;
        for (int num : nums)
            diff ^= num;
        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0)
                num1[0] ^= num;
            else
                num2[0] ^= num;
        }
    }
}
