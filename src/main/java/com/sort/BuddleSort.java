package com.sort;

public class BuddleSort {

    public static void Sort(int[] arr){
        if (arr.length==0) return;
        for (int i = 0; i < arr.length-1; i++) {
            boolean flag = true;
            for (int j = 1; j < arr.length-i; j++) {
                if (arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    flag = false;
                }
            }
            if (flag) return;
        }
    }


    public static void main(String[] args) {
        int[] a = {1,5,2,45,21,4121,54,1,24,0,12,42,21};
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
