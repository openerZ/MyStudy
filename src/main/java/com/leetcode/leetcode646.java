package com.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 *
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 *
 * 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 * 示例 :
 *
 * 输入: [[1,2], [2,3], [3,4]]
 * 输出: 2
 * 解释: 最长的数对链是 [1,2] -> [3,4]
 * 注意：
 *
 * 给出数对的个数在 [1, 1000] 范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-pair-chain
 */
public class leetcode646 {

    //贪心
    public int findLongestChain1(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int res=1;
        int temp = pairs[0][1];
        for (int i = 1; i <pairs.length ; i++) {
            if (pairs[i][0]>temp){
                res++;
                temp = pairs[i][1];
            }
        }
        return res;

    }
    //dp
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] dp = new int[n+1];
        int max = 0;
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        for (int i = 0; i < n; i++) {
            dp[i]=1;
            for (int j = i-1; j >=0; j--) {
                if (pairs[j][1]<pairs[i][0]){
                    dp[i]+=dp[j];
                    break;
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
