package com.leetcode.weekLeetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DoubleWeek23 {

    public int countLargestGroup(int n) {

        if (n <= 9) return n;
        int a = n;
        int k = 0;
        while (a != 0) {
            k++;
            a /= 10;
        }
        int[] arr = new int[9 * k + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            a = i;
            int index = 0;
            while (a != 0) {
                index += a % 10;
                a /= 10;
            }
            arr[index]++;
            max = Math.max(max, arr[index]);
        }
        int res = 0;
        for (int i : arr) {
            if (i == max) {
                res++;
            }
        }
        return res;
    }

    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (n < k) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int j = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if ((entry.getValue() & 1) != 0) {
                j++;
            }
        }
        if (j > k) return false;
        return true;
    }

    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        double left = (y2 - y1) / 2;
        double down = (x2 - x1) / 2;
        double r = Math.sqrt(left * left + down * down);
        double L = radius + r;
        double X = Math.sqrt(Math.pow(x1 + down - x_center, 2) + Math.pow(y1 + left - y_center, 2));
        if (X > L) return false;
        return true;
    }

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int res = 0;
            int k = 1;
            for (int j = i; j < n; j++) {
                res += satisfaction[j] * k++;
            }
            max = Math.max(max, res);
        }
        return max;
    }

    public int maxSatisfaction1(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int max = 0, all = 0;
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += satisfaction[i];
            all += sum;
            max = Math.max(max, all);
        }
        return max;

    }
}
