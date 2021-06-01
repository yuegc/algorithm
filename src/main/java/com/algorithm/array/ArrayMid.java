package com.algorithm.array;

/**
 * @author: yuegc
 * @Date: 2021/5/27 15:07
 * @Description: 两个有序数组，计算他们的中位数
 */
public class ArrayMid {
    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        System.out.println("合并后数组的中位数为：" + findMid(arr1, arr2));
    }

    public static double findMid(int[] arr1, int[] arr2) {
        int[] array = new int[arr1.length + arr2.length];
        int k = array.length - 1;
        int len1 = arr1.length - 1;
        int len2 = arr2.length - 1;
        while (len1 >= 0 && len2 >= 0) {
            if (arr1[len1] > arr2[len2]) {
                array[k] = arr1[len1];
                len1--;
            } else {
                array[k] = arr2[len2];
                len2--;
            }
            k--;
        }
        while (len2 >= 0) {
            array[k] = arr1[len2];
            len2--;
            k--;
        }
        while (len1 >= 0) {
            array[k] = arr1[len1];
            len1--;
            k--;
        }
        int len = array.length;
        if (len % 2 == 0) {
            return (array[len / 2] + array[len / 2 - 1]) / 2.0;
        } else {
            return array[len / 2];
        }
    }
}
