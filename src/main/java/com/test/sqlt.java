package com.test;

import java.util.Scanner;

public class sqlt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double m = sc.nextDouble();
        int n = sc.nextInt();
        double near = 1e-12;
        double left =0,right = m;
        double mid = left+(right-left)/2.0;
        double pow = Math.pow(mid, n);

        while (Math.abs(pow-m)>near){
            mid = left+(right-left)/2.0;
            pow = Math.pow(mid, n);
            if (pow>m){
                right=mid;
            }else {
                left=mid;
            }
        }

        System.out.println(String.format("%.12f",mid));
    }

}

interface A{
    void AA();
    abstract void dd();
}

abstract class B implements A{

}