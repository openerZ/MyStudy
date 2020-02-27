package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//1.实现Callable接口
public class MyCallable implements Callable<Integer> {

    //2.重写call 方法，会有返回值
    @Override
    public Integer call() throws Exception {
        for (int i=0;i<10;i++){
            System.out.println(i);
        }
        return 123;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyCallable myCallable = new MyCallable();
        //通过FutureTask包装
        FutureTask<Integer> ft = new FutureTask<Integer>(myCallable);
        //FutureTask同样实现了Runnable,所以使用Thread启动
        Thread thread = new Thread(ft);
        thread.start();
        //可以使用FutureTask的get方法获取Call方法的返回值
        System.out.println(ft.get());

    }
}


