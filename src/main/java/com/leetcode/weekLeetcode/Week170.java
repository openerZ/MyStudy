package com.leetcode.weekLeetcode;

import java.util.*;

public class Week170 {

    public String freqAlphabets(String s) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");
        map.put(5, "e");
        map.put(6, "f");
        map.put(7, "g");
        map.put(8, "h");
        map.put(9, "i");
        map.put(10, "j");
        map.put(11, "k");
        map.put(12, "l");
        map.put(13, "m");
        map.put(14, "n");
        map.put(15, "o");
        map.put(16, "p");
        map.put(17, "q");
        map.put(18, "r");
        map.put(19, "s");
        map.put(20, "t");
        map.put(21, "u");
        map.put(22, "v");
        map.put(23, "w");
        map.put(24, "x");
        map.put(25, "y");
        map.put(26, "z");

        StringBuilder res = new StringBuilder();
        int index = s.length() - 1;
        while (index >= 0) {
            if (s.charAt(index) == '#') {
                res.append(map.get(Integer.valueOf(s.substring(index - 2, index))));
                index = index - 3;
            } else {
                res.append(map.get(s.charAt(index--) - '0'));
            }
        }

        return res.reverse().toString();

    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int temp = 0;
            for (int j = start; j <= end; j++) {
                temp ^= arr[j];
            }
            res[i] = temp;
        }
        return res;
    }

    List<String> res = new ArrayList<>();

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {

        HashSet<Integer> ids = new HashSet<>();
        for (int i : friends[id]) {
            if (i != id) {
                ids.add(i);
            }
        }
        wvf(watchedVideos,friends,ids,level,1,id);
        return res;
    }


    private class DD{
        String s;
        int freq;

        public DD(String s, int freq) {
            this.s = s;
            this.freq = freq;
        }
    }
    private void wvf(List<List<String>> watchedVideos, int[][] friends, HashSet<Integer> friendsId, int level, int myLevel,int myid) {
        if (myLevel == level) {
            //找视频
            HashMap<String, Integer> map = new HashMap<>();
            for (Integer integer : friendsId) {
                if (integer==myid) continue;
                for (String s : watchedVideos.get(integer)) {
                    Integer orDefault = map.getOrDefault(s, 0);
                    map.put(s,orDefault+1);
                }
            }
            Queue<DD> queue = new PriorityQueue<>(new Comparator<DD>() {
                @Override
                public int compare(DD o1, DD o2) {
                    return o1.freq-o2.freq;
                }
            });



            return;
        }
        //找朋友
        HashSet<Integer> nextFriends = new HashSet<>();
        for (Integer id : friendsId) {
            for (int i : friends[id]) {
                if (friendsId.contains(i)) continue;
                nextFriends.add(i);
            }
        }
        wvf(watchedVideos,friends,nextFriends,level,myLevel+1,myid);
    }

    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(0,s.length()-1,s,dp);
    }

    private int dfs(int l,int r,String s,int[][] dp){
        if (r-l<=0) return 0;
        if (dp[l][r]!=-1) return dp[l][r];
        int cur=Math.min(dfs(l+1,r,s,dp),dfs(l,r-1,s,dp))+1;
        if (s.charAt(l)==s.charAt(r)) cur = Math.min(cur,dfs(l+1,r-1,s,dp));

        return dp[l][r]=cur;
    }
    public int minInsertions1(String s) {

        int n=s.length();
        int[][] dp=new int[n+1][n+1];
        StringBuilder str=new StringBuilder();
        for(int i=n-1;i>=0;i--) str.append(s.charAt(i));
        String s1=str.toString();

        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++) {
                if(s.charAt(i-1)==s1.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
            }

        return n-dp[n][n];
    }


}
