package com.my.app.myleetcodeproject;

/**
 * @description: 171. Excel Sheet Column Number Excel表列序号
 * @author: ouyangxin
 * @date: 2018-11-02 18:35
 * @version: 1.0
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1:
 * <p>
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: "ZY"
 * 输出: 701
 */

public class _171_ExcelSheetColumnNumber {

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY")+"");
    }

    /**
     * 就是26进制转10进制的问题
     */
    public static int titleToNumber(String s) {
        char[] chars = s.toCharArray();

        int total =0;

        for (int i =0; i< s.length();i++){
            if (i < s.length()-1) {
                /**
                 * 1 、chars[i] - 'A' + 1 得出两个char值之间的差值
                 * 2 、Math.pow(26,s.length()-i-1) 求26在对应位置求幂，如100，百位是10的2次方
                 * 3 、累加起来，就可以得到十进制的值
                 * */
                total += (chars[i] - 'A' + 1) *  Math.pow(26,s.length()-i-1);
            }else {
                total += chars[i] - 'A' + 1;
            }
        }

        return total;
    }

}
