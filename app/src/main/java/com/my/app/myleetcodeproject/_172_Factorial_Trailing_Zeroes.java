package com.my.app.myleetcodeproject;

/**
 * @description: 172. Factorial Trailing Zeroes 阶乘后的零
 * @author: ouyangxin
 * @date: 2018-12-17 10:41
 * @version: 1.0
 * <p>
 * <p>
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 */

public class _172_Factorial_Trailing_Zeroes {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(129)+"");
    }


    /**
     *  5! = 5*4*3*2*1 = 120 一个5 一个0
     *  10! = 10 *9 ... *5 ...*1 = (5*2)*9...*5...*1  -> 两个5 ， 两个0
     *  15! = 15 *14 ... *10 ...*5 ...*1 = (5*3)*14...*(5*2)...*5 ...*1 -> 三个 5 ， 三个0
     *
     *  所以，只要计算出输入的数字里面包含多少个5 ， 就可以得出尾数有多少个0
     * */

    private static int trailingZeroes(int n) {

        int count = 0;

        while (n > 0){
                n /= 5;
                count += n;
        }

        return count;

    }
}
