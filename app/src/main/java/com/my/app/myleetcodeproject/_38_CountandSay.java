package com.my.app.myleetcodeproject;

import android.support.annotation.NonNull;

/**
 * @description: 38. Count and Say 报数
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-09-19 17:38
 * @version: 1.0
 *
 * 报数序列是指一个整照其中的整数的顺序进数序列，按行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 */

/*这里根据第五个数 111221 可以推出第六个数是 312211 */

public class _38_CountandSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(6));


    }

    public static String countAndSay(int n) {

        if (n==1)
            return n+"";

        String temp =1+"";

        for (int j =1;j<n;j++){
            temp=getString(temp);//循环递归输出
        }
        return temp;

    }

    @NonNull
    private static String getString(String s) {

        if (s.length() ==1)
            return "1"+s;

        char[] chars = s.toCharArray();

        int count = 1;

        StringBuilder stringBuilder = new StringBuilder();

        for (int i =1;i<s.length();i++){
            if (chars[i-1] == chars[i]){//如果相邻的字符相等，那么计数加1，这里是在统计相同字符的出现次数
                count++;
            }else {
                stringBuilder.append(count).append(chars[i-1]);//如果不相等，那么输出前一个数字统计的结果，并把count重置
                count =1;
            }
            if (i==s.length()-1)//如果循环已经走到最后一位，这里要输出最后的字符
                stringBuilder.append(count).append(chars[i]);
        }

        return stringBuilder.toString();
    }
}
