package com.leetcode;

import java.util.Arrays;

/**
 * 给定一个正整数 n，你可以做如下操作：
 * <p>
 * 1. 如果 n 是偶数，则用 n / 2替换 n。
 * 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
 * n 变为 1 所需的最小替换次数是多少？
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 8
 * <p>
 * 输出:
 * 3
 * <p>
 * 解释:
 * 8 -> 4 -> 2 -> 1
 * 示例 2:
 * <p>
 * 输入:
 * 7
 * <p>
 * 输出:
 * 4
 * <p>
 * 解释:
 * 7 -> 8 -> 4 -> 2 -> 1
 * 或
 * 7 -> 6 -> 3 -> 2 -> 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode397 {
    int[] dp;

    private int getSlove(int i) {
        if (dp[i] != -1) return dp[i];
        int temp = 1;
        if ((i & 1) == 0) {
            temp += getSlove(i / 2);
        } else {
            temp += Math.min(getSlove(i - 1), getSlove(i + 1));
        }
        dp[i] = temp;
        return dp[i];
    }

    //会超出内存限制
    public int integerReplacement(int n) {
        dp = new int[n + 2];
        Arrays.fill(dp, -1);
        dp[1] = 0;
        return getSlove(n);
    }

    public int integerReplacement1(int n) {
        int count = 0;
        long a = n;
        while (a!=1){
            //3是个特列
            if (a==3){
                count+=2;
                break;
            }

            if ((a&1)==0){
                a>>=1;
            }else {
                //如果(a++)/2依然是偶数
                if ((a&2)==2){
                    a++;
                }else {
                    a--;
                }
            }
            count++;
        }
        return count;
    }

}
