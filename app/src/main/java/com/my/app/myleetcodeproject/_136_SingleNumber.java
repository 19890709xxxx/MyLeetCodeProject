package com.my.app.myleetcodeproject;

/**
 * @description: 136. Single Number 只出现一次的数字
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-10-10 11:07
 * @version: 1.0.
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */

public class _136_SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{5,5,4,2,4,2,3}));
    }

    /*
    这道题可以使用异或的解法来解题
    * 异或的特性：
    1.恒定律：A ^ 0 = A
    2.归零率：A ^ A = 0
    3.交换律：A ^ B = B ^ A
    4.结合律：(A ^ B) ^ C = A ^ (B ^ C)

    异或可以做的事情：
    异或可以快速比较两个值是否相等 a ^ b == 0，效率非常高，比 a - b == 0 高很多。

    异或还能在不定义临时变量的情况下，交换两个值（经典题目）
    a = a ^ b
    b = a ^ b // a ^ b ^ b = a ^ 0 = a
    a = a ^ b // a ^ a ^ b = 0 ^ b = b

    好了，现在利用学习的异或知识，来分析一下这道题。
    假设所有的数组为：abcbcda
    a ^ b ^ c ^ b ^ c ^ d ^ a
    = a ^ a ^ b ^ b ^ c ^ c ^ d
    = 0 ^ 0 ^ 0 ^ d
    = d
    很神奇是不是？这个的时间复杂度为O(n)，是线性的，空间复杂度是O(1)
    * */
    public static int singleNumber(int[] nums) {
        if (nums == null)
            throw new IllegalArgumentException("不正确的数组");
        int result =0;

        for (int num : nums)
            result ^= num;

        return result;
    }

}
