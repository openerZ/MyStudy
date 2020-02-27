package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode202 {

    public boolean isHappy(int n) {

        List<Integer> list = new ArrayList<>();
        while (n!=1){
            if (list.contains(n)) return false;
            list.add(n);
            n=KL(n);
        }
        return true;
    }

    private int KL(int n){
        int res =0;
        while (n!=0){
            res =res+(n%10)*(n%10);
            n/=10;
        }
        return res;
    }
}
