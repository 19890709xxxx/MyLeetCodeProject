package com.my.app.myleetcodeproject.BaseAlgorithm;

/*
* 希尔排序 ， 插入排序的优化版本，第一个打入 O（N2）的算法
* */
public class ShellSort {

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 0, 9, 3, 12, 7, 8, 3, 4, 65, 22};

        sort(arr);



        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    private static void sort(int[] nums){
        int j;

        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i <nums.length ; i++) {
                int temp = nums[i];

                for (j = i ; j >= gap&&nums[j-gap]>temp;j -=  gap){
                    nums[j] = nums[ j -gap];
                }

                nums[j] =temp;
            }

        }
    }

}
