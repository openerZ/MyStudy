package com.sort;

public class InsertSort {

    public static void Sort(int[] arr) {
        int j;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (j = i; j > 0 && temp < arr[j - 1]; j--) {
                arr[j]=arr[j-1];
            }
            arr[j]=temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,5,2,45,12,20,21,-1,4121,-8,54,1,24,0,12,42,21};
        for (int i : a) {
            System.out.print(i+" ");
        }
        System.out.println();
        Sort(a);
        for (int i : a) {
            System.out.print(i+" ");
        }
    }
}
