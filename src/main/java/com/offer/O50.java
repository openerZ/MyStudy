package com.offer;

/**
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class O50 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length == 0) return false;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            int number = numbers[i];
            arr[number]++;
            if (arr[number] > 1) {
                duplication[0] = number;
                return true;
            }
        }
        return false;
    }

    /**
     * 不借助额外空间，因为长度为n的数组的值范围也是0-（n-1）
     * 所以使用交换使下标对应上值
     * 如果有重复的那抹交换时就会发现值下标上的值已经存在，就是重复
     */
    public static boolean duplicate1(int numbers[], int length, int[] duplication) {
        if (numbers == null || length == 0) return false;
        for (int i = 0; i < length; i++) {
            while (i != numbers[i]) {
                int temp = numbers[numbers[i]];
                if (temp == numbers[i]) {
                    duplication[0] = temp;
                    return true;
                }
                numbers[numbers[i]] = numbers[i];
                numbers[i] = temp;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] ints = {2, 1, 3, 0, 4};
        System.out.println(duplicate1(ints, ints.length, new int[]{-1}));

    }
}
