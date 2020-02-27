package com.offer;

/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class O10 {

    /**
     * f(n) = f(n-1)+f(n-2)+.....+f(1)+1;
     *
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        int[] a = new int[target];
        a[0]=1;
        for (int i=1;i<target;i++){
            a[i]=1;
            for (int j=0;j<i;j++){
                a[i]+=a[j];
            }
        }
      return a[target-1];
    }


}
