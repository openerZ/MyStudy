package com.newcode;

import java.util.Scanner;

public class TX2017 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] chars = s.toCharArray();
      /*  for (int i = 0; i < chars.length-1; i++) {
            for (int j = 0; j < chars.length-1-i; j++) {
                if (chars[j]<97 && chars[j+1]>=97){
                    char temp = chars[j];
                    chars[j]=chars[j+1];
                    chars[j+1] =temp;
                }
            }
        }*/
        int small =0,big = 0;
        while (small<chars.length&& big<chars.length){

            if (chars[big]>=97){
                char temp = chars[big];
                chars[big] = chars[small];
                chars[small] = temp;
                small++;
            }
            big++;
        }


        s=new String(chars);
        System.out.println(s);
    }
}

