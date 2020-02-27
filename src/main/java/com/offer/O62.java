package com.offer;

import java.util.*;

/**
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}
 */
public class O62 {


    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || num.length < size || size <= 0) return list;
        int length = num.length;
        int max = num[0];
        int maxIndex = 0;
        for (int i = 0; i < size; i++) {
            if (num[i] > max) {
                max = num[i];
                maxIndex = i;
            }
        }
        int begin = 0;
        int end = size - 1;
        while (end < length) {
            if (maxIndex < begin) {
                max = num[begin];
                maxIndex = begin;
                for (int i = begin; i <= end; i++) {
                    if (num[i] > max) {
                        max = num[i];
                        maxIndex = i;
                    }
                }
            } else if (max < num[end]) {
                max = num[end];
                maxIndex = end;
            }
            list.add(max);
            begin++;
            end++;
        }
        return list;
    }

    /**
     * 使用最大堆
     * 时间复杂度；O(nLongN);
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows1(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || num.length < size || size <= 0) return list;
        int length = num.length;
        //使用size大小的最大堆，会自动维护最大值以及容量
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(size, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < size; i++) {
            maxHeap.offer(num[i]);
        }
        list.add(maxHeap.peek());
        for (int i = 0, j = i + size; i < length && j < length; i++, j++) {
            maxHeap.remove(num[i]); //剔除上边界
            maxHeap.offer(num[j]);  //加入下边界
            list.add(maxHeap.peek());
        }

        return list;

    }


    /**
     * 使用双端队列
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || num.length < size || size <= 0) return list;
        int length = num.length;



        //双端队列 ，维持链表头为当前窗口的最大值得下标，存的是下标值
        LinkedList<Integer> maxQ = new LinkedList<>();

        for (int i = 0; i < num.length; i++) {
            //如果链表的队尾值小于当前下边界的值，就将其弹出
            while (maxQ.isEmpty() && num[maxQ.peek()]<num[i]){
                maxQ.pollLast();
            }
            //加到链表尾部
            maxQ.addLast(i);

            //判断最大值下标是否已经过期
            if (maxQ.peekFirst()==i-size){
                maxQ.pollFirst();
            }

            //向容器加入当前窗口的最大值
            if (i>=size-1){
                list.add(num[maxQ.peekFirst()]);
            }
        }
        return list;
       /* //双端队列，用来记录每个窗口的最大值下标，保持队列头为当亲窗口最大值下标
        LinkedList<Integer> qmax = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            //如果队列的队尾值小于当前下边界的值，就将器弹出
            while (!qmax.isEmpty() && num[qmax.peekLast()] < num[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            //判断队首元素是否过期
            if (qmax.peekFirst() == i - size) {
                qmax.pollFirst();
            }
            //向result列表中加入元素
            if (i >= size - 1) {
                list.add(num[qmax.peekFirst()]);
            }
        }
        return list;*/
    }
}
