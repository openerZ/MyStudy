package com.offer;

import java.util.Stack;

/**
 *题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 */
public class O6 {

    Stack<Integer> stack1 = new Stack<Integer>(); //A
    Stack<Integer> stack2 = new Stack<Integer>();  //B

    /**
     * 每次将一个stack复制到另一个stack
     *
     * @param node
     */
    public void push(int node) {
        if (stack1.isEmpty() && stack2.isEmpty()){
            stack1.push(node);
            return;
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack2.push(node);
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }
}
