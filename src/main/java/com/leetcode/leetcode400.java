package com.leetcode;

/**
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 *
 * 注意:
 * n 是正数且在32为整形范围内 ( n < 231)。
 *
 * 示例 1:
 *
 * 输入:
 * 3
 *
 * 输出:
 * 3
 * 示例 2:
 *
 * 输入:
 * 11
 *
 * 输出:
 * 0
 *
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 * 通过次数7,410提交次数20,636
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nth-digit
 */
public class leetcode400 {

    public int findNthDigit(int n) {
        if(n<10) return n;
        long cnt = 9; //个数
        int bit = 1; //位数
        n--;
        while (n>cnt*bit){
            n-=cnt*bit;
            cnt*=10;
            bit++;
        }
        //在哪个数字
        int number = (int) (Math.pow(10,bit-1)+n/bit);
        return String.valueOf(number).charAt(n%bit)-'0';
    }
}
