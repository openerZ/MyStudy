package com.thread;

public class InterruptExample {

    private static class MyThread extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Thread Run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class MyThread2 extends Thread{
        @Override
        public void run() {
            while (!interrupted()){

            }
            System.out.println("Thread end");
        }
    }

    public static void main(String[] args) {
        /*MyThread myThread = new MyThread();
        myThread.start();*/
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        //强制线程中断
        myThread2.interrupt();
    }
}
