package com.my.app.myleetcodeproject;

/**
 * @description: 58. Length of Last Word 最后一个单词的长度
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-09-22 21:40
 * @version: 1.0
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 */

public class _58_LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a ") + "");
    }

    /*
    * 我的思路：使用头尾两个指针，不断向字符串中间循环，找出从左到右最后一个空字符的位置，
    * 再找出从右到左第一个非空字符的位置，两个位置相减，就可以得出最后单词的长度
    * */
    public static int lengthOfLastWord(String s) {

        if (s == null || s.length() == 0)
            return 0;

        char[] chars = s.toCharArray();

        int indexEnd = chars.length - 1, indexStart = 0;

        /*
        * 这里tempPosition的初始值为什么要设置为-1？ 因为当字符串是"a "这类型的字符串时候，
        * 则tempPosition最终值就直接为初始值了，因为indexStart的循环到最后，都无法有为tempPosition赋值的条件，
        * 这时候indexEnd =0，正确答案是1，如果tempPosition =0，那么就要多一层判断来判断"a "这类型的字符串，
        * 要在indexEnd-tempPosition后加1，即indexEnd-tempPosition+1，
        * 所以直接设置初始值为-1，就可以不需要再去判断"a "这类型的字符串，如果不是这类型的字符串，
        * tempPosition在indexStart的循环里自然会被重新赋值，结果是indexEnd-tempPosition，
        * 如果是那类型的字符串，结果也是indexEnd-tempPosition，因为tempPosition =-1，无需考虑加1
        * */
        int tempPosition = -1;

        /*
        * 注意，这里要--indexEnd ，而不是indexEnd--，不然可能会造成数组溢出，
        * 第28题里indexOf源码里的while循环也是这样
        * 这里是找出从右到左第一个非空字符的位置
        * */
        while (chars[indexEnd] == ' ' && --indexEnd >= 0) ;

        /*
        * 因为已经找到了indexEnd的位置，所以循环到indexEnd就可以了
        * 当从左到右找到一个空字符，就记录下来
        * */
        while (indexStart <= indexEnd) {
            if (chars[indexStart] == ' ')
                    tempPosition = indexStart;
            indexStart++;
        }
        return indexEnd - tempPosition;
    }
}
