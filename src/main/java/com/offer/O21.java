package com.offer;


import java.util.Stack;

/**
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class O21 {

    /**
     *借助一个辅助栈
     *
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {

        Stack<Integer> stack = new Stack<>();
        int length = pushA.length;
        int k=0;
        int i=0;
        while (k<length){
            if (i<length){
                stack.push(pushA[i++]);
                if (stack.peek()==popA[k]){
                    stack.pop();
                    k++;
                }
            }else { //pushA数组中的数全部压入过栈，此时的出栈顺序必须与剩下的popA顺序相同
                if (stack.peek()==popA[k]){
                    stack.pop();
                    k++;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isPopOrder(int[] pushA, int[] popA){
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for (int i = 0; i < popA.length; i++) {
            stack.push(pushA[i]);
            while (j < popA.length && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }

        }
        return stack.isEmpty();
    }
}
