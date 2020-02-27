package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * wait()、notify()、notifyAll()
 * 线程之间的通信
 */
public class WaitNotifyExample {


    public synchronized void before() {
        System.out.println("before");
        notifyAll();
    }

    public synchronized void after() {
        try {
            System.out.println("开始");
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void before1() {
        lock.lock();
        try {
            System.out.println("before");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void after1() {
        lock.lock();
        try {
            System.out.println("开始启动");
            condition.await();
            Thread.sleep(1000);
            System.out.println("after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        WaitNotifyExample wn = new WaitNotifyExample();

        ExecutorService es = Executors.newCachedThreadPool();
       /* es.execute(() -> wn.after());
        es.execute(() -> wn.before());*/
        es.execute(() -> wn.after1());
        es.execute(() -> wn.before1());
        es.shutdown();
    }
}
