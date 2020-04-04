package com.leetcode;

public class KMP {

    private int[] getNext(String p){
        int n = p.length();
        int[] next = new int[n];
        next[0]=-1;
        int k=-1;
        int j=0;
        while (j<n-1){
            if (k == -1 || p.charAt(k) == p.charAt(j)) {
                k++;
                j++;
                if (p.charAt(k)!=p.charAt(j)){
                    next[j] =k;
                }else {
                    next[j] = next[k];
                }
            }else {
                k = next[k];
            }
        }
        return next;
    }
    public int kmpSeaarch(String txt,String pat){
        int i=0,j=0;
        int tL = txt.length();
        int pL = pat.length();
        int[] next = getNext(txt);
        while (i<tL&&j<pL){

            if (j == -1 || txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }else {
                j=next[j];
            }
        }
        if (j==pL){
            return i-j;
        }else {
            return -1;
        }
    }
}
