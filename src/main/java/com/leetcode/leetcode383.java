package com.leetcode;

import java.util.HashMap;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 *
 * 注意：
 *
 * 你可以假设两个字符串均只含有小写字母。
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 */
public class leetcode383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < ransomNote.length(); i++) {
            Integer orDefault = map.getOrDefault(ransomNote.charAt(i), 0);
            map.put(ransomNote.charAt(i),orDefault+1);
        }

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (map.containsKey(c)){
                Integer integer = map.get(c);
                if (integer==1){
                    map.remove(c);
                }else {
                    map.put(c,integer-1);
                }
            }
        }

        return map.isEmpty();

    }


    public boolean canConstruct1(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            int i1 = magazine.charAt(i) - 97;
            arr[i1]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int i1 = ransomNote.charAt(i) - 97;
            if (arr[i1]==0){
                return false;
            }else {
                arr[i1]--;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        int a='y';
        System.out.println(a);


    }
}
