package com.my.app.myleetcodeproject;

/**
 * @description: 167.Two Sum II - Input array is sorted 两数之和 II - 输入有序数组
 * @author: ouyangxin
 * @date: 2018-10-29 17:40
 * @version: 1.0
 * <p>
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */

public class _167_TwoSum2 {

    public static void main(String[] args) {
        twoSum(new int[]{1, 2, 3, 4, 4, 9, 56, 90}, 8);
    }

    //由于是有序数组，可以使用二分查找解题，但是使用双指针收敛查询和值会比较快
    private static int[] twoSum(int[] numbers, int target) {
        int head = 1;//题目要求下标从1开始
        int tail = numbers.length;

        while (head < tail) {
            int result = numbers[head - 1] + numbers[tail - 1];
            if (result > target)//和值大于target，说明可以把tail往左移一位，取更小的tail值去和head相加
                tail--;
            else if (result < target)//和值小于target，说明可以把head往右移一位，取更大的head值去和tail值相加
                head++;
            else
                return new int[]{head, tail};

        }
        return null;
    }

}
