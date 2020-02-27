package com.sort;

public class SelectSort {


    public static void Sort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j <arr.length ; j++) {
                if (arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

    }

    public static void main(String[] args) {
        int[] a = {1,5,2,45,21,-1,4121,54,1,24,0,12,42,21};
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
