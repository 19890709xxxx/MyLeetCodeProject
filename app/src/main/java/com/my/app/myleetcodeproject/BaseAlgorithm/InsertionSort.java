package com.my.app.myleetcodeproject.BaseAlgorithm;


/*
* 插入排序 https://www.youtube.com/watch?v=TC8VHJlHaAM
* */
public class InsertionSort {

    public static void main(String[] args) {

        int[] a = sort3(new int[]{2,5,2,1,4,6,3,8,44,9,6,23,32});

        for (int i : a) {
            System.out.println(i+"");
        }
    }



    private static int[] sort1(int[] nums) {
        if (nums == null)
            return null;

        int length = nums.length;

        int preIndex , current ;

        for (int i = 1; i <length ; i++) {// 从第二位开始循环对比，假设第一位是已排序好的

            preIndex = i-1;
            current = nums[i];

            while (preIndex >= 0&& nums[preIndex]>current){

                nums[preIndex+1] = nums[preIndex];

                preIndex--;

            }

            nums[preIndex +1] = current;


        }

        return nums;
    }

    private static int[] sort2(int[] nums){

        if (nums == null)
            return  null;

        int j ;//记录下标
        int length = nums.length;

        for (int i =1; i < length ; i++){// 从第二位开始循环对比，假设第一位是已排序好的

            int temp = nums[i];//记录当前的数值


            for (j = i-1 ; j >=0 && nums[j]>temp ; j--){
                nums[j+1] = nums[j];//先把符合条件的数不断得往后一位复制
            }

            // 这里要 j+1 ，是因为上面j--，
            if (nums[j+1] != temp)
                nums[j+1] = temp;//把当前的数值插入到 j循环从前面已排序号的数字找到的最后一个比temp还要大的数值的位置
        }

        return nums;
    }

    private static int[] sort3(int[] nums){
        int j;

        for (int i = 1; i < nums.length; i++) {

            int temp = nums[i];

            for (j = i; j >0 && nums[j-1] > temp  ; j--) {
                nums[j] = nums[j-1];
            }

            nums[j] = temp;
        }

        return nums;
    }
}
