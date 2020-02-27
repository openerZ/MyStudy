package com.leetcode.weekLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class DoubleWeek18 {

    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        HashMap<Integer, Integer> map = new HashMap<>();
        int k = 1;
        for (int i : newArr) {
            if (!map.containsKey(i)) {
                map.put(i, k++);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(i);

        }
        return arr;
    }

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() <= 1) return "";
        int count = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < palindrome.length() / 2; i++) {
            char c = palindrome.charAt(i);
            if (c != 'a') {
                str.append(palindrome.substring(0, i))
                        .append('a')
                        .append(palindrome.substring(i + 1, palindrome.length()));
                count++;
                break;
            }
        }
        return count > 0 ? str.toString() : palindrome.substring(0, palindrome.length() - 1) + "b";
    }

    public static void main(String[] args) {
        DoubleWeek18 db = new DoubleWeek18();
        System.out.println(db.breakPalindrome("abababa"));
    }

    public int[][] diagonalSort(int[][] mat) {
        int i = 0;
        while (i < mat.length-1) {
            int j = 0;
            while (j < mat[0].length-1) {
                if (i!=0 && j!=0){
                    break;
                }
                ArrayList<Integer> list = new ArrayList<>();
                int row = i;
                int cols = j;
                while (row < mat.length && cols < mat[0].length) {
                    list.add(mat[row++][cols++]);
                }
                Collections.sort(list);
                row = i;
                cols = j;
                for (Integer num:list) {
                    mat[row++][cols++] = num;
                }
                j++;
            }
            i++;
        }
        return mat;
    }

    /*public int maxValueAfterReverse(int[] nums) {

    }*/
}
