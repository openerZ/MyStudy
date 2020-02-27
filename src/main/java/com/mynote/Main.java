package com.mynote;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    }

    /**
     * 题目描述
     * 小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
     *
     * 并且小Q对于能否被3整除这个性质很感兴趣。
     *
     * 小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。
     *
     * 输入描述:
     * 输入包括两个整数l和r(1 <= l <= r <= 1e9), 表示要求解的区间两端。
     * 输出描述:
     * 输出一个整数, 表示区间内能被3整除的数字个数。
     * 示例1
     * 输入
     * 复制
     * 2 5
     * 输出
     * 复制
     * 3
     * 说明
     * 12, 123, 1234, 12345...
     * 其中12, 123, 12345能被3整除。
     *
     *
     * 写出来当插入i以后的规律：
     * i = 1 ----> 1
     * i = 2 ----> 0
     * i = 3 ----> 0
     * i = 4 ----> 1
     * i = 5 ----> 0
     * i = 6 ----> 0
     * i = 7 ----> 1
     * ………………
     * 发现在区间[1,x]之间共计有 fuck(x) = (x+2)/3 个1，剩下的都满足要求
     * 那么在区间[l, r]上的 r-l+1个 数字中，必须抠掉 fuck(r) - fuck(l-1) 个不满足要求的数字。
     */
    public static void findThree(){
        Scanner sc = new Scanner(System.in);
        long low = sc.nextLong();
        long high = sc.nextLong();

        System.out.println(high - low+1 -(high+2)/3+(low-1+2)/3);

    }
}
