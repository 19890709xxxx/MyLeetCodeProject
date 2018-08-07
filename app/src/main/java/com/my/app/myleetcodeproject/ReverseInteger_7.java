package com.my.app.myleetcodeproject;

/**
 * @description: 反转整数
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 * <p>
 *     int范围 -2147483648~2147483647
 * psvm  sout
 */

public class ReverseInteger_7 {

    public static void main(String[] args) {
        reverse(1321543354);
    }

    private static int reverse(int x){

        int rev =0;

        while (x !=0){

            int pop = x % 10; // 拿到个位数

            x /= 10; //降低一个单位

            //如果 rev 大于  Integer.MAX_VALUE / 10 溢出，如果 rev 等于 Integer.MAX_VALUE / 10 ，各位数大于整型最大数个位数 7
            if (rev > Integer.MAX_VALUE / 10 || (rev  == Integer.MAX_VALUE/10 && pop >7) ) return 0;

            //如果 rev 小于  Integer.MIN_VALUE / 10 溢出，如果 rev 等于 Integer.MIN_VALUE / 10 ，各位数小于整型最小数个位数 -8
            if (rev < Integer.MIN_VALUE /10 ||(rev == Integer.MIN_VALUE && pop< -8)) return 0;

            //rev 升高一个单位，加上尾数
            rev = rev * 10 + pop;

            System.out.println(rev + "");

        }

        return rev;

    }

}
