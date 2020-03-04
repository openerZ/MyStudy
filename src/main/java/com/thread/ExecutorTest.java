package com.thread;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池：
 *      CachedThreadPool:一个任务创建一个线程
 *      FixedThreadPool: 所有任务只能使用固定大小的线程
 *      SingleThreadExecutor: 只有一个线程
 */
public class ExecutorTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService = Executors.newFixedThreadPool(5);
        executorService =Executors.newSingleThreadExecutor();
        executorService =Executors.newScheduledThreadPool(5);
        for (int i=0;i<10;i++){
            executorService.execute(() ->{
                System.out.println("12");
            });
        }
        executorService.shutdown();
    }
}
