package com.offer;

/**
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class O8 {
    /**
     * 使用递归：
     * 优点：简介明了
     * 缺点：时间复杂度过高，有重复计算的值
     *
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n <= 1)
            return n;

        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    /**
     *使用循环将值存储起来，避免重复计算
     * 时间和空间复杂度都是O(N)
     *
     * @param n
     * @return
     */
    public int Fibonacci1(int n) {
        if (n==0 || n==1) return n;
        int[] f = new int[n+1];
        f[1] =1;
        for (int i=2;i<n+1;i++){
            f[i] = f[i-1]+f[i-2];
        }

        return f[n];
    }

    /**
     *维护计算n-1,和n-2的值
     *
     * @param n
     * @return
     */
    public int Fibonacci2(int n) {
        if (n <= 1)
            return n;
       int f1=1,f2=0;
       int fib=0;
       for (int i=2;i<n+1;i++){
           fib = f1+f2;
           f2=f1;
           f1=fib;
       }
        return fib;
    }


}
