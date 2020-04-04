package com.leetcode;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class leetcode29 {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int res = 0;
        if (dividend < 0 && divisor < 0) {
            while (dividend <= divisor) {
                dividend -= divisor;
                res++;
            }
        } else if (dividend < 0 && divisor > 0) {
            while (dividend <= 0) {
                dividend += divisor;
                res--;
            }
            res++;
        } else if (dividend > 0 && divisor < 0) {
            while (dividend >= 0) {
                dividend += divisor;
                res--;
            }
            res++;
        } else {
            while (dividend >= divisor) {
                dividend -= divisor;
                res++;
            }
        }
        return res;
    }

    public int divide1(int dividend, int divisor) {
        //如果都是负数或整数sign为false，一正一负为true
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        //被除数和除数都转成负数了
        while (dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while (dividend <= (temp_divisor << 1)) {
                if (temp_divisor <= (Integer.MIN_VALUE >> 1)) break;
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if (!sign) {
            if (result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = -result;
        }
        return result;
    }

    public int divide2(int dividend, int divisor) {
        //验证是正数还是负数
        int sign = (dividend ^ divisor) >> 31;
        //用long
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);

        long res = 0;

        while (lDividend >= lDivisor) {
            long tmp = lDivisor;
            long i = 1;
            while (lDividend >= tmp) {
                lDividend -= tmp;
                res += i;
                i <<= 1;
                tmp <<= 1;
            }
        }
        if (sign == -1) res *= -1;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) res;

    }
}
