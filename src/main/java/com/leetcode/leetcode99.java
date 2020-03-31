package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二叉搜索树中的两个节点被错误地交换。
 * <p>
 * 请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,null,null,2]
 * <p>
 *    1
 *   /
 *  3
 *   \
 *    2
 * <p>
 * 输出: [3,1,null,null,2]
 * <p>
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 * <p>
 * 输入: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 *    /
 *   2
 * <p>
 * 输出: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 *    /
 *  3
 * 进阶:
 * <p>
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 */
public class leetcode99 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*List<TreeNode> treeList = new ArrayList<>();
    int[] numList;
    int k = 0;

    public void recoverTree(TreeNode root) {
        inOrder(root);
        numList = new int[treeList.size()];
        inOrderInteger(root);
        Arrays.sort(numList);
        for (int i = 0; i < numList.length; i++) {
            treeList.get(i).val = numList[i];
        }
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        treeList.add(root);
        inOrder(root.right);
    }

    private void inOrderInteger(TreeNode root) {
        if (root == null) return;
        inOrderInteger(root.left);
        numList[k++] = root.val;
        inOrderInteger(root.right);
    }
*/
    TreeNode first = null;
    TreeNode last = null;
    TreeNode pre = null;
    boolean findfirst = false;

    public void recoverTree(TreeNode root) {
        inOrderLast(root);
        if (last == null) return;
        inOrderFirst(root);
        int temp = last.val;
        last.val = first.val;
        first.val = temp;

    }

    /**
     * 找到中序遍历的最后一个降序节点
     *
     * @param root
     */
    private void inOrderLast(TreeNode root) {
        if (root == null) return;
        inOrderLast(root.left);
        if (pre == null) {
            pre = root;
        } else if (pre.val > root.val) {
            last = root;
        }
        pre = root;
        inOrderLast(root.right);
    }

    /**
     * 找到第一个大于last的节点
     *
     * @param root
     */
    private void inOrderFirst(TreeNode root) {
        if (root == null || findfirst == true) return;
        inOrderFirst(root.left);
        if (first == null && root.val > last.val) {
            first = root;
            findfirst = true;
            return;
        }

        inOrderFirst(root.right);
    }


    TreeNode t1, t2, Pre;
    public void recoverTree2(TreeNode root) {
        inorder(root);
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }
    public void inorder(TreeNode root){
        if (root == null) return ;
        inorder(root.left);
        if (Pre != null && Pre.val > root.val) {
            if (t1 == null) t1 = Pre;
            t2 = root;
        }
        Pre = root;
        inorder(root.right);
    }

    /**
     * Morris遍历
     * @param root
     */
    public void recoverTree1(TreeNode root) {
        TreeNode before = null;
        TreeNode first = null;
        TreeNode second = null;
        while (root != null) {
            //当左子树不为null，寻找左子树的最右节点，该节点为中序遍历中的前一个节点
            if (root.left != null) {
                TreeNode pre = getPredecessor(root);
                //pre节点没被修改，则修改右节点为root，以便后续循环中能通过pre.right回到root节点
                if (pre.right == null) {
                    pre.right = root;
                    root = root.left;
                    //继续遍历左子树
                    continue;
                } else if (pre.right == root) {
                    //将修改后的pre节点恢复原样
                    pre.right = null;
                }
            }
            //当左子树为null，或者pre.right为root时，先判断before节点和root节点是否倒序，然后再遍历右子树
            if (first == null && before != null && before.val > root.val)
                first = before;
            if (first != null && before != null && before.val > root.val)
                second = root;
            before = root;
            root = root.right;
        }
        swap(first, second);
    }
    //寻找一个节点的左子树的最右节点
    private TreeNode getPredecessor(TreeNode n) {
        TreeNode pre = n;
        if (n.left != null) {
            pre = pre.left;
            while (pre.right != null && pre.right != n) {
                pre = pre.right;
            }
        }
        return pre;
    }
    //交换两个节点
    private void swap(TreeNode first, TreeNode second) {
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
