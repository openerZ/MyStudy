package com.leetcode;

import org.omg.CORBA.MARSHAL;

import java.util.Arrays;
import java.util.List;

public class LeetCodeWeek {
    /*********************************************************/

    public int[] replaceElements(int[] arr) {
        int len = arr.length - 1;
        int max = -1;
        for (int i = len; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp, max);
        }
        return arr;
    }

    /*********************************************************/


    int sm = 0;
    int res = 0;

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length - 1;
        int sum = 0;
        int dp = 0;
        int k = 0;
        for (int i = 0; i <= arr[len]; i++) {
            if (arr[k] < i) {
                dp += arr[k++];
            }
            sum = dp + (len - k + 1) * i;
            BeastValue(target, sum, i);
        }
        return res;
    }

    private void BeastValue(int target, int sum, int index) {
        if (Math.abs(target - sum) < Math.abs(target - sm)) {
            sm = sum;
            res = index;
        }
    }

    /*********************************************************/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int Sum = 0;
    private int maxdepth = 0;

    public int deepestLeavesSum(TreeNode root) {
        deepMaxtDepth(root, 1);
        dfs(root, maxdepth - 1);
        return Sum;
    }

    private void deepMaxtDepth(TreeNode root, int depth) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (maxdepth < depth) {
                maxdepth = depth;
            }
            return;
        }
        deepMaxtDepth(root.left, depth + 1);
        deepMaxtDepth(root.right, depth + 1);
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (depth == 0) {
                Sum += root.val;
            }
            return;
        }
        dfs(root.left, depth - 1);
        dfs(root.right, depth - 1);
    }

    /*********************************************************/

   /* public int[] pathsWithMaxScore(List<String> board) {

        int[][] dp = new int[board.size()][board.get(0).length()];

        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(0).length(); j++) {

            }
        }

    }*/


}
