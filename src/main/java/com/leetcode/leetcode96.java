package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class leetcode96 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 会超出时间限制
     * @param n
     * @return
     */
    public int numTrees1(int n) {
        if (n <= 0) return 0;
        int k = 0;
        for (int i = 1; i <= n; i++) {
            List<TreeNode> leftTrees = generateTrees(1, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, n);
            k+=leftTrees.size()*rightTrees.size();
        }
        return k;
    }
    private List<TreeNode> generateTrees(int start, int end) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }
        if (start == end) {
            ans.add(new TreeNode(start));
            return ans;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode rt = new TreeNode(i);
                    rt.left = leftTree;
                    rt.right = rightTree;
                    ans.add(rt);
                }
            }
        }

        return ans;
    }


    /**
     * 动态规划，将树分为三个部分，左子树（j）+root(1)+右子树(i-j-1)=i
     * 动态规划数组dp[i]表示i个节点有多少种排列成树的方式
     * i个节点时，左部分的个数从0-(i-1) root节点保持1个不变， 右子树从（i-1）-0排列
     * 一种组合生成dp[j]*dp[1]*dp[i-j-1],所有的组合生成的和是dp[i]
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        for (int i = 1; i <dp.length ; i++) {
            for (int j = 0; j <i ; j++) {
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}
