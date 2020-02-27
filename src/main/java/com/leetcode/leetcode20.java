package com.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。

 */
public class leetcode20 {

    public boolean isValid(String s) {
        if (s==null ||s.equals("")) return true;

        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)){
                stack.push(c);
            }else {
                if (!stack.isEmpty()&&map.get(stack.peek())==c){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
