package com.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample extends RecursiveTask<Integer> {
    private final int threshold=5;
    private int first;
    private int last;

    ForkJoinExample(int first,int last){
        this.first=first;
        this.last=last;
    }


    @Override
    protected Integer compute() {
        int result=0;

        if (last-first<threshold){

            for (int i=first;i<=last;i++){
                result+=i;
            }
        }else {
            //拆分成小任务
            int mid= first+(last-first)/2;
            ForkJoinExample f1 = new ForkJoinExample(first, mid);
            ForkJoinExample f2 = new ForkJoinExample(mid+1, last);
            f1.fork();
            f2.fork();
            result = f1.join()+f2.join();
        }

        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinExample forkJoinExample = new ForkJoinExample(1, 1000);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(forkJoinExample);
        System.out.println(submit.join());
        System.out.println(submit.get());

    }
}
