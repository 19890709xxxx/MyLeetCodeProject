package com.my.app.myleetcodeproject.KeyPoints;

/**
 * @description: 题目遇到的基础知识集合
 * @author: ouyangxin
 * @date: 2018-12-14 18:15
 * @version: 1.0
 */

public class Collections {

    /**
     * _21_MergeTwoSortedLists.class
     *
     * 对象的引用
     *
     *新建一个ListNode 对象 temp 指向 first，
     *这里java基础不牢固的同学可能会疑惑为什么first没进行任何的操作，那么这里first的值为什么会不断变化？
     *这里我们要知道Java的传值规则：
     *对于基础类型的赋值和传参（int，float等等），传值直接就是复制，
     *对于对象，java中没有C语言的指针概念，对象传递默认就是引用
     *
     *eg: 基础类型： int a= 9； int b = a； b =5； b赋值5后，a仍然为9，不会受到b值变化的影响
     *    对象类型： ListNode a = new ListNode(4);ListNode b  = a; b.val = 1 ,此时a.val 也会变成 1，
     *              如果ListNode c = new ListNode(40); b  = c，这时b是指向另外一个已存在的对象c，所以a对象不会受影响
     *
     **/

    /**
     *
     * _203_Remove_Linked_List_Elements
     *
     * 关于对象的引用
     * 1 如果这里赋值 cur.val = 9; 那么listNode.val 也会变成9，因为cur指向了listNode 对象，cur的值变化会导致listNode的值也出现变化
     * 2 那么问题来了，为什么cur在下面不断向后遍历，却不会影响listNode呢？
     * 因为未开始遍历的时候，cur指向的是listNode，开始遍历后，cur 指向的是cur.next 或 cur.next.next 这两个对象，此时cur与listNode已经
     * 没有关联，所以这里 ListNode cur = listNode 实际上是复制了一份listNode，然后进行了遍历
     *
     */

    /**
     *_67_AddBinary
     *
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

    /**
     * _69_Sqrt
     *
     * 牛顿迭代法，速度慢过系统方法，
     * 原理是不断用(x,f(x))的切线来逼近方程x^2-a=0的根。根号a实际上就是x^2-a=0的一个正实根，这个函数的导数是2x。也就是说，函数上任一点
     * (x,f(x))处的切线斜率是2x
     * 那么x-f(x)/(2x)就是一个比x更接近的近似值。代入 f(x)=x^2-a得到x-(x^2-a)/(2x)，也就是(x+a/x)/2。
     * */


    /**
     * _88_MergeSortedArray
     *
     * System.arraycop
     *
     * 硬拷贝数组resuly 到 num1 ，arraycopy 后两个数组内存地址不一样，引用值被拷贝了一份，
     * 而num1 =result 只是软拷贝，引用了对象的内存地址而已，两个数组内存地址是一样的
     *
     * */

    /**
     * _136_SingleNumber
     *
     * 异或的特性：
     1.恒定律：A ^ 0 = A
     2.归零率：A ^ A = 0
     3.交换律：A ^ B = B ^ A
     4.结合律：(A ^ B) ^ C = A ^ (B ^ C)

     异或可以做的事情：
     异或可以快速比较两个值是否相等 a ^ b == 0，效率非常高，比 a - b == 0 高很多。

     异或还能在不定义临时变量的情况下，交换两个值（经典题目）
     a = a ^ b
     b = a ^ b // a ^ b ^ b = a ^ 0 = a
     a = a ^ b // a ^ a ^ b = 0 ^ b = b

     好了，现在利用学习的异或知识，来分析一下这道题。
     假设所有的数组为：abcbcda
     a ^ b ^ c ^ b ^ c ^ d ^ a
     = a ^ a ^ b ^ b ^ c ^ c ^ d
     = 0 ^ 0 ^ 0 ^ d
     = d
     很神奇是不是？这个的时间复杂度为O(n)，是线性的，空间复杂度是O(1)
     * */


    /**
     * _344_ReverseString
     *
     *
     *
     * 运行速度快慢 StringBuilder > StringBuffer > String
     在线程安全上，StringBuilder是线程不安全的，而StringBuffer是线程安全的
     如果一个StringBuffer对象在字符串缓冲区被多个线程使用时，StringBuffer中很多方法可以带有synchronized
     关键字，所以可以保证线程是安全的，但StringBuilder
     的方法则没有该关键字，所以不能保证线程安全，有可能会出现一些错误的操作。所以如果要进行的操作是多线程的，
     那么就要使用StringBuffer
     ，但是在单线程的情况下，还是建议使用速度比较快的StringBuilder
     * */


    /**
     *
     *
     * _190_Reverse_Bits
     *
     0xaaaaaaaa = 10101010101010101010101010101010 (偶数位为1，奇数位为0） 尾数是0

     0x55555555 = 1010101010101010101010101010101 (偶数位为0，奇数位为1） 尾数是1

     0x33333333 = 110011001100110011001100110011 (1和0每隔两位交替出现)

     0xcccccccc = 11001100110011001100110011001100 (0和1每隔两位交替出现)

     0x0f0f0f0f = 00001111000011110000111100001111 (1和0每隔四位交替出现)

     0xf0f0f0f0 = 11110000111100001111000011110000 (0和1每隔四位交替出现)
     *
     *
     * */


    /**
     *
     * BinarySearch
     *
     * int mid =(low + high) / 2;
     * 在一般情况下, 这个语句是不会出错的, 但是, 当low+high的值超过了最大的正int值 (2^31 - 1)
     * 的时候, mid会变成负值,  这个时候, 会抛出ArrayIndexOutOfBoundsException 异常。所以当一个数组包含超过2的30次方
     * 个元素的时候, 就很可能会带来问题;当然, 在一般的应用里面, 很少数组会包含那么多元素, 但是现在这样的情况已经越来越多了,
     * 比如Google的海量运算……那如何解决这个问题？
     * 可以改为： int mid = low + ((high - low) >> 1); 或  int mid = (low + high) >>> 1;
     *
     *
     * */


}
