package com.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch:
 *用来控制一个线程等待多个线程，维护一个计数器，每次调用countDown()方法会让计数器的值减1，减到0的时候，那些因为
 * 调用await()方法的而在等待的线程就会被唤起
 * 只有将计数器的值置为0才会释放锁资源
 */
public class CountdownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 10;

        CountDownLatch cdl = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < totalThread; i++) {
            executorService.execute(()->{
                System.out.println("run..");
                cdl.countDown();
            });
        }

        cdl.await(); //主线程被挂起
        System.out.println("end");
        System.out.println("end");
        System.out.println("end");
        System.out.println("end");
        executorService.shutdown();

    }
}
