package com.my.app.myleetcodeproject;

import java.util.HashMap;

/**
 * @description: 罗马数字转整数
 * 难度：简单
 * @author: ouyangxin
 * <p>
 * <p>
 * 罗马数字包含以下七种字符：I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4
 * 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 */

public class _13_RomaToInteger {

    public static void main(String[] args) {
        romaToInteger("XXXIXVX");
    }

    private static int romaToInteger(String romaNum) {

        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sumUp = 0, prev = 0;

        for (int i = 0; i < romaNum.length(); i++) {
            int current = map.get(romaNum.charAt(i));//获取当前位置罗马数字的值

            if (prev == 0)//当prev=0，这是第一位数字，和值直接加
                sumUp += current;
            else if (current > prev){
                //如果当前位置的数值大于前一位的数值，也就是上述罗马数字中小的数字在大的数字的右边特殊情况,
                //数值除了要加上current ，还要 减去 prev，而且还要减去前一位数值在上一次运算是被重复加的一次，
                //也就是说在这次运算被发现是处于特殊情况的时候，prev已经被加了两次，所以要减去
                sumUp += current - (prev * 2);
            } else
                sumUp += current;

            System.out.println("prev : " + prev + " current : " + current + " sumUp: " + sumUp);
            //prev 临时赋值 ， 进入下一次运算时，prev就是上一位的数值
            prev = current;
        }

        return sumUp;
    }
}
