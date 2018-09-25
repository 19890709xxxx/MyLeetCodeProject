package com.my.app.myleetcodeproject;

/**
 * @description: 66. Plus One 加一
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-09-23 21:46
 * @version: 1.0
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */

public class _66_PlusOne {

    public static void main(String[] args) {
        for (int i : plusOne(new int[]{9}))
            System.out.println(i+"");
    }


    /*
    * 优化前  思路：从最后一位开始循环，如果最后一位是9，将最后一位变成0，将needPlusOne标记变成true，
    * 那么下一位数就要+1，
    * */

    public static int[] plusOne(int[] digits) {
        boolean needPlusOne =false;

        for (int i= digits.length-1;i>=0;i--){

            if (i == digits.length-1||needPlusOne){
                if (digits[i]==9){
                    if (i>0) {
                        digits[i] = 0;
                        needPlusOne = true;
                    }else {//如果第一位数字是9，那么就要将数组长度+1，首位变成1，后面全是0
                        digits = new int[digits.length+1];
                        digits[0]=1;
                    }
                }else {//如果最后一位不是9,最后一位直接+1后返回数组
                    digits[i] +=1;
                    return digits;
                }
            }
        }
        return digits;
    }

    //优化后 思路：实际上 i == digits.length-1||needPlusOne 这个判断是没必要的，只要循环到的数字是9，那么直接
    //+1，进位，直至下一位不用进位直接返回数组就行了，所以不需要去判断最后一位，还有创建多余的needPlusOne
    public static int[] plusOne2(int[] digits) {

        for (int i= digits.length-1;i>=0;i--){

            if (digits[i]==9){
                if (i>0) {
                    digits[i] = 0;
                }else {
                    digits = new int[digits.length+1];
                    digits[0]=1;
                }
            }else {
                digits[i] +=1;
                return digits;
            }

        }
        return digits;
    }

}
