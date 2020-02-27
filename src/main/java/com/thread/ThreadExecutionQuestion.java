package com.thread;

import org.junit.Test;

public class ThreadExecutionQuestion {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "T1");

        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "T2");
        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "T3");

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();
    }

    @Test
    public void test() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "T1");

        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "T2");
        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "T3");

        t1.start();
        while (t1.isAlive()){  //自旋 spin
            wait(0);
        }
        t2.start();
        while (t2.isAlive()){
            wait(0);
        }
        t3.start();
        while (t3.isAlive()){
            wait(0);
        }
    }
}
