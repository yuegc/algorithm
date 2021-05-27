package com.algorithm.heap;

import java.util.Arrays;

/**
 * @author: yuegc
 * @Date: 2021/5/26 22:03
 * @Description: 小顶堆降序排列 思路：构建堆，然后将堆顶和数组最后一个数交换位置，再将剩余的元素重新调整成小顶堆堆
 */
public class SmallHeap {
    public static void main(String[] args) {
        int[] arr = {7, 6, 4, 3, 5, 2, 10, 9, 8};
        System.out.println("排序前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }
    }

    private static void adjustHeap(int[] arr, int parent, int length) {
        int temp = arr[parent];
        int child = 2 * parent + 1;
        while (child < length) {
            if (child + 1 < length && arr[child + 1] < arr[child]) {
                child++;
            }
            if (temp < arr[child]) {
                break;
            }
            arr[parent] = arr[child];
            parent = child;
            child = 2 * child + 1;
        }
        arr[parent] = temp;
    }
}
