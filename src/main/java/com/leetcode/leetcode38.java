package com.leetcode;

import java.util.HashMap;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 */
public class leetcode38 {

    public String countAndSay1(int n) {
        String[] res = new String[n + 1];
        res[1] = "1";
        HashMap<String,String> map = new HashMap<>();
        map.put("1","11");
        map.put("2","12");
        map.put("3","13");
        map.put("11","21");
        map.put("22","22");
        map.put("33","23");
        map.put("111","31");
        map.put("222","32");
        map.put("333","33");
        for (int i = 2; i <= n; i++) {
            StringBuilder s = new StringBuilder();
            String pre = res[i - 1];
            int k=0;
            for (int j = 1; j < pre.length(); j++) {
                if ( pre.charAt(j - 1) == pre.charAt(j)) {
                    continue;
                }else {
                    s.append(map.get(pre.substring(k,j)));
                    k=j;
                }
            }
            s.append(map.get(pre.substring(k,pre.length())));
            res[i] = s.toString();
        }
        return res[n];
    }

    public static String countAndSay(int n) {
        if (n<=1) return "1";
        //递归获取上一个数
        String pre = countAndSay(n-1);
        StringBuilder ans = new StringBuilder();
        char temp = pre.charAt(0);
        int count=1;
        for (int i = 1; i < pre.length(); i++) {
            char c = pre.charAt(i);
            //可能会重复
            if (c==temp){
                count++;
            }else {
                //添加的上一个符合拼写规则的
                ans.append(count).append(temp);
                count=1;
                temp=c;
            }
        }
        //将最后一个拼写类别加入
        ans.append(count).append(temp);
        return ans.toString();
    }

}
