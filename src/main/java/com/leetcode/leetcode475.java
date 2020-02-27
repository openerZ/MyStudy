package com.leetcode;

import org.omg.CORBA.MARSHAL;

import java.util.Arrays;

/**
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 *
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 *
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 *
 * 说明:
 *
 * 给出的房屋和供暖器的数目是非负数且不会超过 25000。
 * 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
 * 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
 * 所有供暖器都遵循你的半径标准，加热的半径也一样。
 * 示例 1:
 *
 * 输入: [1,2,3],[2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 示例 2:
 *
 * 输入: [1,2,3,4],[1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 */
public class leetcode475 {

    /**
     * 每个房屋至少被一个供暖器覆盖
     *  可以被前一个或者后一个，取两者近的，在这些符合的路径中取最大的
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
        if (heaters.length==0||houses.length==0) return 0;
        //先对双方排序
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int k = 0;
        int max = 0;
        for (int i = 0; i < houses.length ; i++) {
            //到最近的供暖器的半径距离
            int temp = 0;
            //更新供暖器的位置直到当前供暖器的位置大于等于当前房屋的位置或者供暖器到头
            while (k<heaters.length-1&&houses[i] > heaters[k]) {
                k++;
            }
            if (k == 0) {
                temp = Math.abs(heaters[k]-houses[i]);
            }else {
                temp = Math.min(Math.abs(houses[i]-heaters[k-1]), Math.abs(heaters[k] - houses[i]));
            }
            max = Math.max(temp,max);
        }
        return max;
    }
}
