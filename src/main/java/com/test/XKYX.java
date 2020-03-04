package com.test;

import java.util.*;

public class XKYX {

    static Set<Integer> res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] sarr = s.split("|");
        ArrayList<Integer> listQ = new ArrayList<>();
        int d = Integer.valueOf(sarr[2]);
        String[] a = sarr[0].substring(1, sarr[0].length() - 1).split(",");
        TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            String s1 = a[i].substring(1, a[i].length());
            i++;
            String s2 = a[i].substring(0, a[i].length() - 1);
            Set<Integer> set = map.get(Integer.valueOf(s1));
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(Integer.valueOf(s2));
            map.put(Integer.valueOf(s1), set);
        }
        a = sarr[1].substring(1, sarr[1].length() - 1).split(",");
        for (String s1 : a) {
            listQ.add(Integer.valueOf(s1));
        }
        res = new HashSet<>();
        int[] isVisited = new int[map.size()];
        for (Integer integer : listQ) {
            dfs(map,integer,d,isVisited,new HashSet<Integer>());
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(res);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0;i<list.size();i++){
            sb.append(list.get(i));
            if (i==list.size()-1){
                sb.append("]");
            }else {
                sb.append(",");
            }
        }

    }



    public static boolean dfs( TreeMap<Integer, Set<Integer>> map,int a,int b,int[] isVisited ,Set<Integer> set){
        if (a==b){
            res.addAll(set);
            return true;
        }
        if (isVisited[a]!=0){
            return false;
        }
        Set<Integer> ss = map.get(a);
        isVisited[a] = 1;
        boolean flag = false;
        for (Integer s : ss) {
            if (isVisited[s]==0){
                set.add(s);
                boolean dfs = dfs(map, s, b, isVisited, set);
                if (!dfs){
                   set.remove(s);
                   isVisited[s]=-1;
                }else {
                    flag =true;
                }
            }
        }
        return flag;
    }

    public void Q2() {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[7];

        for (int i = 0; i < 7; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(1);

    }


    public void Q1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * 7;
        }
        System.out.println(dp[n] * 2);

    }
}
