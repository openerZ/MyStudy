package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"

 */
public class leetcode60 {

    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n];
        // 将 n! 种排列分为：n 组，每组有 (n - 1)! 种排列
        return recursive(n, factorial(n - 1), k, visited);
    }

    /**
     * @param n 剩余的数字个数，递减
     * @param f 每组的排列个数
     */
    private String recursive(int n, int f, int k, boolean[]visited){
        int offset = k%f;// 组内偏移量
        int groupIndex = k/f + (offset > 0 ? 1 : 0);// 第几组
        // 在没有被访问的数字里找第 groupIndex 个数字
        int i = 0;
        for(; i < visited.length && groupIndex > 0; i++){
            if(!visited[i]){
                groupIndex--;
            }
        }
        visited[i-1] = true;// 标记为已访问
        if(n - 1 > 0){
            // offset = 0 时，则取第 i 组的第 f 个排列，否则取第 i 组的第 offset 个排列
            return String.valueOf(i) + recursive(n-1, f/(n - 1), offset == 0 ? f : offset, visited);
        }else{
            // 最后一数字
            return String.valueOf(i);
        }
    }

    /**
     * 求 n!
     */
    private int factorial(int n){
        int res = 1;
        for(int i = n; i > 1; i--){
            res *= i;
        }
        return res;
    }
    public String getPermutation1(int n, int k) {
        /**
         直接用回溯法做的话需要在回溯到第k个排列时终止就不会超时了, 但是效率依旧感人
         可以用数学的方法来解, 因为数字都是从1开始的连续自然数, 排列出现的次序可以推
         算出来, 对于n=4, k=15 找到k=15排列的过程:

         1 + 对2,3,4的全排列 (3!个)
         2 + 对1,3,4的全排列 (3!个)         3, 1 + 对2,4的全排列(2!个)
         3 + 对1,2,4的全排列 (3!个)-------> 3, 2 + 对1,4的全排列(2!个)-------> 3, 2, 1 + 对4的全排列(1!个)-------> 3214
         4 + 对1,2,3的全排列 (3!个)         3, 4 + 对1,2的全排列(2!个)         3, 2, 4 + 对1的全排列(1!个)

         确定第一位:
         k = 14(从0开始计数)
         index = k / (n-1)! = 2, 说明第15个数的第一位是3
         更新k
         k = k - index*(n-1)! = 2
         确定第二位:
         k = 2
         index = k / (n-2)! = 1, 说明第15个数的第二位是2
         更新k
         k = k - index*(n-2)! = 0
         确定第三位:
         k = 0
         index = k / (n-3)! = 0, 说明第15个数的第三位是1
         更新k
         k = k - index*(n-3)! = 0
         确定第四位:
         k = 0
         index = k / (n-4)! = 0, 说明第15个数的第四位是4
         最终确定n=4时第15个数为3214
         **/

        StringBuilder sb = new StringBuilder();
        // 候选数字
        List<Integer> candidates = new ArrayList<>();
        // 分母的阶乘数
        int[] factorials = new int[n+1];
        factorials[0] = 1;
        int fact = 1;
        for(int i = 1; i <= n; ++i) {
            candidates.add(i);
            fact *= i;
            factorials[i] = fact;
        }
        k -= 1;
        for(int i = n-1; i >= 0; --i) {
            // 计算候选数字的index
            int index = k / factorials[i];
            sb.append(candidates.remove(index));
            k -= index*factorials[i];
        }
        return sb.toString();
    }

}
