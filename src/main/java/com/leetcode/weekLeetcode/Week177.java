package com.leetcode.weekLeetcode;

import jdk.internal.org.objectweb.asm.Handle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Week177 {

    public int daysBetweenDates(String date1, String date2) {
        LocalDate startDate = LocalDate.parse(date1);
        LocalDate endDate = LocalDate.parse(date2);
        long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);
        return Math.abs((int) daysDiff);
    }

    /**************************************************/

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        if (n == 1) return true;
        HashSet<Integer> set = new HashSet<>();

        for (int i : leftChild) {
            if (i == 0) return false;
            if (i != -1) {
                set.add(i);
            }
        }
        for (int i : rightChild) {
            if (i == 0 || set.contains(i)) return false;
            if (i != -1) {
                set.add(i);
            }
        }
        return set.size() == n - 1 ? true : false;

    }


    public int[] closestDivisors(int num) {
        int n1 = num + 1;
        int n2 = num + 2;
        int[] ans  = new int[2];
        int k = (int) Math.sqrt(n2);
        //从平方数开始向前找
        for (int i = k; i >=1; i--) {
            int i1 = n1 % i;
            if (i1 == 0 ) {
                ans[0] = i;
                ans[1] = n1 / i;
                break;
            }
            int i2 = n2 % i;
            if (i2 == 0 ) {
                ans[0] = i;
                ans[1] = n2 / i;
                break;
            }
        }
        return ans;

    }

  /*  public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);



    }*/

}

