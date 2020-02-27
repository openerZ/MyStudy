package com.leetcode.weekLeetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Week175 {

    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(2 * i) || ((i & 1) == 0 && set.contains(i >> 1))) {
                return true;
            }
            set.add(i);
        }
        return false;

    }

    /*************************************/

    public int minSteps(String s, String t) {
        int[] zm = new int[26];

        for (int i = 0; i < s.length(); i++) {
            zm[s.charAt(i) - 97]++;
        }

        for (int i = 0; i < t.length(); i++) {
            zm[t.charAt(i) - 97]--;
        }

        int res = 0;
        for (int i = 0; i < zm.length; i++) {
            res += Math.abs(zm[i]);
        }
        return res / 2;
    }

    /*************************************/

    class TweetCounts {

        private HashMap<String,List<Integer>> map;

        public TweetCounts() {

            map = new HashMap<>();
        }

        public void recordTweet(String tweetName, int time) {
            if (map.containsKey(tweetName)) {
                List<Integer> list = map.get(tweetName);
                list.add(time);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(time);
                map.put(tweetName,list);
            }
        }

        public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
            List<Integer> ret = new ArrayList<>();
            int delta=60;
            if ("hour".equals(freq)){
                delta=3600;
            }else if ("day".equals(freq)){
                delta = 3600*24;
            }
            int n = (endTime-startTime)/delta +1;
            int[] arr = new int[n];

            List<Integer> list = map.get(tweetName);
            for (Integer i : list) {
                if (i<startTime || i>endTime) continue;
                arr[(i-startTime)/delta]++;
            }
            for (int i : arr) {
                ret.add(i);
            }
            return ret;
        }
    }

    /*************************************/


    private boolean isAQ1(char[][] seats, int i, int j) {
        if (i == 0) {
            if (j == seats[0].length - 1) {
                return isWC(seats, i, j - 1);
            } else if (j == 0) {
                return isWC(seats, i, j + 1);
            } else {
                return isWC(seats, i, j - 1) && isWC(seats, i, j + 1);
            }
        } else {
            if (j == seats[0].length - 1) {
                return isWC(seats, i, j - 1) && isWC(seats, i - 1, j - 1);
            } else if (j == 0) {
                return isWC(seats, i, j + 1) && isWC(seats, i - 1, j + 1);
            } else {
                return isWC(seats, i, j - 1) && isWC(seats, i, j + 1) && isWC(seats, i - 1, j + 1) && isWC(seats, i - 1, j - 1);
            }
        }
    }

    private boolean isWC(char[][] seats, int i, int j) {
        if (seats[i][j] == '.' ) {
            return false;
        }
        return true;
    }

    public int maxStudents1(char[][] seats) {
        //dp[i][j][0] 不做时到此刻的位置可做多少人
        //dp[i][j][1] 做时到此刻的位置可做多少人
        int[][][] dp = new int[seats.length][seats[0].length][2];
        int dp0 = 0, dp1 = 0;
        if (seats[0][0] == '.') {
            dp[0][0][0] = 0;
            dp[0][0][1] = 1;
            dp1 = 1;
        }
        int j = 1;
        for (int i = 0; i < seats.length; i++) {
            for (; j < seats[0].length; j++) {
                if (seats[i][j] == '.') {
                    if (isAQ1(seats, i, j)) {
                        dp[i][j][0] = dp1;
                        dp[i][j][1] = dp1 + 1;
                    } else {
                        dp[i][j][0]=dp1;
                        dp[i][j][1] = dp0;
                    }
                } else {
                    dp[i][j][0] = dp0;
                    dp[i][j][1] = dp1;
                }
                dp0 = dp[i][j][0];
                dp1 = dp[i][j][1];
            }
            j = 0;

        }
        return Math.max(dp0, dp1);

    }

}
