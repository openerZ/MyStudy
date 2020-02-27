package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore:可以控制对互斥资源的访问线程数
 * 限定了同时有几个线程可以访问互斥资源
 * 相当于发放许可证，只有有许可证的线程才能访问资源，release()访问完资源会释放许可证
 *
 */
public class SemaphoreExample {

    public static void main(String[] args) {
        //许可证
        final int count=3;
        final int totalRequest=10;

        Semaphore sp = new Semaphore(count);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < totalRequest; i++) {
            executorService.execute(()->{
                try {
                    //尝试获取许可证，会一直阻塞，直到这个信号量有空闲的许可证，然后获取
                    sp.acquire();
                    System.out.println(sp.availablePermits()+" ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    sp.release();
                }

            });

        }
        executorService.shutdown();

    }
}
