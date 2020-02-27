package com.leetcode.weekLeetcode;

import java.util.HashMap;

public class DoubleWeek20 {
    class Cashier {

        int n;
        int discount;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] prices;
        int num;

        public Cashier(int n, int discount, int[] products, int[] prices) {
            num = 0;
            this.n = n;
            for (int i = 0; i < products.length; i++) {
                map.put(products[i], i);
            }
            this.prices = prices;
            this.discount = discount;
        }

        public double getBill(int[] product, int[] amount) {
            double res = 0;
            for (int i = 0; i < product.length; i++) {
                int a = map.get(product[i]);
                res += (prices[a] * amount[i]);
            }
            num++;
            if (num % n == 0) {
                res = res - (discount * res) / 100;
            }
            return res;
        }
    }

    public int numberOfSubstrings(String s) {
        int[] arr = new int[3];
        int cnt = 0;

        int res = 0;
        int begin = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (arr[c - 'a'] == 0) {
                cnt++;
            }
            arr[c - 'a']++;
            while (cnt == 3) {
                res += s.length() - end;
                char b = s.charAt(begin);
                if (arr[b - 'a'] == 1) {
                    cnt--;
                }
                arr[b - 'a']--;
                begin++;
            }
            end++;
        }
        return res;
    }

    public int countOrders(int n) {
        int detail = 1000000000 + 7;
        if (n == 1) return 1;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        /**i 对是在（i-1）对的基础上得来的
         *  一对收件和派件（P,D）如何插入之前已经排好的顺序
         * 所以(i-1)对的一种排列能够插入的组合有 int num=2*(i-1)+1 + (2*(i-1)+1)*(2*(i-1))/2
         * i-1对时一种有dp[i-1]种排列，所以dp[i]=dp[i-]*num;
         */
        for (int i = 2; i <= n; i++) {
            long a = 2 * (i - 1);
            dp[i] = (dp[i - 1] * ((a + 1) * a / 2 + a + 1)) % detail;
        }
        return (int) (dp[n] % detail);
    }
}
