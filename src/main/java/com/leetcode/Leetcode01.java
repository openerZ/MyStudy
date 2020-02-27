package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Leetcode01 {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        ArrayList<Integer> list = new ArrayList<>(length);
        for (int i=0;i<length;i++){
            int m=target-nums[i];
            if (list.contains(i)) {
                continue;
            }
            for (int j=i+1;j<length;j++){
                if (m==nums[j] && !list.contains(j)){
                    list.add(i);
                    list.add(j);
                    break;
                }
            }
        }

        int[] a = new int[list.size()];
        int k=0;

        for (Integer integer : list) {
            a[k++]=integer;
        }
        return a;
    }

    public int[] aa(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i=0;i<length;i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};

            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        Leetcode01 leetcode = new Leetcode01();
        int[] ints = leetcode.twoSum(a, 9);

        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
