package com.thread;

public class RunnableTest implements Runnable{

    private static int taskCount=0;
    private final int id = taskCount++;


    public RunnableTest() {
        System.out.println("开始启动"+getId());
    }

    public int getId() {
        return id;
    }

    @Override
    public void run() {
        System.out.println("运行线程"+getId());
        Thread.yield();
        System.out.println("线程运行完毕"+getId());
    }

    public static void main(String[] args) {
        for (int i=0;i<3;i++){
            new Thread(new RunnableTest()).start();
        }
    }
}
