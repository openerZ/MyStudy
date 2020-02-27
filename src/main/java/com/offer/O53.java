package com.offer;

/**
 * 题目描述
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class O53 {

    /**
     * 递归调用利用短路
     * @param n
     * @return
     */
    public int Sum_Solution1(int n) {
        int sum = n;
        //当sum等于0时，会发生短路，后边就不会继续调用了
        boolean flag = (sum>0)&&((sum+=Sum_Solution(--n))>0);
        return sum;
    }

    /**
     * 利用异常退出递归
     *
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        try{
            int i = 1%n;
            return n+Sum_Solution(n-1);
        }catch (Exception e){
            return 0;
        }

    }
}
