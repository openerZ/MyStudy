package com.leetcode;

public class leetcode88 {

    /**
     * 从尾部进行归并排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n<=0) return;
        n--;
        m--;
        int index = nums1.length-1 ;
        while (index>=0&&n>=0){
            if (m>=0&&nums1[m]>nums2[n]){
                nums1[index--]=nums1[m--];
            }else {
                nums1[index--]=nums2[n--];
            }
        }
    }
}
