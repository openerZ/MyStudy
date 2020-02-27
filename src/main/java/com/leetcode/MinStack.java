package com.leetcode;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()){
            minStack.push(x);
        }else {
            if (x<=minStack.peek()){
                minStack.push(x);
            }
        }
    }

    public void pop() {
        Integer pop = stack.pop();
        if (!minStack.isEmpty() && pop <= minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }




}
