package com.leetcode.weekLeetcode;

import java.util.*;

public class DoubleWeek17 {

    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            int a = nums[i];
            int b = nums[i + 1];
            for (int j = 0; j < a; j++) {
                list.add(b);
            }

        }
        int[] res = new int[list.size()];
        int k = 0;
        for (Integer integer : list) {
            res[k++] = integer;
        }
        return res;
    }

    public int[][] matrixBlockSum(int[][] mat, int K) {

        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int lr = (i - K) > 0 ? (i - K) : 0;
                int rr = (i + K) < mat.length ? (i + K) : mat.length - 1;
                int lc = (j - K) > 0 ? (j - K) : 0;
                int rc = (j + K) < mat[0].length ? (j + K) : mat[0].length - 1;
                for (int k = lr; k <= rr; k++) {
                    for (int l = lc; l <= rc; l++) {
                        res[i][j] += mat[k][l];
                    }
                }
            }
        }
        return res;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res=0;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll.left!=null){
                queue.offer(poll.left);
            }
            if (poll.right!=null){
                queue.offer(poll.right);
            }
            if ((poll.val&1)==0){
                res+=JD(poll,0);
            }
        }

        return res;
    }

    private int JD(TreeNode root,int k){
        if (root==null) return 0;
        if (k==2){
            return root.val;
        }
        return JD(root.left,k+1)+JD(root.right,k+1);
    }

    public int distinctEchoSubstrings(String text) {

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            for (int j = i+1; j < text.length(); j++) {
                String a = text.substring(i, j);
                if (j+a.length()<=text.length()){
                    if (isCF(a,text.substring(j,j+a.length()))){
                        set.add(a);
                    }
                }else {
                    break;
                }

            }

        }
        return set.size();
    }

    private boolean isCF(String a,String b){
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i)!=b.charAt(i)){
                return false;
            }
        }

        return true;
    }
}
