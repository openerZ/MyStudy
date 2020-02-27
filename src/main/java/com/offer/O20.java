package com.offer;

import java.util.Iterator;
import java.util.Stack;

/**
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class O20 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
       stack.push(node);
       if (minStack.isEmpty() || minStack.peek()>=node){
           minStack.push(node);
       }
    }

    public void pop() {
        Integer pop = stack.pop();
        if (pop==minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
      return stack.peek();

    }

    /**
     * 栈中所含最小元素
     * @return
     */
    public int min() {
       return minStack.peek();
    }
}
