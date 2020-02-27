package com.mytest;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Test131 {

    @Test
    public void test01() {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(5);
        queue.poll();

        LinkedList<Integer> list = new LinkedList<>();
        list.offer(5);
        list.pop();
    }

    @Test
    public void threadLocalTest() {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        new Thread(() -> {
            threadLocal.set(10);
            threadLocal.remove();
        }).start();

        new Thread(() -> {
            threadLocal.set(12);
            System.out.println("aa"+threadLocal.get());
        }).start();
    }
}
