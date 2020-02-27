package com.offer;

/**
 * 题目描述
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
 * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，
 * 这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class O45 {

    public String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        //先对每个单词进行翻转
        int n = 0;
        for (int i = 0; i <= chars.length; i++) {
            //当i为length时是翻转最后一个一个单词
            if (i == chars.length || chars[i] == ' ') {
                if (i > n) { //防止第一个就是空格
                    reverse(chars, n, i - 1);
                }
                n = i + 1;
            }
        }
        //在对整个翻转
        reverse(chars, 0, chars.length - 1);
        return String.valueOf(chars);
    }

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
