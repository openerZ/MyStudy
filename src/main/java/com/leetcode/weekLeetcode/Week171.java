package com.leetcode.weekLeetcode;

public class Week171 {

    public int[] getNoZeroIntegers(int n) {
        int a = 1;
        int b = n - 1;
        while (a <= b) {
            if (isNZero(a) && isNZero(b)) {
                break;
            } else {
                a++;
                b--;
            }

        }
        return new int[]{a, b};

    }

    private boolean isNZero(int a) {

        while (a != 0) {
            int b = a % 10;
            if (b == 0) {
                return false;
            }
            a = a / 10;
        }
        return true;
    }

    public int minFlips(int a, int b, int c) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int k1 = (a >> i) & 1;
            int k2 = (b >> i) & 1;
            int k3 = (c >> i) & 1;
            if ((k1 | k2) == k3) continue;
            if (k3 == 1) {
                res++;
            } else {
                res += (k1 + k2);
            }
        }
        return res;
    }


    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(2));
        System.out.println(3 ^ 6);
    }

    int[] father;

    int find(int x){
        if (father[x]==x) return x;
        return father[x] = find(father[x]);
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
       father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }

        for (int i = 0; i < connections.length; i++) {
            int a = connections[i][0];
            int b = connections[i][1];
            int fa = find(a);
            int fb = find(b);
            father[fa] = fb;
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (father[i]==i) res++;
        }
        return res;
    }

}
