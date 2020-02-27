package com.leetcode;


/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class leetcode05 {

    /**
     * 暴力破解O(N3)
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 1) return s;

        String res = String.valueOf(s.charAt(0));
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String test = s.substring(i, j);
                if (isHW(test) && test.length() > max) {
                    res = test;
                    max = res.length();
                }
            }
            return res;
        }
        return res;
    }

    private boolean isHW(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 中心扩散法：
     * 回文份偶数长度回文：
     * 以中心的两个数左右对称，如abccba,
     * 奇数回文：
     * 以最中间的进行两边对称
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() <= 1) return s;

        int length = s.length();
        int ll = 0;
        int rr = 0;
        int max = 1;
        for (int i = 0; i < length; i++) {
            int l = i - 1;
            int r = i + 1;

            //奇数扩散
            while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > max) {
                    max = r - l + 1;
                    ll = l;
                    rr = r;
                }
                l--;
                r++;
            }
            //偶数扩散
            l = i;
            r = i + 1;
            while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > max) {
                    max = r - l + 1;
                    ll = l;
                    rr = r;
                }
                l--;
                r++;
            }
        }

        return s.substring(ll, rr + 1);
    }

    /**
     * dp
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {

        int n = s.length();
        if (n==0) return "";
        //dp[i][j] 是i -- j 位置的字符串是否是回文字符串
        //dp[i][i] 一定是回文
        boolean[][] dp = new boolean[n][n];
        int start = 0, end = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j-i<3) {
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && (j - i) > (end - start)) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public String longestPalindrome3(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        String str = addBoundaries(s, '#');
        int sLen = 2 * len + 1;
        int maxLen = 1;

        int start = 0;
        for (int i = 0; i < sLen; i++) {
            int curLen = centerSpread(str, i);
            if (curLen > maxLen) {
                maxLen = curLen;
                start = (i - maxLen) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private int centerSpread(String s, int center) {
        // left = right 的时候，此时回文中心是一个空隙，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是任意一个字符，回文串的长度是偶数
        int len = s.length();
        int i = center - 1;
        int j = center + 1;
        int step = 0;
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            step++;
        }
        return step;
    }


    /**
     * 创建预处理字符串
     *
     * @param s      原始字符串
     * @param divide 分隔字符
     * @return 使用分隔字符处理以后得到的字符串
     */
    private String addBoundaries(String s, char divide) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        if (s.indexOf(divide) != -1) {
            throw new IllegalArgumentException("参数错误，您传递的分割字符，在输入字符串中存在！");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(divide);
            stringBuilder.append(s.charAt(i));
        }
        stringBuilder.append(divide);
        return stringBuilder.toString();
    }

}
