package com.leetcode;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class leetcode42 {


    /**
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int res=0;
        for (int i = 1; i < height.length-1; i++) {
            //当前列的左边最高的墙
            int leftMax=0;
            for (int j = 0; j < i; j++) {
                if (height[j]>leftMax){
                    leftMax=height[j];
                }

            }
            //当前列的右边最高的墙
            int rightMax=0;
            for (int j = i+1; j < height.length; j++) {
                if (height[j]>rightMax){
                    rightMax=height[j];
                }
            }
            //两边墙较矮的
            int min = Math.min(leftMax,rightMax);

            //只有较小的墙大于当前墙才能接住水
            if (min>height[i]){
                res+=(min-height[i]);
            }
        }
        return res;
    }

    public int trap(int[] height) {
        int length = height.length;
        //第 i 列左边最高的墙的高度
        int[] maxLeft = new int[length];
        //第 i 列右边最高的墙的高度
        int[] maxRight = new int[length];
        for (int i = 1; i < length-1; i++) {
            maxLeft[i]=Math.max(maxLeft[i-1],height[i-1]);
        }

        for (int i = length-2; i >=0 ; i--) {
            maxRight[i]=Math.max(maxRight[i+1],height[i+1]);

        }

        int res=0;
        for (int i = 1; i <length-1 ; i++) {
            int min = Math.min(maxLeft[i],maxRight[i]);
            if (min>height[i]){
                res+=(min-height[i]);
            }
        }
        return res;
    }

    public int trap2(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2; // 加右指针进去
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
                //从右到左更
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }
}
