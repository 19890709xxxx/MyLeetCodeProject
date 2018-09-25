package com.my.app.myleetcodeproject;

/**
 * @description: 67. Add Binary 二进制求和
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-09-25 14:20
 * @version: 1.0
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */

/*
* 思路：凡是遇到这类字符串处理的伪计算问题，不能想着把字符串转成纯数字去解决问题，
* 因为输入的数字字符串长度有可能超越基本类型
* */
public class _67_AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("11","1"));
    }

    public static String addBinary(String a, String b) {

        int aL = a.length();
        int bL = b.length();


        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        char[] cChars = aL>= bL ? aChars : bChars;

        int cL =  cChars.length;

        boolean needPlusOne = false; // 进位标记，如果对应位置的和大于1，则表示运算需要进位，下一位运算+1

        int tempSum =0;//每次循环对应位置相加的和


        while (cL>0){//循环次数是最长数组的长度

            if (needPlusOne) {// 如果前面的运算发现需要进位的话，tempSum这里先加1，并把needPlusOne重新变为false
                tempSum++;
                needPlusOne =false;
            }

            /*
            * 1, char 转 int 类型 ，如何把 char ‘3’ 转为 int 3 ？
            * 如果char numChar = '3'， int num = （int）numChar ，那么只会得到'3'的ascii码 51
            * 如果要得到整型 3， 最简单的方法是直接在numChar后面减去'0'即可，int num = numChar-'0'
            * 这时num = 3
            *
            * 2, int 型的数字转换成char型的数字
            * 首先定义一个int型的变量i，将这个int型变量转换成char型变量需要加上48
            * int i = 1;char c = (char) (i+48);
            * 因为ASCLL中'0'的值是48，而声明的int变量加上48等于就是他本身对应的字符型的值
            * 所以这样就把int型转换成字符型了
            * */
            if(aL > 0)//aL 和 bL 务必要判断是否大于0，因为这里比较短的数组如果不判断有溢出的危险
                tempSum += aChars[aL-1]-'0';//tempSum 加上两个数组对应位置的值

            if (bL > 0)
                tempSum += bChars[bL-1] -'0';

            if (tempSum == 3){//如果和等于3，说明是前一次计算有进位，所以这里等于1，这一次计算和值等于2，也需要进位
                cChars[cL-1] = '1';
                needPlusOne =true;
            }else if (tempSum ==2){//如果和等于2，这里需要进位，这个位置值变为0
                cChars[cL-1] = '0';
                needPlusOne =true;
            }else {
                cChars[cL-1]=(char) (tempSum+48);//和值等于1或者0，则无需进位，直接去相加的和
                if(aL ==0 || bL==0)//如果其中一个数组已经循环完毕，这时这个位置的和值不需要进位，接下来剩下的位置无需计算，那么直接返回字符串
                    return new String(cChars);
                needPlusOne =false;
            }

            if (needPlusOne&&(cL-1)==0){//如果到达数组第0位，还要进位的话，这时候要在返回的字符串前面+1，表示进位
                return "1"+new String(cChars);
            }

            aL--;
            bL--;
            cL--;
            tempSum =0;//tempSum重新置为0，为下一轮运算做准备
        }

        return new String(cChars);
    }

}
