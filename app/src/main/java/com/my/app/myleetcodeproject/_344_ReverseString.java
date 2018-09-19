package com.my.app.myleetcodeproject;

/**
 * @description: 反转字符串
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-09-19 10:15
 * @version: 1.0
 * 编写一个函数，其作用是将输入的字符串反转过来。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "olleh"
 * 示例 2:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: "amanaP :lanac a ,nalp a ,nam A"
 */

public class _344_ReverseString {

    public static void main(String[] args) {
        System.out.println();
    }

    public static String reverseString(String s) {
         /*
         运行速度快慢 StringBuilder > StringBuffer > String
        在线程安全上，StringBuilder是线程不安全的，而StringBuffer是线程安全的
        如果一个StringBuffer对象在字符串缓冲区被多个线程使用时，StringBuffer中很多方法可以带有synchronized
        关键字，所以可以保证线程是安全的，但StringBuilder
        的方法则没有该关键字，所以不能保证线程安全，有可能会出现一些错误的操作。所以如果要进行的操作是多线程的，
        那么就要使用StringBuffer
        ，但是在单线程的情况下，还是建议使用速度比较快的StringBuilder
        */
        StringBuilder stringBuilder = new StringBuilder();

        char[] array = s.toCharArray();

        for (int i = array.length - 1; i >= 0; i--) {
            Character character = array[i];
            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }

    //LeetCode 运算速度最快的方法
    public static String reverseString2(String s) {
        int i, j;
        char temp;
        char[] strArr = s.toCharArray();
        i = 0;
        j = s.length() - 1;
        while (i < j) {//双向同时向中间扫描
            if (strArr[i] != strArr[j]) {//遇到相同的字符不操作，不相同的字符进行对换
                temp = strArr[j];
                strArr[j] = strArr[i];
                strArr[i] = temp;
            }

            i++;//i++ ，j-- ，使循环不断向中间靠拢
            j--;
        }
        return new String(strArr);
    }
}
