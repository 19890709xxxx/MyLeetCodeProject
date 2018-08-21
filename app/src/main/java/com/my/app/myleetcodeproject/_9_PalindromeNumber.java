package com.my.app.myleetcodeproject;

/**
 * @description: 回文数
 * 难度：简单
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 */

public class _9_PalindromeNumber {

    public static void main(String[] args) {
        palindromeNumber(321321);
    }

    // 将数字反转对比就可以知道
    private static boolean palindromeNumber(int num){
        if(num < 0 || (num % 10 == 0 && num != 0)) {
            return false;
        }

        String numString = num+"";
        String reverseNum = "";

        for (int i = numString.length()-1;i>=0;i--)//倒转字符串
            reverseNum  += numString.charAt(i);

        if (numString.equals(reverseNum)) {
            System.out.println("palindrome Number");
            return true;
        } else {
            System.out.println("not palindrome Number");
            return false;
        }
    }

}
