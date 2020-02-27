package com.offer;

import java.util.HashMap;

/**
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 * 。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class O30 {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) return 0;
        int length = array.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int i1 = array[i];
            int i2 = 1;
            if (map.containsKey(i1)) {
                i2 = map.get(i1) + i2;
                map.put(i1, i2);
            } else {
                map.put(i1, i2);
            }
            if (i2 > length / 2) {
                return i1;
            }
        }
        return 0;
    }

    /**
     * 采用阵地攻守的思想：
     * 第一个数字作为第一个士兵，守阵地；count = 1；
     * 遇到相同元素，count++;
     * 遇到不相同元素，即为敌人，同归于尽,count--；
     * 当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，
     * 到最后还留在阵地上的士兵，有可能是主元素。
     * 再加一次循环，记录这个士兵的个数看是否大于数组一半即可。
     *
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution1(int[] array) {
        if (array == null || array.length == 0) return 0;
        int length = array.length;
        int sold = array[0];
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (count == 0) {
                sold = array[i];
            }
            if (sold == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        int k = 0;
        for (int i = 0; i < length; i++) {
            if (sold == array[i]) {
                k++;
            }
        }
        return k > length / 2 ? sold : 0;
    }

    public static void main(String[] args) {
        System.out.println( MoreThanHalfNum_Solution1(new int[]{1,2,3,2,2,2,5,4,2}));
    }
}
