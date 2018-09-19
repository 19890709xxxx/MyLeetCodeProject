package com.my.app.myleetcodeproject;

/**
 * @description: 实现strStr()
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-09-19 14:40
 * @version: 1.0
 * <p>
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */

public class _28_ImplementstrStr {

    public static void main(String[] args) {
        System.out.println(strStr("ssssda", "da"));
    }

    private static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;

        return haystack.indexOf(needle);
    }

    /*
    * 这道题十分的简单，为什么会这么简单呢？是因为Java已经为我们提供了indexOf的方法
    * 所以我们才能在瞬间就解决问题，如果规定我们不能用indexOf怎么办？
    * 所以我们还是得知道indexOf的原理是什么，这样才有助于学习，
    * 下面是indexOf方法的源码
    *
    * */
    private static int indexOf(String source,
                               String target,
                               int fromIndex) {
        final int sourceLength = source.length();//获取源字符串的长度
        final int targetLength = target.length();//获取要匹配的目标字符串的长度
        if (fromIndex >= sourceLength) {//这里可以选择匹配字符串的开始位置，我们上面调用的indexOf方法fromIndex默认为0
            //如果起始位置大于或等于源字符串长度，如果目标字符串长度为0，返回源字符串的长度，否则返回-1
            return (targetLength == 0 ? sourceLength : -1);
        }
        if (fromIndex < 0) {//纠正fromIndex的输入值，不能小于0
            fromIndex = 0;
        }
        if (targetLength == 0) {//如果目标字符串为空，返回fromIndex
            return fromIndex;
        }

        char first = target.charAt(0);//获取目标字符串的首个字符
        int max = (sourceLength - targetLength);//获取源字符串和目标字符串的长度差距，因为目标字符串整体和源字符串进行匹配的次数，最多也就是max

        for (int i = fromIndex; i <= max; i++) {//不断进行循环寻找
            /* Look for first character. */
            if (source.charAt(i) != first) {//如果源字符串的首个字符和目标字符串的首个字符不相等
                //不断进行循环，判断源字符串的下一个字符和目标字符串的首个字符是否相等，注意++i，这里是i加1后再进行逻辑判断
                //这里直到找到首个相同字符才会退出循环，这时的i就是相同字符的起始位置，这个循环相当巧妙！
                while (++i <= max && source.charAt(i) != first) ;
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {//首个字符已经匹配到，这时候开始匹配剩下的字符
                //j是源字符串第二字符匹配的起始位置
                int j = i + 1;
                //匹配结束的位置 end，这里有同学可能会说，end为什么不是源字符串的长度呢？因为在匹配到首字符后，要匹配目标字符串剩下的长度就可以了
                //所以长度就是 j + targetLength - 1
                int end = j + targetLength - 1;
                //k = 1 ————从下标1开始循环，因为第一个字符已经匹配到了，这个k是用于目标字符串的循环取值
                //j < end && source.charAt(j) == target.charAt(k) ———— 如果j<end,如果相同位置的字符相同，就符合条件，不断循环
                //j++, k++ ， 源字符下标j 和 目标字符串下标k 在条件成立的情况下不断加1进行遍历
                for (int k = 1; j < end && source.charAt(j) == target.charAt(k); j++, k++) ;

                //在上面的循环结束后，如果源字符串的下标j 刚刚好走到了end ，那就说明目标字符串 和源字符串匹配成功，直接返回i这个起始位置
                if (j == end) {
                    /* Found whole string. */
                    return i;
                }
            }
        }
        return -1;
    }
}
