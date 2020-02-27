package com.offer;

/**
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 */
public class O37 {

    /**
     * 时间复杂度O(N)
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) return 0;
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                num++;
            }
        }

        return num;

    }

    /**
     * 使用二分法找到目标值在数组中的第一次位置和最后一次出现的位置
     *  last-first+1
     * 时间复杂度O(logN)
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK1(int[] array, int k) {
        if (array == null || array.length == 0) return 0;
        int firstIndex = getFirstIndex(array, 0, array.length - 1, k);
        int lastIndex = getLastIndex(array, 0, array.length - 1, k);

        if (firstIndex > -1 && lastIndex > -1) {
            return lastIndex - firstIndex + 1;
        }

        return 0;
    }

    /**
     * 使用二分法递归获取K在排序数组中第一次出现的索引为止
     */
    private int getFirstIndex(int[] arr, int left, int right, int k) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;

        //如果中间位置恰好是目标值
        if (arr[mid] == k) {
            if (mid > 0 && arr[mid - 1] == k) {
                right = mid - 1;
            } else {
                return mid;
            }

        } else if (arr[mid] < k) {
            left = mid + 1;
        } else {

            right = mid - 1;
        }
        return getFirstIndex(arr, left, right, k);
    }

    /**
     * 使用循环查找k最后一次出现在数组的索引位置
     */
    private int getLastIndex(int[] arr, int left, int right, int k) {

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == k) {
                if (mid < right && arr[mid + 1] == k) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else if (arr[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
