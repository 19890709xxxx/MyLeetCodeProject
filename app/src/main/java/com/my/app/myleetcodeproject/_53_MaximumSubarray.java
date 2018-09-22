package com.my.app.myleetcodeproject;

/**
 * @description: 53. Maximum Subarray 最大子序和
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-09-21 14:27
 * @version: 1.0
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */

public class _53_MaximumSubarray {

    public static void main(String[] args) {

        System.out.println(maxSubArray2(new int[]{-11,-2,-47,-5,-5,-6,-4,-7,-8,-2,-100}));
    }


    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0]; //maxEndingHere用于记录阶段性最大值，maxSoFar用于记录全局最大值
        for (int i = 1; i < nums.length; ++i){
            /*
            * 不断累加，但是如果发现累加到nums[i]的和小于nums[i]，那么累加中断，这里对axEndingHere+nums[i]和nums[i]
            * 的大小判断就是要看看累加是否处于递增状态，如果累加的值比当前数要小，那么这时候maxEndingHere存储当前数字，
            * 作为阶段性的最大和值
            * */
            maxEndingHere = Math.max(maxEndingHere+nums[i], nums[i]);

            /*
            * 全局最大和值和阶段性最大和值相比较，取最大值作为全局最大和值
            * */
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    //LeetCode最快算法
    public static int maxSubArray2(int[] nums) {

        int sum = Integer.MIN_VALUE;//初始化全局最大和值为整型的最小数

        /*
        * 作为和值标记，如果和值持续大于0，则说明这个标记属于正向标记，和后面的数相加是正向作用，
        * 如果小于0，则是反向作用，会令和后面的数相加和值减少,所以一旦sumFlag小于0，则重置为0，摈弃循环遇到的使sumFlag变负值的数字
        * */
        int sumFlag = 0;
        int i = 0;
        while(i < nums.length){
            sumFlag += nums[i];//不断累加
            sum = Math.max(sum, sumFlag);//找出最大值赋值给全局最大和值
            if(sumFlag < 0){
                sumFlag = 0 ;
            }

            i++;
        }

        return sum;
    }
}
