package com.my.app.myleetcodeproject;

/**
 * @description: 最长公共前缀
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-08-20 18:28
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */

public class _14_LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"abab", "aba", "ab"}));
    }

    private static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0)//如果数组为空 或者 数组长度等于0 ，返回空字符串
            return "";

        if (strs.length == 1)//如果数组长度等于1，那么公共前缀就是它自己
            return strs[0];

        String firstString = strs[0]; //获取数组第一个字符串作为参照物

        int index = 1;//记录存在相同前缀的下标走势，由于数组第一个字符串被当作参照物，index初始值从1开始

        /*倒序循环截取 firstString ，这里为什么要用倒序，而不用顺序？
        * 因为使用倒序循环，一旦出现第一个符合逻辑的公共前缀，那么这个前缀就是最长前缀，
        * 如果使用顺序循环，那么出现第一个公共前缀后，还要再进行下一次计算，验证是不是最长公共前缀，
        * 所以使用倒序循环可以减少多一次运算，提高运算速度
        * */
        for (int i = firstString.length(); i > 0; i--) {

            String temp = firstString.substring(0, i);//截取数组第一个字符串，与数组里剩下的字符串进行前缀匹配

            for (int j = 1; j < strs.length; j++) {//循环数组剩下的字符串

                String s = strs[j];

                if (s.length() < i) {//当数组里循环到的字符串长度小于temp，那么temp不可能是公共前缀，index重新初始化，退出循环，减少不必要的计算
                    index = 1;
                    break;
                }

                if (s.startsWith(temp)) {//当s 开头前缀等于temp

                    if (index == strs.length - 1) //当index下标等于数组最后一个字符串的下标，说明，temp是最长公共前缀
                        return temp;
                    else
                        index++;//index 还没走到最后一个字符串，说明后面还有字符串要跟temp进行对比，所以这里加1，走向下一个字符串

                } else {//s开头前缀不是temp，index重新初始化，跳出循环，减少不必要的计算
                    index = 1;
                    break;
                }
            }

        }


        return "";
    }

}

