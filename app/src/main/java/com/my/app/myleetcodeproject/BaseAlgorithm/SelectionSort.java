package com.my.app.myleetcodeproject.BaseAlgorithm;

/**
 * @description: 选择排序
 * @author: ouyangxin
 * @date: 2018-09-28 18:32
 * @version: 1.0
 *
 * 选择排序(假设由小到大排序)就是从第一位开始，循环扫描整个数组，发现扫描到的数字小于
 * 或者等于前面的数字，就把前面的数字替换掉
 *
 * eg:[2,5,4,1,6,7,9,2,4,2]，以下面的代码为例
 *
 * i = 0 时， num[i] = 2, 从下标j=1开始循环数组，发现minIndex = 3，替换i=0位置的数字
 * 以此类推，一直循环到最后一位
 */

public class SelectionSort {


    public static void main(String[] args) {
        for (int i:sort(new int[]{2,5,4,1,6,7,9,2,4,2}))
            System.out.println(i+"");
    }

    private static int[] sort(int[] nums){
        if (nums ==null)
            return new int[0];

        int length = nums.length;
        int minIndex =0;//用于标记扫描到的最小数字的数组下标
        int temp;

        for (int i =0; i<length;i++){
            minIndex = i;//从下标0开始
            for (int j =i+1 ; j < length;j++){//从第一位开始扫描对比
                if (nums[minIndex]>nums[j])//如果扫描到的数字小于现在标记的数字
                    minIndex = j;//就把扫描到的数字下标记录下来，目的就是位了找出i 位置的最小数字下标
            }
            temp = nums[i];//找到了i位置下最小的数字，直接替换i位置的数字
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }

        return nums;
    }
}
