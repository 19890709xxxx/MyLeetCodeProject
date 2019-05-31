package com.my.app.myleetcodeproject;

public class MainActivity  {

    public static void main(String[] args) {

        int numbers[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(moreThanHalfNum(numbers));
    }

    public static int moreThanHalfNum(int[] a) {
        // 输入校验
        if (a == null || a.length < 1) {
            throw new IllegalArgumentException("无效的数组");
        }
        // 用于记录出现次数大于数组一半的数
        int temp = a[0];
        // 于当前记录的数不同的数的个数
        int count = 1;
        // 从第二个数开始向后找
        for (int i = 1; i < a.length; i++) {
            // 如果记数为0
            if (count == 0) {
                // 重新记录一个数，假设它是出现次数大于数组一半的
                temp = a[i];
                // 记录统计值
                count = 1;
            }
            // 如果记录的值与统计值相等，记数值增加
            else if (temp == a[i]) {
                count++;
            }
            // 如果不相同就减少，相互抵消
            else {
                count--;
            }
        }
        // 最后的temp可能是出现次数大于数组一半长度的值
        // 统计temp的出现次数
        count = 0;
        for (int number : a) {
            if (temp == number) {
                count++;
            }
        }
        // 如果出现次数大于数组的一半就返回对应的值
        if (count > a.length / 2) {
            return temp;
        }
        // 否则输入异常
        else {
            throw new IllegalArgumentException("无效的数组");
        }
    }
}
