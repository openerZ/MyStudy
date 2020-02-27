package com.offer;

/**
 *题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 还是斐波那契数列
 * f(1)=1 ,f(2)=2, f(n)=f(n-1)+f(n-2)
 *
 */
public class O11 {

    public int RectCover(int target) {
        if (target<=2) return target;
        int f1=2,f2=1;
        int f3=0;
        for (int i=3;i<target+1;i++){
            f3=f1+f2;
            f2=f1;
            f1=f3;
        }
        return f3;
    }
}
