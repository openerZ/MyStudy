package com.leetcode;

public class leetcode204 {


    public int countPrimes1(int n) {
        boolean[] isPrim = new boolean[n];
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrim[i]) {
                cnt++;
                for (long j = (long) i * i; j < n; j += i) {
                    isPrim[(int) j] = true;
                }
            }
        }
        return cnt;
    }

    /**
     * 筛选法，时间复杂度O(NloglogN)
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (!isPrim[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = true;
                }
            }
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrim[i]) {
                res++;
            }
        }

        return res;

    }
}
