package com.my.app.myleetcodeproject;

/**
 * @description: 69. Sqrt(x) x 的平方根
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-09-25 23:15
 * @version: 1.0
 * <p>
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */

public class _69_Sqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395600));
    }

    /*
    * 系统方法实现，速度一般
    * */
    public static int mySqrt(int x) {
        return ((Double) Math.sqrt(x)).intValue();
    }

    /*
    * 牛顿迭代法，速度慢过系统方法，
    * 原理是不断用(x,f(x))的切线来逼近方程x^2-a=0的根。根号a实际上就是x^2-a=0的一个正实根，这个函数的导数是2x。也就是说，函数上任一点
    * (x,f(x))处的切线斜率是2x
    * 那么x-f(x)/(2x)就是一个比x更接近的近似值。代入 f(x)=x^2-a得到x-(x^2-a)/(2x)，也就是(x+a/x)/2。
    * */
    public int mySqrt2(int x) {
        long r = ((Integer) x).longValue();
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }

    /*
    * 二分法实现 ：在一个区间中，每次拿中间数的平方来试验，如果大了，就再试左区间的中间数；如果小了，就再拿右区间的中间数来试。比如求sqrt(16)
    * 的结果，你先试（0+16）/2=8，8*8=64，64比16大，然后就向左移，试（0+8）/2=4，4*4=16刚好，你得到了正确的结果sqrt(16)=4
    * */
    public int mySqrt3(int x) {
        if (x == 0) {
            return 0;
        }

        if (x == 1) {
            return 1;
        }

        int left = 0;
        int right = x;

        /*二分查找*/
        while (left != right) {
            int tmp = (left + right) / 2;
            if (tmp <= x / tmp) {
                left = tmp + 1;
            } else {
                right = tmp;
            }
        }
        return left - 1;
    }

    /*

    延伸： 雷神之锤求平方根倒数 惊人方法，C语言实现，0x5f3759df 神奇数字

    float InvSqrt (float x)
    {
        float xhalf = 0.5f*x;
        int i = *(int*)&x;
        i = 0x5f3759df - (i>>1);
        x = *(float*)&i;
        x = x*(1.5f - xhalf*x*x);
        return x;
    }


    */
}
