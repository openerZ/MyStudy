package com.leetcode;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 * <p>
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 */
public class leetcode338 {

    public int[] countBits1(int num) {
        int[] res =new int[num+1];
        res[0] = 0;
        for (int i = 1; i <=num; i++) {
            //res[i>>1]已经计算过了所含的1,
            // 和res[i]区别是最后一位，如果最后一位是1则+1,否则+0。使用(i&1)
            res[i] = res[i>>1]+(1&i);
        }

        return res;

    }
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        int i = 1;
        int pre = 0;
        while (i <= num) {
            for (int j = 0; j <= pre && i <= num; j++) {
                dp[i++] = dp[j] + 1;
            }
            pre = i-1;
        }

        return dp;
    }
}
