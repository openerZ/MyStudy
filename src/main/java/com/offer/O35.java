package com.offer;

/**
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class O35 {

    /**
     * 丑数应该是另一个丑数乘以2、3或者5的结果（1除外）
     * 从1开始，后边丑数都是前边的丑数乘2,3或5得到的
     * 如果要得到排序的丑数把前边相乘的到的丑数进行排列
     *
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;

        int ugly[] = new int[index];
        ugly[0] = 1;

        //指向前边的丑数
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < index; i++) {

            int next2 = ugly[p2] * 2;
            int next3 = ugly[p3] * 3;
            int next5 = ugly[p5] * 5;
            int num = Math.min(next2, Math.min(next3, next5));
            ugly[i] = num;
            if (num ==next2) p2++;
            if (num ==next3) p3++;
            if (num ==next5) p5++;
        }

        return ugly[index - 1];
    }
}
