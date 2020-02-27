package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * 输入包括多组测试数据。
     * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
     * 学生ID编号从1编到N。
     * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
     * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候,
     * 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
     * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//学生数目
        int M = sc.nextInt();//操作的数目
        int[] arr = new int[N+1]; //记录成绩

        for (int i = 1; i <N+1 ; i++) {
            arr[i]=sc.nextInt();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String C= sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (C.equals("Q")) {
                if (a<=0 || b<=0 || a>=N+1 ||b>=N+1) continue;
                if (a>b){
                    int temp = a;
                    a=b;
                    b=temp;
                }
                int max=arr[a];
                for (int j = a; j <= b &&j<N+1; j++) {
                    if (arr[j]>max){
                        max= arr[j];
                    }
                }
                list.add(max);
            }else if (C.equals("U")){
                if (a<N+1 &&a>0){
                    arr[a]=b;
                }
            }


        }

        sc.close();
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
