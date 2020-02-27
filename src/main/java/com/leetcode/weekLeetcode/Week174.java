package com.leetcode.weekLeetcode;

import java.util.*;

public class Week174 {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<ZDL> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int mj=0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    break;
                }
                mj++;
            }
            list.add(new ZDL(mj, i));

        }

        Collections.sort(list, new Comparator<ZDL>() {
            @Override
            public int compare(ZDL o1, ZDL o2) {
                if (o1.majar.equals(o2.majar)) {
                    return o1.row - o2.row;
                }
                return o1.majar - o2.majar;
            }
        });

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).row;
        }
        return res;
    }

    private class ZDL {
        public Integer majar;
        public Integer row;

        public ZDL(Integer majar, Integer row) {
            this.majar = majar;
            this.row = row;
        }
    }

    public int minSetSize(int[] arr) {
        if (arr.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Element[] ret = new Element[map.size()];
        int k = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ret[k++] = new Element(entry.getKey(), entry.getValue());
        }

        Arrays.sort(ret, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o2.num - o1.num;
            }
        });

        int ans = 0;
        int sum = 0;
        for (Element element : ret) {
            if (sum >= arr.length / 2) {
                break;
            }
            sum += element.num;
            ans++;
        }
        return ans;

    }

    private class Element {
        public int value;
        public int num;


        public Element(int value, int num) {
            this.value = value;
            this.num = num;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
