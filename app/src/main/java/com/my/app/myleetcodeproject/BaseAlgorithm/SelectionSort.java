package com.my.app.myleetcodeproject.BaseAlgorithm;

/**
 * @description: 选择排序
 * @author: ouyangxin
 * @date: 2018-09-28 18:32
 * @version: 1.0
 *
 * 选择排序就是逐个扫描
 */

public class SelectionSort {


    public static void main(String[] args) {

    }

    private static int[] sort(int[] nums){
        if (nums ==null)
            return new int[0];

        int length = nums.length;
        int minIndex =0;
        int temp;

        for (int i =0; i<length;i++){
            minIndex = i;
            for (int j =i+1 ; j < length;j++){
                if (nums[minIndex]>nums[j])
                    minIndex = j;
            }
            temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }

        return nums;
    }
}
