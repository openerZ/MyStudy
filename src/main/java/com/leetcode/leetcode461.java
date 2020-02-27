package com.leetcode;

public class leetcode461 {

    public int hammingDistance(int x, int y) {
        int num = x^y;
        int res=0;
        while (num!=0){
            res++;
            num&=(num-1);
        }
        return res;
    }
}
