package com.offer;

/**
 *
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class O12 {

    public int NumberOf1(int n) {
        if (n==0)return 0;
        return Integer.bitCount(n);

    }

    /**
     * n&(n-1)
     * 该位运算去除 n 的位级表示中最低的那一位。
     *
     * n       : 10110100
     * n-1     : 10110011
     * n&(n-1) : 10110000
     * @param n
     * @return
     */
    public int NumberOf11(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }
}
