package com.leetcode;

import org.omg.CORBA.MARSHAL;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class leetcode32 {


    public int longestValidParentheses2(String s) {
        if (s.equals("")) return 0;
        //dp[i]表示已s.chart(i)为结尾的字符的合法长度
        int[] dp = new int[s.length()];
        int maxLen = 0;
        for (int i = 1; i < s.length(); i++) {
            //以')'向前匹配
            if (s.charAt(i) == ')') {
                //若前一个是'('
                if (s.charAt(i - 1) == '(') {
                    if (i == 1) {
                        dp[i] = 2;
                    } else {
                        dp[i] = dp[i - 2] + 2;
                    }
                } else if (s.charAt(i - 1) == ')') { //若前一个是')'
                    if (i > 1) {
                        //就要匹配他上一个合法字符序列的前边的一个位置是否是'('
                        if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                            dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                        }
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    public int longestValidParentheses(String s) {
        if (s.equals("")) return 0;
        char[] chars = s.toCharArray();
        //正序和倒序都要遍历一遍用来互补
        return Math.max(StateLength(chars, 0, s.length(), 1, '('), StateLength(chars, s.length() - 1, -1, -1, ')'));
    }

    private int StateLength(char[] chars, int start, int end, int flag, char gz) {
        int max = 0, sum = 0;
        int curLen = 0;
        for (; start != end; start += flag) {
            sum += (chars[start] == gz ? 1 : -1);
            curLen++;
            if (sum < 0) {
                //sum<0代表有效字符中断
                sum = 0;
                curLen = 0;
            } else if (sum == 0) {
                max = Math.max(max, curLen);
            }

        }
        return max;
    }


    /**
     * 2.1若当前字符s[index]为左括号'('，将当前字符下标index入栈（下标稍后有其他用处），处理下一字符
     * <p>
     * 2.2若当前字符s[index]为右括号')'，判断当前栈是否为空
     * <p>
     * 2.2.1若栈为空，表示有效字符中断则start = index + 1，处理下一字符（当前字符右括号下标不入栈）
     * <p>
     * 2.2.2若栈不为空，则出栈（由于仅左括号入栈，则出栈元素对应的字符一定为左括号，可与当前字符右括号配对），判断栈是否为空
     * <p>
     * 2.2.2.1若栈为空，则max = max(max, index-start+1)
     * <p>
     * 2.2.2.2若栈不为空，则max = max(max, index-栈顶元素值)
     *
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        maxLen = Math.max(maxLen, i - start + 1);
                    } else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        leetcode32 a = new leetcode32();
        System.out.println(a.longestValidParentheses("\"()\""));
    }
}
