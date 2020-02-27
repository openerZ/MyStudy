package com.sort;

public class NumberSort {

    public static void Sort(int[] arr) {
        int max = arr[0];
        //先找最大值
        for (int i = max; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //开辟统计数组
        int[] count = new int[max + 1];
        //统计
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int index = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                int cnt = count[i];
                while (cnt > 0) {
                    arr[index++] = i;
                    cnt--;
                }
            }
        }
    }

    public static void ScoreSort(int[] arr) {
        int max = arr[0];
        //先找最大值
        for (int i = max; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //开辟统计数组
        int[] count = new int[max + 1];
        //统计
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        //排名累加
        for (int i = count.length - 2; i >= 0; i--) {
            //count[i]的下标是原数组的值，count[i]是排序后在原数组的下标位置+1
            count[i] = count[i] + count[i + 1];
        }

        int[] sortarr = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            sortarr[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortarr[i];
        }

    }

    public static void main(String[] args) {
        int[] a = {2, 2, 2, 4, 5, 4, 5, 10, 1, 1, 1, 0, 0, 1};
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        ScoreSort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
