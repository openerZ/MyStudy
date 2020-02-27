package com.leetcode;

/**
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1: 
 *
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 *
 * 输入: [0,1]
 * 输出: 0
 */
public class leetcode201 {


    /**
     * 寻找公共吗,m n的二进制公共前缀
     * 因为二进制上0与0,1按位与都是0，非公共前缀因为累加肯定出现过0只有公共前缀没有变化
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {

        int count=0;
        while (m!=n){
            m>>=1;
            n>>=1;
        }

        return m<<count;


    }

    public static void main(String[] args) {
        leetcode201 a = new leetcode201();

        System.out.println(a.rangeBitwiseAnd(5,21));
        System.out.println(5&22);

    }
}
