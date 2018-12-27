package com.my.app.myleetcodeproject;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 202. Happy Number 快乐数
 * @author: ouyangxin
 * @date: 2018-12-27 15:24
 * @version: 1.0
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例:
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */

public class _202_Happy_Number {

    public static void main(String[] args) {
        System.out.println(isHappy(7) + "");
    }

    private static List<Integer> nums = new ArrayList<>();

    public static boolean isHappy(int n) {
        if (n == 1)
            return true;

        int result = 0;

        if (!nums.contains(n))// 记录每一个结果，一旦发现有同样的数字，就会陷入死循环，那么直接返回false
            nums.add(n);
        else
            return false;

        while (n>0) {
            result += Math.pow(n % 10, 2);//取每一个位置的数字进行平方累加
            n /= 10;
        }
        return isHappy(result);
    }
}
