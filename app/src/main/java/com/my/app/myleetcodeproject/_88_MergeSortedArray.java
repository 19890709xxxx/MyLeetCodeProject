package com.my.app.myleetcodeproject;

/**
 * @description: 88. Merge Sorted Array 合并两个有序数组
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-09-27 15:17
 * @version: 1.0
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */

public class _88_MergeSortedArray {

    public static void main(String[] args) {
        merge(new int[]{1, 4, 5, 0, 0, 0}, 3, new int[]{2, 3, 6}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums1 == null || nums2 == null)
            return;


        int[] result = new int[m + n];

        int i = 0;
        int j = 0;
        int p = 0;

        while (i < m && j < n) {// 不断遍历两个数组，找出比较小的数字，填充进result数组
            if (nums1[i] <= nums2[j]) {
                result[p++] = nums1[i++];
            } else {
                result[p++] = nums2[j++];
            }
        }

        /*查找 nums1 或者 nums2  剩下的最后一位数组，把它放在result 数组最后一位*/
        while (i < m) {
            result[p++] = nums1[i++];
        }

        while (j < n) {
            result[p++] = nums2[j++];
        }

        //硬拷贝数组resuly 到 num1 ，arraycopy 后两个数组内存地址不一样，引用值被拷贝了一份，
        // 而num1 =result 只是软拷贝，引用了对象的内存地址而已，两个数组内存地址是一样的
        System.arraycopy(result, 0, nums1, 0, m + n);
    }

}
