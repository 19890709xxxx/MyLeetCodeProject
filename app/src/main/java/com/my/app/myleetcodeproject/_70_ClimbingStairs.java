package com.my.app.myleetcodeproject;

import java.util.HashMap;

/**
 * @description: 70. Climbing Stairs 爬楼梯
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-09-26 17:18
 * @version: 1.0
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */

/*
* 这道题主要考的是动态规划的内容
* */
public class _70_ClimbingStairs {

    private static HashMap<Integer,Integer> mMap = new HashMap<>();

    public static void main(String[] args) {

        System.out.println(climbStairs(55)+"");

    }

    /*
    * 使用递归的方式实现 速度一般
    * 假设只剩下最后一步就能爬完楼梯，这时候最后一步可以分成只剩下1个阶梯，或者2个阶梯，
    * 1个阶梯的可能性其实等同于 f（n-1），同理2个阶梯的可能性等同于f（n-2）
    * 所以最后一步的所有可能性等于 f（n） = f（n-1）+f（n-2）
    * 那么，f(n-1) = f(n-2)+f(n-3).....
    * 这里一定要简历一个HashMap来储存运算得到的值当作缓存，不然如果每次都要计算，
    * 运算次数将达到2^(n-1) , 一棵满二叉树
    * */
    private static int climbStairs(int n) {
        if (n<=1)
            return 1;

        if (n == 2)
            return 2;


        if (mMap.containsKey(n)){
            return mMap.get(n);
        }

        int value = climbStairs(n-1)+climbStairs(n-2);
        mMap.put(n,value);
        return value;
    }


    /*
    * 非递归方法，是最优解
    *
    * 从递归方法可以看到f（n） = f（n-1）+f（n-2），
    * 那么也就是说，f（1）+ f（2）可以推导出f（3）
    * */

    private static int climbStairs2(int n){
        if (n<3)
            return n;

        int temp =0 , a =1, b =2;

        for (int i=3 ;i<=n;i++){//不断累加
            temp =a+b;
            a = b;
            b = temp;
        }

        return temp;
    }
}
