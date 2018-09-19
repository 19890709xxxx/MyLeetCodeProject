package com.my.app.myleetcodeproject;

/**
 * @description: 搜索插入位置
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-09-19 16:59
 * @version: 1.0
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */

public class _35_SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6},7)+"");
    }

    // 我的思路
    public static int searchInsert(int[] nums, int target) {
        if (nums.length ==0)
            return 0;

        int flag =0;//用于记录target不存在数组中的时候，target应该插入的位置下标

        for (int i =0; i<nums.length;i++) {
            if (target <= nums[i])//如果找到跟target相等或者大于target的数字，则返回当前循环的下标
                return i;
            else if (target > nums[i])//如果target大于当前数，那么target应该排在这个数字后面，flag加1；
                flag++;
        }
        return flag;
    }

    //Leetcode 最快的算法
    public int searchInsert2(int[] nums, int target) {
        if(nums.length==0)
            return 0;
        for(int i = 0 ; i < nums.length; i++)
            if(target<=nums[i])//如果找到跟target相等或者大于target的数字，则返回当前循环的下标
                return i;
        return nums.length;//剩下的情况只能是target大于所有的数了，所以target的位置直接就是数组最后，思路真的很清晰，还是要多学习别人好的想法
    }
}
