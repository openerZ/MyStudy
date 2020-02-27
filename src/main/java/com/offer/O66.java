package com.offer;

/**
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class O66 {

    public int[] multiply(int[] A) {
        if (A==null || A.length==0) return new int[0];
        int length = A.length;
        int[] B = new int[length];
        B[0] = 1;
        //计算下三角连乘
        for (int i = 1; i <length ; i++) {
            B[i] = B[i-1]*A[i-1];
        }
        //计算上三角连乘
        int temp=1;
        for (int i = length-2; i >=0 ; i--) {
            temp *=A[i+1];
            B[i] *=temp;
        }

        return B;
    }
}
