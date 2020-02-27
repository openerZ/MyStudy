package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class leetcode17 {

    /**
     * 采用递归
     */
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals("")) return ans;
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mnp");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        char[] chars = digits.toCharArray();
        dg(chars,0,new StringBuilder(),map);
        return ans;

    }

    private void dg(char[] chars ,int k,StringBuilder str,HashMap<Integer, String> map){
        if (k>=chars.length) return;

        int ap = chars[k] - '0';
        if (k==chars.length-1){
            if (map.containsKey(ap)){
                for (char c : map.get(ap).toCharArray()) {
                    ans.add(new StringBuilder(str).append(c).toString());
                }
            }
            return;
        }
        if (map.containsKey(ap)){
            for (char c : map.get(ap).toCharArray()) {
                dg(chars,k+1,new StringBuilder(str).append(c),map);
            }
        }
    }

    public static void main(String[] args) {
        char a='a';

        System.out.println(new StringBuilder().append(a).toString());

    }
}
