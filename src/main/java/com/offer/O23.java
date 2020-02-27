package com.offer;


import java.util.Stack;

/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class O23 {
    /**
     *
     *
     * BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），
     * 如果去掉最后一个元素的序列为T，那么T满足：T可以分成两段，前一段（左子树）小于x，
     * 后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。完美的递归定义 :
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return recre(sequence, 0, sequence.length - 1);
    }

    private boolean recre(int[] arr, int start, int end) {

        if (start>=end) return true;
        int root = arr[end]; //当前数组的根节点
        int k = start;
        while (k < end && arr[k] < root) { //找出当前树的左子树的范围：比根节点小都是的
            k++;
        }
        for (int i = k; i < end; i++) { //数组的剩下的部分要比根节点大
            if (arr[i] < root) //如果剩下的部分有比根节点小的那就不符合
                return false;
        }

        return recre(arr, start, k - 1) && recre(arr, k, end-1);
    }

    /**
     * 给一个数组，判断该数组是否为二叉搜索树的前序遍历结果
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST1(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return inOrderBST(sequence,0,sequence.length-1);
    }

    private boolean inOrderBST(int[] arr,int start,int end){
        if (start>=end) return true;

        int root = arr[start]; //前序遍历的数组起始是当前树的根节点

        int k = start+1;
        while (k <=end && arr[k] < root) { //找出当前树的左子树的范围：比根节点小都是的
            k++;
        }
        for (int j=k;j<=end;j++){
            if (arr[j]<root){
                return false;
            }
        }

        return inOrderBST(arr,start+1,k-1) && inOrderBST(arr,k,end);
    }

}
