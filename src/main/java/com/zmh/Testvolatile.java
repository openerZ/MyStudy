package com.zmh;

import java.util.concurrent.atomic.AtomicInteger;

public class Testvolatile {

    //    public static volatile int i=0;
    public static AtomicInteger i = new AtomicInteger(0);

    public static synchronized void increase() {

//        i++;
        i.incrementAndGet();
    }


    public static void main(String[] args) {
        Thread[] th = new Thread[20];
        for (int a = 0; a < 20; a++) {
            th[a] = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });

            th[a].start();
        }

        /*while (Thread.activeCount() > 1)
            Thread.yield();*/
        System.out.println(Testvolatile.i);
    }
}
