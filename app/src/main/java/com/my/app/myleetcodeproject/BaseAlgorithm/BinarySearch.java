package com.my.app.myleetcodeproject.BaseAlgorithm;

/**
 * @description: 二分查找
 * @author: ouyangxin
 * @date: 2018-10-04 14:09
 * @version: 1.0
 * <p>
 * 注意⚠：二分查找是针对 排好序 的数组
 * <p>
 * 二分查找法是对一组有序的数字中进行查找，传递相应的数据，进行比较查找到与原数据相同的数据，查找到了返回对应的数组下标，没有找到返回-1；
 */

public class BinarySearch {


    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,4,5,6,8,9,10,21,23,34,45,56,67,78},0,99,9)+"");
        System.out.println(binarySearchRec(new int[]{1,4,5,6,8,9,10,21,23,34,45,56,67,78},0,99,9)+"");
    }

    /**
     * 非递归实现
     * @param a         目标数组
     * @param fromIndex 起始位置
     * @param toIndex   终止位置
     * @param value     查找目标
     */
    public static int binarySearch(int[] a, int fromIndex, int toIndex, int value) {
        if (toIndex > a.length - 1)
            toIndex = a.length - 1;

        while (fromIndex <= toIndex) {

            /*
            * int mid =(low + high) / 2;
            * 在一般情况下, 这个语句是不会出错的, 但是, 当low+high的值超过了最大的正int值 (2^31 - 1)
            * 的时候, mid会变成负值,  这个时候, 会抛出ArrayIndexOutOfBoundsException 异常。所以当一个数组包含超过2的30次方
            * 个元素的时候, 就很可能会带来问题;当然, 在一般的应用里面, 很少数组会包含那么多元素, 但是现在这样的情况已经越来越多了,
            * 比如Google的海量运算……那如何解决这个问题？
            * 可以改为： int mid = low + ((high - low) >> 1); 或  int mid = (low + high) >>> 1;
            * */
            int middle = fromIndex + ((toIndex - fromIndex) >> 1);

            if (a[middle] > value) {//如果 当前数字 大于目标值，说明目标值还在当前值的左边，要向左收敛，toIndex 要减去 1
                toIndex--;
            }else if (a[middle] < value){//如果 当前数字 小于目标值，说明目标值还在当前值的右边，要向右收敛，fromIndex 要加上 1
                fromIndex++;
            }else
                return middle; //刚好等于 就直接返回当前的middle下标
        }
        return -1;
    }

    //递归实现
    private static int binarySearchRec(int[] a, int fromIndex, int toIndex, int value){
        if (toIndex > a.length - 1)
            toIndex = a.length - 1;

        int middle = (fromIndex + toIndex) >>>1;

        if (a[middle]>value)
            return binarySearchRec(a,fromIndex,toIndex-1,value);
        else if (a[middle]<value)
            return binarySearchRec(a,fromIndex+1,toIndex,value);
        else
            return middle;

    }
}
