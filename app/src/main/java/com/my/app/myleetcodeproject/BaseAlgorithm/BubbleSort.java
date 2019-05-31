package com.my.app.myleetcodeproject.BaseAlgorithm;

/**
 * @description: 冒泡排序
 * @author: ouyangxin
 * @date: 2018-09-19 00:38
 * @version: 1.0
 */

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 0, 9, 3, 12, 7, 8, 3, 4, 65, 22};

        BubbleSort.bubbleSort1(arr);

        for (int i : arr) {
            System.out.print(i + ",");
        }
    }


    public static void bubbleSort1(int[] a) {
        int i, j;

        for (i = 0; i < a.length; i++) {//表示n次排序过程。
            for (j = 1; j < a.length - i; j++) {//n-i 代表前面完成排序的就不再进行循环
                if (a[j - 1] > a[j]) {//前面的数字大于后面的数字就交换
                    //交换a[j-1]和a[j]
                    int temp;
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }


    /*
     *下面开始考虑优化，如果对于一个本身有序的序列，或则序列后面一大部分都是有序的序列，
     * 上面的算法就会浪费很多的时间开销，这里设置一个标志flag，如果这一趟发生了交换，则为true
     * ，否则为false。明显如果有一趟没有发生交换，说明排序已经完成。
     *
     * 设置一个标志，如果这一趟发生了交换，则为true，否则为false。明显如果有一趟没有发生交换，说明排序已经完成。
     *
     * @param a
     * @param n
     */
    public static void bubbleSort2(int[] a, int n) {
        int j, k = n;
        boolean flag = true;//发生了交换就为true, 没发生就为false，第一次判断时必须标志位true。
        while (flag) {
            flag = false;//每次开始排序前，都设置flag为未排序过
            for (j = 1; j < k; j++) {
                if (a[j - 1] > a[j]) {//前面的数字大于后面的数字就交换
                    //交换a[j-1]和a[j]
                    int temp;
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;

                    //表示交换过数据;
                    flag = true;
                }
            }
            k--;//减小一次排序的尾边界
        }
    }

    /*
    * 再进一步做优化。比如，现在有一个包含1000个数的数组，仅前面100个无序，后面900个都已排好序且都大于前面100个数字，
    * 那么在第一趟遍历后，最后发生交换的位置必定小于100 ，且这个位置之后的数据必定已经有序了，
    * 也就是这个位置以后的数据不需要再排序了，于是记录下这位置，第二次只要从数组头部遍历到这个位置就可以了。
    * 如果是对于上面的冒泡排序算法2来说，虽然也只排序100次，但是前面的100次排序每次都要对后面的900个数据进行比较，
    * 而对于现在的排序算法3，只需要有一次比较后面的900个数据，之后就会设置尾边界，保证后面的900个数据不再被排序。
    * */
    public static void bubbleSort3(int[] a, int n) {
        int j, k;
        int flag = n;//flag来记录最后交换的位置，也就是排序的尾边界

        while (flag > 0) {//排序未结束标志
            k = flag; //k 来记录遍历的尾边界
            flag = 0;

            for (j = 1; j < k; j++) {
                if (a[j - 1] > a[j]) {//前面的数字大于后面的数字就交换
                    //交换a[j-1]和a[j]
                    int temp;
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;

                    //表示交换过数据;
                    flag = j;//记录最新的尾边界.
                }
            }
        }
    }
}
