package com.offer;

import java.util.*;

/**
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class O61 {

    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> medin = null;

    public void Insert1(Integer num) {
        list.add(num);
    }

    public Double GetMedian1() {
        medin = new ArrayList<>(list);
        int[] array= new int[medin.size()];
        int index=0;
        for (Integer integer : medin) {
            array[index++] = integer;
        }
        Arrays.sort(array);
        int length = array.length;
        if ((length & 1) == 0) {
            return (array[length/2]+array[length/2-1])/2.0;
        }else {
            return array[length/2]/1.0;
        }
    }

    //最小堆,最小堆全比最大堆大
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //最大堆，最大堆的全比最小堆小
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    private int count=0;
    public void Insert(Integer num) {
        count++;
        if ((count&1)==0){ //偶数放入最小堆
            if (!maxHeap.isEmpty()&&num<maxHeap.peek()){
                //如果num比最大堆的最大小，要把他放入最大堆，然后把最大堆的最大弹出放入最小堆
                maxHeap.offer(num);
                num= maxHeap.poll();
            }
            minHeap.offer(num);
        }else { //奇数放入最大堆
            if (!minHeap.isEmpty()&&num>minHeap.peek()){
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if ((count&1)==0){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }else {
            return maxHeap.peek()/1.0;
        }
    }
}
