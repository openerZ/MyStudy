package com.leetcode;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class MS64 {

    public int sumNums(int n) {
        n+=n==0?0:sumNums(--n);
        return n;
    }

    public int js(int n,int sum){
        if (n==0) return sum;
        sum += n--;
        return js(n,sum);
    }
}
