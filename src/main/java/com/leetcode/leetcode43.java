package com.leetcode;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class leetcode43 {

    public String multiply(String num1, String num2) {
        if (num1.equals("0")||num2.equals("0")) return "0";

        int[] ans = new int[num1.length()+num2.length()];

        for (int i = num2.length()-1; i >=0; i--) {
            int a = num2.charAt(i) - '0';
            for (int j = num1.length()-1; j >=0; j--) {
                int b = num1.charAt(j) - '0';
                int temp = ans[i+j+1]+a*b;
                ans[i+j+1]=temp%10;
                ans[i+j]+=temp/10;
            }
        }

        int k=0;
        for (;  k<ans.length; k++) {
            if (ans[k]!=0){
                break;
            }
        }
        StringBuilder s = new StringBuilder();

        for (int i = k; i<ans.length ; i++) {
            s.append(ans[i]);
        }
        return s.toString();


    }

    public static void main(String[] args) {

        leetcode43 a = new leetcode43();

        System.out.println(a.multiply("12","25"));
    }
}
