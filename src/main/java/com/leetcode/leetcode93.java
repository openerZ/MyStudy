package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class leetcode93 {

    List<String> list = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return list;
        HS(s, 0, new StringBuilder(), 0);
        return list;
    }

    private void HS(String s, int index, StringBuilder str, int k) {
        if (k==3 && index+3<s.length()) {
            return;
        }
        if (index == s.length() && k == 4) {
            list.add(str.toString());
            return;
        }


        for (int j = index + 1; j < index + 4 && j <= s.length(); j++) {
            if (s.charAt(index)=='0' && j>index+1) return;
            String ip = s.substring(index, j);
            if (Integer.valueOf(ip) <= 255) {
                if (k<3){
                    HS(s, j, new StringBuilder(str).append(ip).append("."), k + 1);
                }else {
                    HS(s, j, new StringBuilder(str).append(ip), k + 1);
                }
            }else {
                return;
            }
        }
    }

    public static void main(String[] args) {

        leetcode93 a = new leetcode93();

        System.out.println(a.restoreIpAddresses("25525511135"));
    }
}
