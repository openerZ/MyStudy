package com.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 */
public class O14 {

    /**
     * 时间和空间复杂度都是O(N)
     *
     * @param array
     */
    public void reOrderArray(int [] array) {
        int length = array.length;
        List<Integer> l1 = new ArrayList<>();
        int k=0;
        for (int i=0;i<length;i++){
            if (array[i]%2==0){
                l1.add(array[i]); //偶数顺序放入list
            }else {
               array[k++] = array[i]; //如果是奇数顺序放入原数组
            }
        }
        //将list中的偶数复制到原数组中
        for (Integer integer : l1) {
            array[k++] = integer;
        }

    }

    /**
     *使用冒泡思想，每次都当前偶数上浮到当前最右边。时间复杂度 O(N2)，空间复杂度 O(1)，时间换空间。
     *
     * @param array
     */
    public void reOrderArray1(int [] array) {
        int length = array.length;
        int k=0;
        for (int i=length-1;i>0;i--){
            for (int j = 0;j<i;j++){
                if (array[j]%2==0 && array[j+1]%2!=0){
                    int temp=array[j];
                    array[j] = array[j+1];
                    array[j+1]=temp;
                }
            }

        }
    }
}
