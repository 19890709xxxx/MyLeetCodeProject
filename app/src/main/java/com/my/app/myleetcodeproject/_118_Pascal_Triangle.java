package com.my.app.myleetcodeproject;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 118. Pascal's Triangle 杨辉三角
 * @author: ouyangxin
 * @date: 2018-10-07 17:24
 * @version: 1.0
 */

public class _118_Pascal_Triangle {

    public static void main(String[] args) {
        for (List<Integer> list : generate(3))
            for (int i : list)
                System.out.println(i + ",");
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {// 按照输入的数字进行对应次数的循环，创造每一层的数组
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
            lists.add(integers);
        }
        return lists;
    }
}
