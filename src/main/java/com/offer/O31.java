package com.offer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class O31 {

    private class MaxHeap {

    }


    /**
     * 采用最大堆处理
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length < k || k <= 0) return list;
        int length = input.length;

        //使用最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++) {
            maxHeap.add(input[i]);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }

        for (Integer integer : maxHeap) {
            list.add(integer);
        }

        return list;
    }


    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length == 0 || input.length < k) return list;
        int length = input.length;

        Arrays.sort(input);
        for (int i = 0; i < length && i < k; i++) {
            list.add(input[i]);
        }

        return list;
    }

    /**
     * 使用快速选择排序法：前k个位置就是要求的值
     * 会改变原数组
     * 时间复杂度：O(N)
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length < k || k <= 0) return list;
        findKthSmallest(input, k);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    /**
     * 是对于数组的前K个元素已经处于数组的前K个空间
     *
     * @param arr
     * @param k
     */
    private void findKthSmallest(int[] arr, int k) {
        int l = 0;
        int h = arr.length - 1;
        while (l < h) {

            int j = partition(arr, l, h);
            if (j == k)
                break;
            if (j > k) {
                h = j - 1;
            } else {
                l = j + 1;
            }
        }
    }

    /**
     * 单个快速排序
     *
     * @param arr
     * @param l
     * @param h
     * @return
     */
    private int partition(int[] arr, int l, int h) {
        //切分元素
        int v = arr[l];
        int i = l, j = h + 1;
        while (true) {
            while (i < h && arr[++i] < v) ;
            while (j > l && arr[--j] > v) ;
            if (i >= j)
                break;
            swap(arr, i, j);
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
