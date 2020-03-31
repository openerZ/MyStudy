package com.leetcode;

import org.omg.CORBA.MARSHAL;

/**
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 *
 * 1 是丑数。
 * n 不超过1690。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode264 {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0]=1;
        int i2 = 0,i3=0,i5=0;
        for (int i = 1; i <n ; i++) {
            int temp = Math.min(res[i2]*2,Math.min(res[i3]*3,res[i5]*5));
            res[i] = temp;
            if (temp==res[i2]*2){
                i2++;
            }
            if (temp ==res[i3]*3){
                i3++;
            }
            if (temp==res[i5]*5){
                i5++;
            }
        }
        return res[n-1];
    }
}
