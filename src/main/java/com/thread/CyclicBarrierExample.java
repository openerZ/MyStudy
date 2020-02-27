package com.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Cyclibarrier（循环屏障）:用来控制多个线程互相等待，只有当多个线程都到达时
 * ，这些线程才会继续执行
 * 维护一个计数器，线程调用一次await()计数器减1，并进行等待，当计数器到达0时
 * 所有调用await()的线程而等待的线程继续执行
 *
 */
public class CyclicBarrierExample {

    public static void main(String[] args) {
        final int totalThread = 10;
        CyclicBarrier cb = new CyclicBarrier(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < totalThread; i++) {
            executorService.execute(()->{
                System.out.println("Before..");
                try {
                    cb.await(); //当前线程等待，直到
                } catch (InterruptedException e) {
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("After..");
            });

        }
        executorService.shutdown();

    }
}
