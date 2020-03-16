package com.leetcode.weekLeetcode;

import java.util.*;

public class Double180 {

    /******************1380*********************/
    public List<Integer> luckyNumbers(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] rowMin = new int[n];
        Arrays.fill(rowMin,Integer.MAX_VALUE);
        int[] colsMax = new int[m];
        Arrays.fill(colsMax,Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] < rowMin[i]) {
                    rowMin[i] = matrix[i][j];
                }
                if (matrix[i][j] > colsMax[j]) {
                    colsMax[j] = matrix[i][j];
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == rowMin[i] && matrix[i][j] == colsMax[j]) {
                    list.add(matrix[i][j]);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }

    /******************1381*********************/
    int maxSize;
    int cur = 0;
    int[] arr;

    public void CustomStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public void push(int x) {
        if (cur < maxSize) {
            arr[cur++] = x;
        }
    }

    public int pop() {
        if (cur != 0) {
            return arr[--cur];
        }
        return -1;
    }

    public void increment(int k, int val) {
        int temp = Math.min(k, cur);
        for (int i = 0; i < temp; i++) {
            arr[i] += val;
        }
    }

    /******************1382*********************/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }
    ArrayList<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return buildBST(0,list.size()-1);
    }
    private  TreeNode buildBST(int l,int r){
        if (l<r){
            int mid = l+(r-l)/2;
            TreeNode root = new TreeNode(list.get(mid));
            root.left = buildBST(l,mid-1);
            root.right = buildBST(mid+1,r);
            return root;
        }else if (l==r){
            return new TreeNode(list.get(l));
        }
        return null;
    }

    private void inOrder(TreeNode root){
        if (root==null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    /******************1383*********************/
    /*public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();



    }*/
 }
