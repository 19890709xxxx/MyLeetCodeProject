package com.my.app.myleetcodeproject;

/**
 * @description: 189. Rotate Array 旋转数组
 * @author: ouyangxin
 * @date: 2018-12-17 11:54
 * @version: 1.0
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 */

public class _189_Rotate_Array {

    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3);
    }

    private static void rotate(int[] nums, int k) {

        if(k <= 0)
            return;

        int length = nums.length;
        k %= length;

        reverse(nums , 0 , length-1); //进行三次倒转 ， 全部倒转必须排在第一
        reverse(nums , 0 , k-1);
        reverse(nums , k , length-1);

    }

    private static void reverse(int[] nums, int start , int end){

        while(start<end){

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;

        }

    }
}
