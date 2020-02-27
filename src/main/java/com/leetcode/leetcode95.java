package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class leetcode95 {
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n<=0) return new ArrayList<TreeNode>();
        return generateTrees(1,n);
    }

    /**
     *left-right任意一点i都可以作为根节点,
     * [left,i-1]作为其左子树的节点，产生左子树集合generateTrees(left,i-1)
     * [i+1,right]作为其右子树的节点，产生左子树集合generateTrees(i+1,right)
     *  遍历左右子树的组合情况
     */
    private List<TreeNode> generateTrees(int start,int end){
        List<TreeNode> ans = new ArrayList<>();
        //此时没有节点，将null加入list中，防止遍历结果错误
        if (start>end){
            ans.add(null);
            return ans;
        }
        //只有一个节点，那么将节点作为树加入list中返回
        if (start==end){
            ans.add(new TreeNode(start));
            return ans;
        }
        for (int i = start; i <=end ; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left=leftTree;
                    treeNode.right=rightTree;
                    ans.add(treeNode);
                }
            }
        }
        return ans;
    }
}
