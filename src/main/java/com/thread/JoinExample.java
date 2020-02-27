package com.thread;

/**
 *在线程中调用另一个线程的join()方法，会将当前线程挂起（会记录挂起的位置），当join线程执行完毕时
 * 会重新在挂起的位置继续执行
 *
 */
public class JoinExample {

    private class A extends Thread{

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是A");
        }
    }

    private class B extends Thread{
        private A a;

        public B(A a) {
            this.a = a;
        }

        public B() {

        }

        @Override
        public void run() {
            try {
                System.out.println("我是BBBB我要开始执行了");
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("我是B");
        }
    }

    public void test(){
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }

    public static void main(String[] args) {
        JoinExample joinExample = new JoinExample();
        joinExample.test();
    }
}
