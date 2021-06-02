package com.algorithm.array;

import java.util.Arrays;

/**
 * @author: yuegc
 * @Date: 2021/6/2 10:38
 * @Description: 单边循环法  O(nlogn)
 */
public class QuickSort2 {
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大于或等于endIndex时
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        // 根据基准元素，分成两部分进行递归排序
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    /*** 分治（单边循环法）
     ** @param arr 待交换的数组
     * @param startIndex 起始下标
     * @param endIndex 结束下标
     * @return
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 取第1个位置（也可以选择随机位置）的元素作为基准元素
        int pivot = arr[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 7, 3, 5, 6, 2, 8, 1};

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
