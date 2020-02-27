package com.mynote;

import org.junit.Test;

import java.util.*;

/**
 * 题目描述：
 * 为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。牛牛选工作的标准是在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作。
 * 在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴们。
 * 牛牛的小伙伴太多了，于是他只好把这个任务交给了你。
 * <p>
 * 输入描述：
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
 * 接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
 * 接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
 * 保证不存在两项工作的报酬相同。
 * <p>
 * 输出描述：
 * 对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。
 * <p>
 * 示例1：
 * <p>
 * 输入：
 * <p>
 * 3 3
 * 1 100
 * 10 1000
 * 1000000000 1001
 * 9 10 1000000000
 * <p>
 * 输出：
 * <p>
 * 100
 * 1000
 * 1001
 * <p>
 * 时间复杂度是O(NlogN)。空间复杂度是O(N)。
 * <p>
 * 运行时间：2128ms。占用内存：78688k。
 */
public class FindWork {

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt(); //工作数量
//        int m = input.nextInt(); //小伙伴数量
//        int t1, t2;
//        //保存不超过该难度的最大报酬
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int[] a = new int[n + m];
//        int[] b = new int[m];
//        for (int i = 0; i < n; i++) {
//            t1 = input.nextInt(); //工作难度
//            t2 = input.nextInt();  //工作报酬
//            a[i] = t1;
//            map.put(t1, t2);
//        }
//
//        for (int i = 0; i < m; i++) {
//            t1 = input.nextInt(); //工作能力
//            a[n + i] = t1;
//            b[i] = t1;
//            if (!map.containsKey(t1)) {
//                map.put(t1, -1);
//            }
//        }
//        Arrays.sort(a);
//
//        int max = 0;
//        for (int i = 0; i < m + n; i++) {
//            max = Math.max(max, map.get(a[i]));
//            map.put(a[i], max);
//        }
//        for (int i = 0; i < m; i++) {
//            System.out.println(map.get(b[i]));
//        }
//
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        long[] a = new long[n];
//        for (int i = 0; i < n; i++) {
//            int z = sc.nextInt();
//            a[i] = z;
//        }
//
//        Arrays.sort(a);
//        long max,seconMax,threadMax,min,secondMin;
//        max=a[n-1];
//        seconMax=a[n-2];
//        threadMax=a[n-3];
//
//        min=a[0];
//        secondMin=a[1];
//
//        System.out.println(Math.max(max*seconMax*threadMax,min*secondMin*max));
//
//    }


    /**
     * 题目描述
     * 有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型。
     * 输入描述:
     * 空格分隔的两个字符串，代表输入的两个大整数
     * 输出描述:
     * 输入的乘积，用字符串表示
     * 示例1
     * 输入
     * 复制
     * 72106547548473106236 982161082972751393
     * 输出
     * 复制
     * 70820244829634538040848656466105986748
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num1 = in.nextBigDecimal().toString();
        String num2 = in.nextBigDecimal().toString();
        int[] ret = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';

                ret[i + j] += (ret[i + j + 1] + x * y) / 10;
                ret[i + j + 1] = (ret[i + j + 1] + x * y) % 10;

            }
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < ret.length; i++) {
            if (i == 0 && ret[i] == 0) continue;
            s.append(ret[i]);
        }
        System.out.println(s.toString());

    }

    public String mul(String num1, String num2) {
        int[] nums1 = new int[num1.length()], nums2 = new int[num2.length()], res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            nums1[i] = num1.charAt(num1.length() - 1 - i) - '0';
        }
        for (int i = num2.length() - 1; i >= 0; i--) {
            nums2[i] = num2.charAt(num2.length() - 1 - i) - '0';
        }
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                res[i + j] += nums1[i] * nums2[j];
            }
        }
        //进位和留位
        for (int i = 1; i < res.length; i++) {
            //进位
            res[i] += res[i - 1] / 10;
            //留位
            res[i - 1] = res[i - 1] % 10;
        }
        StringBuffer buffer = new StringBuffer();
        boolean start = false;
        for (int i = res.length - 1; i >= 0; i--) {
            if (!start && res[i] == 0) continue;
            else start = true;
            buffer.append(res[i]);
        }
        return buffer.toString();
    }

    public void ttt(String num1, String num2) {


        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        // even 99 * 99 is < 10000, so maximaly 4 digits
        int[] d = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                d[i + j] += a * b;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d.length; i++) {
            int digit = d[i] % 10;  //数位
            int carry = d[i] / 10;  //进位
            sb.insert(0, digit);
            if (i < d.length - 1)
                d[i + 1] += carry;
        }
        //trim starting zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
    }

    /**
     * 题目描述
     * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
     * 输入描述:
     * 输入共2行，第一行包括一个整数n，表示数组长度
     * 第二行为n个以空格隔开的整数，分别为A1,A2, … ,An
     * 输出描述:
     * 满足条件的最大乘积
     * 示例1
     * 输入
     * 复制
     * 4
     * 3 4 1 2
     * 输出
     * 复制
     * 24
     */
    @Test
    public void test() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int fs = 0;
        int zs = 0;
        for (int i = 0; i < n; i++) {
            int z = sc.nextInt();
            if (z > 0) {
                zs++;
            } else {
                fs++;
            }
            a[i] = z;
        }

        Arrays.sort(a);

        /**
         * 把0作为负数
         * 3正以上 ：最大的3个正数相乘或两个最小负数与最大正数
         *
         * 3正以下：
         *      1正：最小的两个负数和正数
         *      2正：
         *          两个负数以上： 最小的两个负数与最大的正数
         *          两个负数以下：两正与最小负数
         *
         * 全负：
         *      最大的三个负数相乘
         *
         */
        if (zs > 2) {
            System.out.println(Math.max(a[n - 1] * a[n - 2] * a[n - 3], a[0] * a[1] * a[n - 1]));
        } else if (zs > 0 && zs < 3) {
            if (zs == 1) {
                System.out.println(a[0] * a[1] * a[n - 1]);
            } else if (zs == 2) {
                if (fs > 1) {
                    System.out.println(a[0] * a[1] * a[n - 1]);
                } else {
                    System.out.println(a[n - 1] * a[n - 2] * a[fs - 1]);
                }
            }
        } else {
            System.out.println(a[fs - 1] * a[fs - 2] * a[fs - 3]);
        }
    }


}
