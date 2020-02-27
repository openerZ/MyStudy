package com.leetcode;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class leetcode109 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
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

    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        int cnt = 0;
        while (cur != null) {
            cur = cur.next;
            cnt++;
        }
        int[] arr = new int[cnt];
        cnt = 0;
        cur = head;
        while (cur != null) {
            arr[cnt++] = cur.val;
            cur = cur.next;
        }
        return buildTree(arr, 0, arr.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(nums[start]);
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid - 1);
        root.right = buildTree(nums, mid + 1, end);
        return root;
    }

    /**
     * 链表有序那么在链表上进行二分法：
     *  链表二分法就要找到链表的中间节点：
     *      设置连个指针一个慢指针，一次走一步，一个快指针，一次走两步
     *      当快指针走到尾时，慢指针值得就是链表的中间节点
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        else if (head.next == null) return new TreeNode(head.val);
        ListNode pre = head;//中间节点的前一个节点
        ListNode p=pre.next;//一次走一步
        ListNode q=p.next;//一次走两步
        //找到链表的中间位置
        while (q!=null&&q.next!=null){
            pre = pre.next;
            p=p.next;
            q=q.next.next;
        }
        pre.next=null;
        TreeNode root = new TreeNode(p.val);
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(p.next);
        p.next=null;
        return root;
    }
    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null) return null;
        else if (head.next == null) return new TreeNode(head.val);
        ListNode dummy = new ListNode(-1);
        dummy.next =head;
        ListNode p=head;//一次走一步
        ListNode q=head;//一次走两步
        //找到链表的中间位置
        while (q!=null&&q.next!=null){
            dummy = dummy.next;
            p=p.next;
            q=q.next.next;
        }
        dummy.next=null;
        TreeNode root = new TreeNode(p.val);
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(p.next);
        p.next=null;
        return root;
    }
}
