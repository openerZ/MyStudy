package com.leetcode;

public class leetcode190 {
    public int reverseBits(int n) {
        int res = 0;
        int count=0;
        while (count<32){
            //res左移预留一位
            res<<=1;
            //当前n的最后一位添加到res的最后一位
            res|=(n&1);
            //n右移一位
            n>>=1;
            count++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1431655765));
    }

}
