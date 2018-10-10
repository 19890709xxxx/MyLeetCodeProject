package com.my.app.myleetcodeproject;

import java.util.Arrays;

/**
 * @description: 125. Valid Palindrome 验证回文串
 * @author: ouyangxin
 * @date: 2018-10-10 15:24
 * @version: 1.0
 */

public class _125_Valid_Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    /*
    *   解题思路：
        回文串：就是从左边数到右边，和从右边数到左边是一样的。
        比如：ama
        题目中说只考虑字母和数字字符,不分大小写

        abcdefghijklmnopqrstuvwxyz   97~122 小写字母
        ABCDEFGHIJKLMNOPQRSTUVWXYZ   65~90 大写字母
        0123456789                   48~57 数字

        以下优化前的算法
    */
    public static boolean isPalindrome(String s) {
        if (s ==null || "".equals(s))
            return true;

        int length = s.length();
        int fromStart =0;//定义两个指针，从头到尾，还有从尾到头扫描数组
        int fromEnd =length-1;

        char[] chars = s.toCharArray();
        char[] reverse = new char[length];//建立两个char数组，reverse是把后面扫描到到字符从下标0开始插入
        char[] normal = new char[length];// normal是把从头到尾扫描到到字符从下标0开始插入，最后比较两个数组是否一样

        int normalIndex =0;
        int reverseIndex =0;

        while (fromStart<length){
            char cStart = chars[fromStart];
            char cEnd =chars[fromEnd];

            char tempStart = executeChar(cStart);
            char tempEnd = executeChar(cEnd);

            if (tempEnd>0)//只有复合规定的字符才可以插入到数组
                reverse[reverseIndex++] = tempEnd;
            if (tempStart>0)
                normal[normalIndex++] = tempStart;

            fromStart++;
            fromEnd--;
        }

        return  Arrays.equals(reverse,normal);//最后对比两个数组是不是一样
    }

    /**
     * 判断字符是不是有效字符
     * @param c 目标字符
     */
    private static char executeChar(char c){

        if (c >='A' && c <='Z')
            return c +=32;

        if (c >= 'a' && c<='c')
            return c;

        if (c>='0' && c<='9')
            return c;

        return 0;
    }

    /*
    * 优化后的思路：
    * 1. 同样是定义两个指针，不过不同的是，这两个指针是同时向中间扫描
    * 2. 对应扫描遇到无效字符，就跳过这个字符，对应的指针加1，跳出循环不执行余下的逻辑后继续循环扫描，直到扫描有效字符
    * 3. 判断扫描到有效字符的指针，要等待还没扫描到有效字符的指针完成扫描有效字符的操作，就是第二步 continue 的作用
    * 4. 对比两个有效字符是否相等，不相等直接返回false，相等继续扫描，左右指针都加1
    * */

    public static boolean isPalindrome2(String s) {
        int left =0;
        int right = s.length()-1;
        char[] chars = s.toCharArray();

        while (left<right){
            char leftChar = executeChar(chars[left]);
            char rightChar = executeChar(chars[right]);
            if (leftChar==0){
                left++;
                continue;
            }else if (rightChar ==0){
                right--;
                continue;
            }else {
                if (leftChar == rightChar){
                    right--;
                    left++;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

}
