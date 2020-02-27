package com.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronized 关键字测试
 */
public class SynchronizedExample {

    /**
     * 同步一个普通方法
     * 默认锁对象是-实例对象
     * 同一个对象在多个线程同时调用此方法会发生互斥同步
     * 不同的对象在多个线程同时调用此方法不会发生同步
     */
    public synchronized void fun() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    /**
     * 同步代码块不同于同步方法将synchronized关键字声明在方法名中
     * 而是可以自行选择方法体中的代码块进行同步
     * <p>
     * 并且可以自行选择锁对象
     * 可以使用this锁也就是当前对象
     * 也可以使用Class锁
     */
    public void funblack() throws InterruptedException {
        System.out.println("你好");

        Thread.sleep(1000);
        synchronized (this) {  //只用同步代码块里的才会同步
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }

    }


    /**
     * 静态同步方法：
     * 因为静态方法不属于实例对象，而属于类，
     * 所以静态同步方法的锁对象是——当前类的Class对象
     * 意味着：不仅多个线程对同一个对象调用此方法会发生互斥同步
     * 同一个类的不同的对象在不同的线程中调用此方法也会发生互斥同步
     * 因为一个类只有一个Class对象
     */
    public static synchronized void fun1() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    /**
     * ReentrantLock jdk提供的加锁类
     * 一般情况下雨try{}finally{}配合使用要保证正确的加锁和释放锁
     */
    Lock lock = new ReentrantLock();


    public void funLock() {

        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        SynchronizedExample se = new SynchronizedExample();
        SynchronizedExample se1 = new SynchronizedExample();
        SynchronizedExample se2 = new SynchronizedExample();

        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(() -> se.funLock());
        pool.execute(() -> se1.funLock());
        pool.execute(() -> se2.funLock());


        pool.shutdown();

    }
}
