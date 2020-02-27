package com.leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，
 * 则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0
 */
public class leetcode07 {
    public static int reverse(int x) {
        if (x == 0) return x;
        long a = x;
        boolean flag = true;
        if (a < 0) {
            flag = false;
            a = -a;
        }
        String s = String.valueOf(a);
        long res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            res = (long) (res + (s.charAt(i) - '0') * Math.pow(10,i));
        }

        if (!flag){
            res = res*(-1);
        }
        if (res>Integer.MAX_VALUE ||res<Integer.MIN_VALUE){
            return 0;
        }

        return (int) res;

    }

    public static void main(String[] args) {

        System.out.println(reverse(120000));

    }

    public int reverse1(int x) {
        int ans = 0;
        while (x != 0) {
            //取余
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            //缩小除10
            x /= 10;
        }
        return ans;
    }

}
