package com.algorithm.array;

/**
 * @author: yuegc
 * @Date: 2021/6/2 09:25
 * @Description: 二分查找 O(logn)
 */
public class HalfSearch {
    public static int binarySearch(int[] nums) {
        //低位索引
        int low = 0;
        //高位索引
        int high = nums.length - 1;
        //中间索引
        int mid = 0;

        while (low <= high && low >=0) {
            mid = (low + high) / 2;
            if (low == high) {
                break;
            }
            //偶数位
            if (mid % 2 == 0) {
                // 与后面的数相等
                if (nums[mid] == nums[mid + 1]) {
                    //前面的都对
                    low = mid + 1;
                }
                // 与前面的数相等
                else if (nums[mid] == nums[mid - 1]) {
                    //后面的都对
                    high = mid - 1;
                }
                // 就是这个数
                else {
                    return nums[mid];
                }
            }
            //奇数位
            else {
                // 与前面的数相等
                if (nums[mid] == nums[mid - 1]) {
                    //前面的都对
                    low = mid + 1;
                }
                //与后面的数相等
                else if (nums[mid] == nums[mid + 1]) {
                    //后面的都对
                    high = mid - 1;
                }
                // 就是这个数
                else {
                    return nums[mid];
                }
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 4, 4, 5, 5};
        System.out.println(binarySearch(nums));
    }
}
