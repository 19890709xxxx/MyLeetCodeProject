package com.my.app.myleetcodeproject;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 119. Pascal's Triangle II 杨辉三角 II
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-10-07 18:22
 * @version: 1.0
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 */

public class _119_PascalTriangle2 {

    public static void main(String[] args) {

        for (int i : getRow(3))
            System.out.println(i + ",");
    }

    public static List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> temp = new ArrayList<>();

        for (int i = 1; i <= rowIndex; i++) {// 按照输入的数字进行对应次数的循环，创造每一层的数组
            List<Integer> integers = new ArrayList<>();
            integers.add(1);//第一位固定是1
            for (int j = 2; j <= i; j++) {//从第二位开始循环添加，j <= i , 因为每一层最多有 i 个数字
                if (j > temp.size())//最后一位固定是1
                    integers.add(1);
                else {
                    integers.add(temp.get(j - 2) + temp.get(j - 1));// 对应的数字为上一组数字对应位置的和
                }
            }
            temp = integers;
        }
        return temp;
    }
}
