package com.offer;

/**
 * 题目描述
 * 有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？
 * (注：小朋友的编号是从0到n-1)
 * <p>
 * 如果没有小朋友，请返回-1
 */
public class O52 {


    public int LastRemaining_Solution(int n, int m) {
        if (n == 1 || m <= 0) return -1;
        //记录被删除的数位置，下标被删除就将值赋值为-1
        int[] arr = new int[n];

        int k = n;
        int index = -1, t = -1;
        while (k > 0) {
            if (index == n - 1) {
                index = 0;
            } else {
                index++;
            }
            if (arr[index]==-1){ //表示已经被删除了
                continue;
            }
            t++;
            if (t == m-1) {
                k--;
                t=-1;
                arr[index]=-1; //删除
            }
        }
        return index;
    }

    public int LastRemaining_Solution1(int n, int m) {
        if (n == 0)     /* 特殊输入的处理 */
            return -1;
        if (n == 1)     /* 递归返回条件 */
            return 0;
        return (LastRemaining_Solution1(n - 1, m) + m) % n;
    }
}
