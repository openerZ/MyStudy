package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class leetcode215 {

    public int findKthLargest1(int[] nums, int k) {
        if (nums.length == 0) return 0;
        Queue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() < k) {
                minHeap.add(nums[i]);
            } else {
                if (nums[i] > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }
        }
        return minHeap.peek();
    }

    /**
     * 快速选择
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int i = left, j = right - 1;
            int t = nums[right];
            while (true) {
                while (i <= j && nums[i] >= t) i++;
                while (i <= j && nums[j] <= t) j--;
                if (i<j){
                    swap(nums,i,j);
                }else {
                    swap(nums,i,right);
                    break;
                }
            }

            if (i==(k-1)){
                return nums[i];
            }else if (i<(k-1)){
                left=i+1;
            }else {
                right = i-1;
            }
        }
        return -1;
    }


    private static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest4(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 转换一下，第 k 大元素的索引是 len - k
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right) {
        // 在区间随机选择一个元素作为标定点
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }

        int pivot = nums[left];

        // 将等于 pivot 的元素分散到两边
        // [left, lt) <= pivot
        // (rt, right] >= pivot

        int lt = left + 1;
        int rt = right;

        while (true) {
            while (lt <= rt && nums[lt] < pivot) {
                lt++;
            }
            while (lt <= rt && nums[rt] > pivot) {
                rt--;
            }

            if (lt > rt) {
                break;
            }
            swap(nums, lt, rt);
            lt++;
            rt--;
        }

        swap(nums, left, rt);
        return rt;
    }


    public int findKthLargest5(int[] nums, int k) {
        if(nums==null || nums.length==0 || k>nums.length) return -1;
        int n = nums.length-k;
        int l = 0, r= nums.length-1;
        while(l < r){
            int index = partition1(nums,l,r);
            if(index == n) return nums[n];
            if(index > n) r = index - 1;
            else l = index + 1;
        }
        return nums[n];
    }
    public int partition1(int[] arr,int l,int r){
        int k = arr[l];
        while(l < r){
            while(l < r && arr[r] >= k) r--;
            arr[l] = arr[r];
            while(l < r && arr[l] <= k) l++;
            arr[r] = arr[l];
        }
        arr[l] = k;
        return l;
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]=temp;
    }
}
