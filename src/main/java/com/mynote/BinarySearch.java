package com.mynote;


/**
 * 二分查找：
 *  对于已经排好序的数组使用二分查找
 *
 *
 *  时间复杂度：O(logN)
 *
 *
 */
public class BinarySearch {

    public static Integer binarySearch(int[] arr,int x){
        int low=0;
        int high= arr.length-1;

        while (low<=high){
            int mid = low+(high-low)/2;

            if (arr[mid]>x){
                high=mid-1;
            }else if (arr[mid]<x){
                low=mid+1;
            }else {  //arr[mid]==x
                return arr[mid];
            }

        }
        return null;

    }
}
