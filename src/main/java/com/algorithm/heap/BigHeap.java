package com.algorithm.heap;

import java.util.Arrays;

/**
 * @author: yuegc
 * @Date: 2021/5/26 17:55
 * @Description: 大顶堆升序排列  思路：构建堆，然后将堆顶和数组最后一个数交换位置，再将剩余的元素重新调整成大顶堆堆
 */
public class BigHeap {
    public static void main(String[] args) {
        int[] arr = {7, 6, 4, 3, 5, 2, 10, 9, 8};
        System.out.println("排序前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    private static void sort(int[] array) { // 1. 把无序数组构建成最大堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }
        // 2. 调整堆结构+交换堆顶元素与末尾元素，调整堆产生新的堆顶
        for (int i = array.length - 1; i > 0; i--) {
            // 最后1个元素和第1个元素进行交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            // “下沉”调整最大堆
            adjustHeap(array, 0, i);
        }
    }

    private static void adjustHeap(int[] array, int parent, int length) {
        // temp 保存父节点值，用于最后的赋值
        int temp = array[parent];
        int child = 2 * parent + 1;
        while (child < length) {
            // 如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if (child + 1 < length && array[child + 1] > array[child]) {
                child++;
            }
            // 如果父节点大于任何一个孩子的值，则直接跳出
            if (temp >= array[child]) {
                break;
            }
            //无须真正交换，单向赋值即可
            array[parent] = array[child];
            parent = child;
            //下一个左孩子
            child = 2 * child + 1;
        }
        array[parent] = temp;
    }
}
