package com.my.app.myleetcodeproject;

/**
 * @description: 168.Excel Sheet Column Title Excel表列名称
 * @author: ouyangxin
 * @date: 2018-10-31 11:31
 * @version: 1.0
 */

public class _168_ExcelSheetColumnTitle {

    //这样生成字母表很不酷， 'A' 其实可以推出所有字母，'B'= 'A'+1 , 'Z' = 'A'+25 ,以后遇到char字符要注意有这种思维
    private static final char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};



    public static void main(String[] args) {

        System.out.println(convertToTitle(28));

    }

    //实际上这个就是一个26进制的问题
    public static String convertToTitle(int n) {

        StringBuilder stringBuilder = new StringBuilder();

        while (n > 0) {
            /**
             * 1. 'A' 这里起了一个初始定位的作用，后面得到的char将会转换成字母
             * 2. --n, 减去'A'占有的一位
             * 3. 对26求余，余数加上 'A'，不过注意这里得到的是字母是从后往前append的，所以最后要反转stringBuilder ，下面的String解法就
             *    不需要反转，因为它把求到的char值都放置在最前
             * */
            stringBuilder.append((char)('A' + (--n) % 26));// 'A' 这里起了一个初始定位的作用，后面得到的char将会转换成字母
            n /= 26;
        }
        return stringBuilder.reverse().toString();
    }

    public static String convertToTitle2(int n) {
        String title = "";
        while (n > 0) {
            title = String.valueOf((char)('A' + (--n) % 26)) + title;
            n /= 26;
        }
        return title;
    }
}