package com.offer;


import java.util.ArrayList;

/**
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
 * 他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，
 *
 * 序列间按照开始数字从小到大的顺序
 */
public class O42 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        int p =1,q=2;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(p);
        result.add(q);
        while (result.size()>1 && p<q){
            int s = (p + q)*(q-p+1)/2;
            if (s==sum){
                list.add(new ArrayList<>(result));
                result.add(++q);
            }else if (s<sum){
                result.add(++q);
            }else {
                result.remove(0); //remove操作过于复杂建议不这样用
                p++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        O42 o42 = new O42();
        ArrayList<ArrayList<Integer>> list = o42.FindContinuousSequence(3);
        System.out.println(list);
    }

    /**
     * 用两个数字start和end分别表示序列的最大值和最小值，
     * 首先将start初始化为1，end初始化为2.
     * 如果从start到end的和大于s，我们就从序列中去掉较小的值(即增大start),
     * 相反，只需要增大end。
     * 终止条件为：一直增加begin到(1+sum)/2并且end小于sum为止
     *
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int start = 1, end = 2;
        int curSum = 3;
        while (end < sum) {
            if (curSum > sum) {
                curSum -= start;
                start++;
            } else if (curSum < sum) {
                end++;
                curSum += end;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++)
                    list.add(i);
                ret.add(list);
//                curSum -= start;
//                start++;
                end++;
                curSum += end;
            }
        }
        return ret;
    }
}
