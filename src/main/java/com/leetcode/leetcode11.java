package com.leetcode;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class leetcode11 {

    /**
     * 暴力破解法
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        if (height == null || height.length <= 1) return 0;

        int max = 0;
        for (int i = 0; i < height.length; i++) {
            int a = height[i];
            for (int j = i + 1; j < height.length; j++) {
                int b = height[j];
                int mj = Math.min(a, b) * (j - i);
                if (mj > max) {
                    max = mj;
                }
            }
        }
        return max;
    }

    /**
     * 双指针法
     * <p>
     * 一个指针初始在i0一个j在尾，记录两者韦德面积
     * <p>
     * 每次移动短的板，直到i==j;
     * <p>
     * 指针移动规则与证明： 每次选定围成水槽两板高度 h[i]h[i],h[j]h[j] 中的短板，向中间收窄 11 格。以下证明：
     * <p>
     * 设每一状态下水槽面积为 S(i, j)S(i,j),(0 <= i < j < n)(0<=i<j<n)，由于水槽的实际高度由两板中的短板决定，
     * 则可得面积公式 S(i, j) = min(h[i], h[j]) × (j - i)S(i,j)=min(h[i],h[j])×(j−i)。
     * 在每一个状态下，无论长板或短板收窄 11 格，都会导致水槽 底边宽度 -1−1：
     * 若向内移动短板，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 可能变大，因此水槽面积 S(i, j)S(i,j) 可能增大。
     * 若向内移动长板，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 不变或变小，下个水槽的面积一定小于当前水槽面积。
     */
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) return 0;

        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            int a = height[i];
            int b = height[j];
            int mj = Math.min(a, b) * (j - i);
            max = Math.max(mj, max);
            //每次移动短板
            if (a > b) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }

}
