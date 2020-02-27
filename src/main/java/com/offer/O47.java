package com.offer;

/**
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * <p>
 * 数据范围：
 * <p>
 * 对于%50的数据,size<=10^4
 * <p>
 * 对于%75的数据,size<=10^5
 * <p>
 * 对于%100的数据,size<=2*10^5
 */
public class O47 {

    /**
     * O(N2)的算法不推荐
     *
     * @param array
     * @return
     */
    public int InversePairs1(int[] array) {
        int sum = 0;
        if (array == null || array.length == 0) return sum;

        int length = array.length;

        for (int i = length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[i]) {
                    sum++;
                }
            }
        }
        return sum % 1000000007;
    }

    private int[] copy;
    private int sum = 0;

    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) return 0;
        copy = new int[array.length];
        GB(array, 0, array.length - 1);
        return sum % 1000000007;
    }

    /**
     * 归并排序
     */
    private void GB(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left)>> 1;
        GB(arr, left, mid);
        GB(arr, mid + 1, right);
        HB(arr, left, right);
    }

    private void HB(int[] arr, int left, int right) {
        int mid = left + (right - left)>> 1;
        int first = mid;
        int second = right, index = right;
        while (first >= left && second > mid) {
            if (arr[first] > arr[second]) {
                sum = sum + (second - mid);
                copy[index] = arr[first--];
            } else {
                copy[index] = arr[second--];
            }
            index--;
        }
        while (first >= left) {
            copy[index--] = arr[first--];
        }
        while (second > mid) {
            copy[index--] = arr[second--];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = copy[i];
        }
    }

    public static void main(String[] args) {
        O47 o47 = new O47();
        int[] a = {8, 2, 7, 4, 12, 5, 6};
        System.out.println(o47.InversePairs(a));
    }


    private long cnt = 0;
    private int[] tmp;  // 在这里声明辅助数组，而不是在 merge() 递归函数中声明

    public int InversePairs2(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return (int) (cnt % 1000000007);
    }

    private void mergeSort(int[] nums, int l, int h) {
        if (h - l < 1)
            return;
        int m = l + (h - l) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, h);
        merge(nums, l, m, h);
    }

    private void merge(int[] nums, int l, int m, int h) {
        int i = l, j = m + 1, k = l;
        while (i <= m || j <= h) {
            if (i > m)
                tmp[k] = nums[j++];
            else if (j > h)
                tmp[k] = nums[i++];
            else if (nums[i] <= nums[j])
                tmp[k] = nums[i++];
            else {
                tmp[k] = nums[j++];
                this.cnt += m - i + 1;  // nums[i] > nums[j]，说明 nums[i...mid] 都大于 nums[j]
            }
            k++;
        }
        for (k = l; k <= h; k++)
            nums[k] = tmp[k];
    }
}
