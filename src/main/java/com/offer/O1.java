package com.offer;

import java.util.HashMap;

/**
 *
 * 数组中的重复数字
 */
public class O1 {

    public static void main(String[] args) {
        int[] ints = new int[5];
        boolean sloution = sloution(new int[]{2, 4, 3, 1, 1}, 5, ints);
        System.out.println(sloution);
        System.out.println(ints[0]);

    }

    /**
     * 因为要求空间复杂度为O(1)只能使用原地算法
     * 因为长为N的数组中的元素范围是0 -- N-1 所以我们可以让元素值为i的放到下标i的地方
     * 如果在遍存储交换i的时候发现i位置已经存在了i的值
     *
     */
    public static boolean sloution(int[] arr,int length,int[] aup){
        if (arr ==null || length==0) return false;

        for (int i=0;i<length;i++){
            //一直遍历到i位置上的值为i
            while (arr[i]!=i){
                if (arr[i]==arr[arr[i]]){ //如果i位置的值在arr[arr[i]]也存在代表重复
                    aup[0] = arr[i];
                    return true;
                }
                swap(arr,i,arr[i]); //交换值
            }
        }
        return false;
    }

    /**
     * 将i上不等于i的值转换到其应该的位置，即位置为arr[i]上
     *
     * @param arr
     * @param i 原位置
     * @param j 转换后的位置
     */
    public static void swap(int[] arr,int i,int j){
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;

    }

}
