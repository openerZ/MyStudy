package com.offer;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”
 */
public class O44 {

    /**
     * 利用循环规则
     *
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) return "";
        //接借助额外的N空间
        char[] chars = str.toCharArray();
        int length = chars.length;
        //左移取模
        int t = n % length;
        for (int i = 0; i < length; i++) {
            int index = (length + i - t) % length;
            chars[index] = str.charAt(i);

        }
        return String.valueOf(chars);
    }


    /**
     * YX = (XTYT)T
     * 1.先判断字符串是否符合要求
     * 2.对移动的距离取模 n = n%length
     * 3.把数组分成两部分，0-(n-1),n-(str.length-1)
     * 4.对前一部分进行逆序，对后一部分进行逆序，然后在对整体进行逆序
     */
    public String LeftRotateString1(String str, int n) {
        if (str == null || str.length() == 0) return "";
        if (n<=0) return str;
        char[] chars = str.toCharArray();
        n = n % chars.length;
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length-1);
        reverse(chars, 0, chars.length - 1);
        return String.valueOf(chars);

    }

    /**
     *
     * 逆序操作
     * @param chars
     * @param start
     * @param end
     */
    private void reverse(char[] chars, int start, int end) {
        while (start <= end) {
            swap(chars, start++, end--);
        }
    }


    private void swap(char[] chars, int start, int end) {
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
    }

}
