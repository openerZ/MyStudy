package com.leetcode.weekLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class DoubleWeek22 {

    public static void main(String[] args) {
        DoubleWeek22 dd = new DoubleWeek22();


    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n = arr1.length;
        int m = arr2.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int a = arr1[i];
            for (int j = 0; j < m; j++) {
                if (Math.abs(a - arr2[j]) <= d) {
                    cnt++;
                    break;
                }
            }
        }
        return n - cnt;
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        //2-5 4-7 6-9
        int length = reservedSeats.length;
        int max = 0;
        Arrays.sort(reservedSeats, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        int[] dp = new int[11];
        int index = 0;
        int k = 1;
        while (k <= n) {
            while (index < length) {
                int[] rs = reservedSeats[index];
                if (rs[0] == k) {
                    dp[rs[1]] = k;
                    index++;
                }else {
                    break;
                }
            }
            if (isOK(dp, k, 2)) {
                max++;
                if (isOK(dp, k, 6)) {
                    max++;
                }
            } else {
                if (isOK(dp, k, 4)) {
                    max++;
                } else if (isOK(dp, k, 6)) {
                    max++;
                }
            }
            k++;
        }
        return max;
    }

    private boolean isOK(int[] dp, int k, int j) {
        for (int i = j; i < j + 4; i++) {
            if (dp[i]==k) {
                return false;
            }
        }
        return true;
    }

    public int getKth(int lo, int hi, int k) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            int a = i;
            int cnt = 0;
            while (a != 1) {
                if (a % 2 == 0) {
                    a = a / 2;
                } else {
                    a = a * 3 + 1;
                }
                cnt++;
            }
            list.add(new int[]{i, cnt});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        return list.get(k - 1)[0];
    }


}
