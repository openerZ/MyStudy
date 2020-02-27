package com.offer;


public class O9 {

    /**
     *题目描述
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     */
    public int JumpFloor(int target) {

        if (target<=2) return target;

        int t1 = 2,t2=1;
        int t=0;
        for (int i=3;i<target+1;i++){
            t=t1+t2;
            t2=t1;
            t1=t2;
        }
        return t;
    }


}
