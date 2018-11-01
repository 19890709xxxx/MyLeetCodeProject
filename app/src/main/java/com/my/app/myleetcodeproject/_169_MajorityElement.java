package com.my.app.myleetcodeproject;

/**
 * @description: 169.Majority Element 求众数
 * @author: ouyangxin
 * @date: 2018-10-31 18:16
 * @version: 1.0
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */

public class _169_MajorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,2,3,2,1,2,2})+"");
    }

    public static int majorityElement(int[] nums) {
       int count =0;
       int number = 0;

       for (int i =0;i<nums.length;i++){
           /**
            * 如果count等于0，那么有两种可能，
            * 1、刚刚开始循环，i=0的时候，这里相当于初始化number和count
            * 2、一直遇到不同于number的数字，导致count一路减1，归零，这时候这里就是重置count还有number为当前循环到的数字
            * */
            if (count == 0) {
                number = nums[i];
                count++;
            }else if (number == nums[i])//遇到相同的，count 就加1 ， 遇到不同的 count就减1
                count++;
            else
                count--;
       }

       return number;
    }
}
