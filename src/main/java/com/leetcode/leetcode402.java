package com.leetcode;

import java.util.Stack;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * <p>
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 * <p>
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * <p>
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 * <p>
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 */
public class leetcode402 {

    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (n == k) return "0";
        char[] chars = num.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (k > 0 && i < n) {
            int c = chars[i] - '0';
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
            i++;
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        for (int j = i; j < n; j++) {
            stack.push(chars[j] - '0');
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        res = res.reverse();
        int j = 0;
        for (; j < res.length(); j++) {
            char c = res.charAt(j);
            if (c != '0') {
                break;
            }
        }
        if (j == res.length()) return "0";
        return res.substring(j, res.length());
    }

    public static void main(String[] args) {
        leetcode402 lc = new leetcode402();
        System.out.println(lc.removeKdigits("1432219", 3));
    }
}
