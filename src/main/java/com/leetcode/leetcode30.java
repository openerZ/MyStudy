package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 */
public class leetcode30 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wNum = words.length; //单词个数
        if (wNum == 0) {
            return res;
        }
        //单词的长度
        int wL = words[0].length();
        HashMap<String, Integer> m1 = new HashMap<>();
        for (String word : words) {
            if (m1.containsKey(word)) {
                m1.put(word, m1.get(word) + 1);
            } else {
                m1.put(word, 1);
            }
        }
        for (int i = 0; i < s.length() - wNum * wL + 1; i++) {
            HashMap<String, Integer> m2 = new HashMap<>();
            int index = i;
            int num = 0;
            while (num < wNum && index < s.length()) {
                String sb = s.substring(index, index + wL);
                index += wL;
                if (m1.containsKey(sb)) {
                    if (m2.containsKey(sb)) {
                        m2.put(sb, m2.get(sb) + 1);
                    } else {
                        m2.put(sb, 1);
                    }
                    if (m1.get(sb) < m2.get(sb)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            if (num == wNum) {
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        //单词数量
        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }
        //单词的单个长度
        int wordLen = words[0].length();
        HashMap<String, Integer> allWords = new HashMap<>();
        for (String w : words) {
            int value = allWords.getOrDefault(w, 0);
            allWords.put(w, value + 1);
        }
        //将所有移动分成 wordLen 类情况
        for (int j = 0; j < wordLen; j++) {
            HashMap<String, Integer> hasWords = new HashMap<>();
            int num = 0; //记录当前 HashMap2（这里的 hasWords 变量）中有多少个单词
            //每次移动一个单词长度
            for (int i = j; i < s.length() - wordNum * wordLen + 1; i = i + wordLen) {
                boolean hasRemoved = false; //防止情况三移除后，情况一继续移除
                while (num < wordNum) {
                    String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                    if (allWords.containsKey(word)) {
                        int value = hasWords.getOrDefault(word, 0);
                        hasWords.put(word, value + 1);
                        //出现情况三，遇到了符合的单词，但是次数超了
                        if (hasWords.get(word) > allWords.get(word)) {
                            // hasWords.put(word, value);
                            hasRemoved = true;
                            int removeNum = 0;
                            //一直移除单词，直到次数符合了
                            while (hasWords.get(word) > allWords.get(word)) {
                                String firstWord = s.substring(i + removeNum * wordLen, i + (removeNum + 1) * wordLen);
                                int v = hasWords.get(firstWord);
                                hasWords.put(firstWord, v - 1);
                                removeNum++;
                            }
                            num = num - removeNum + 1; //加 1 是因为我们把当前单词加入到了 HashMap 2 中
                            i = i + (removeNum - 1) * wordLen; //这里依旧是考虑到了最外层的 for 循环，看情况二的解释
                            break;
                        }
                        //出现情况二，遇到了不匹配的单词，直接将 i 移动到该单词的后边（但其实这里
                        //只是移动到了出现问题单词的地方，因为最外层有 for 循环， i 还会移动一个单词
                        //然后刚好就移动到了单词后边）
                    } else {
                        hasWords.clear();
                        i = i + num * wordLen;
                        num = 0;
                        break;
                    }
                    num++;
                }
                if (num == wordNum) {
                    res.add(i);

                }
                //出现情况一，子串完全匹配，我们将上一个子串的第一个单词从 HashMap2 中移除
                if (num > 0 && !hasRemoved) {
                    String firstWord = s.substring(i, i + wordLen);
                    int v = hasWords.get(firstWord);
                    hasWords.put(firstWord, v - 1);
                    num = num - 1;
                }

            }

        }
        return res;
    }
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            int left = 0, right = 0, len = 0;
            // 所有单词数
            int size = words.length;
            List<Integer> res = new ArrayList<>(10);
            // 如果目标数组为空，则返回一个空集合
            if (words.length == 0){
                return res;
            }else{
                // 单词长度
                len = words[0].length();
            }
            // 定义两个map集合，一个存目标单词，一个存滑动窗口
            Map<String, Integer> needs = new HashMap<>(5);
            Map<String, Integer> windows = new HashMap<>(10);
            // 初始化目标集合，将单词与出现的次数对应存入map集合中
            for (int i = 0; i < words.length; i++){
                // 如果单词存在集合中，则返回出现的次数，否则返回0
                int count = needs.getOrDefault(words[i], 0);
                // 存入map中，次数+1
                needs.put(words[i], count + 1);
            }
            // 单词的匹配数量（包括单词和出现次数）
            int match = 0;
            // 由于字符串不一定是单词长度的倍数，所以需要遍历一个单词长度的所有情况
            for (int i = 0; i < len; i ++){
                // 初始化左右指针开始处为i，match初始化为0
                right = left = i;
                match = 0;
                // 右指针最多到字符串的最后一个单词开始位置
                while(right <= s.length() - len){
                    // 向右滑动，存入单词和出现的次数
                    String s1 = s.substring(right, right + len);
                    // 以单词长度为步长移动右指针
                    right += len;
                    int count = windows.getOrDefault(s1, 0);
                    windows.put(s1, count + 1);
                    // 如果单词和出现的次数与目标一致，则匹配+1
                    if (needs.containsKey(s1) && windows.get(s1).intValue() == needs.get(s1).intValue()){
                        match ++;
                    }
                    // 当匹配数等于目标集合的大小（说明已经覆盖了目标集合）
                    while (left < right && match == needs.size()) {
                        // right - left / len求出窗口中单词数，如果等于目标单词数，则匹配成功，将左指针位置加入list
                        if ((right - left) / len == size) {
                            res.add(left);
                            break;
                        }
                        // 左指针右移，类似右指针方法
                        String s2 = s.substring(left, left + len);
                        left += len;
                        windows.put(s2, windows.get(s2) - 1);
                        if (needs.containsKey(s2) && windows.get(s2).intValue() < needs.get(s2).intValue()){
                            match --;
                        }
                    }
                }
                // 清空窗口，进行下一次遍历
                windows.clear();
            }
            return res;
        }
    }


}
