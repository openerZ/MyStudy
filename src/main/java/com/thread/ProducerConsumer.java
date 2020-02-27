package com.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 使用BlockingQueue实现生产者消费者
 */
public class ProducerConsumer {

    private static BlockingQueue<String> bq = new ArrayBlockingQueue(5);

    private static class Producer extends Thread{

        @Override
        public void run() {
            try {
                //如果队列为满时会阻塞，直到队列有空闲
                bq.put("producet");
                System.out.println("producet");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Consumer extends Thread{

        @Override
        public void run() {
            try {
                //如果队列为空时会阻塞，直到队列有数据
                bq.take();
                System.out.println("consume..");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Producer producer = new Producer();
            producer.start();

        }

        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }

        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer();
            producer.start();

        }

    }
}
