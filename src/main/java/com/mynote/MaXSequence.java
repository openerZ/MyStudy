package com.mynote;


/**
 * 求整形数组的最大子序列
 *
 *
 *
 */
public class MaXSequence{
    /**
     * 最大子序列和
     *
     * @param arr
     * @return
     */
    public static int maxSubSum(int[] arr){

        int maxSub=0;
        int thisSum=0;
        int length = arr.length;
        for (int i=0;i<length;i++){
            thisSum+=arr[i];

            if (thisSum>maxSub){
                maxSub=thisSum;
            }else if (thisSum<0){
                thisSum=0;
            }
        }
        return maxSub;
    }

    /**
     * 最小子序列和
     *
     * @param arr
     * @return
     */
    public static int minSubSum(int[] arr){

        int mainSum =0;
        int thisSum = 0;
        int length = arr.length;
        for (int i=0;i<length;i++){
            thisSum+=arr[i];
            if (mainSum>thisSum){
                mainSum=thisSum;
            }else if (thisSum>0){
                thisSum=0;
            }

        }

        return mainSum;
    }

    public static void main(String[] args) {
        int a[] = {10,-7,-8,2 ,-5};
        System.out.println(minSubSum(a));
    }
}

