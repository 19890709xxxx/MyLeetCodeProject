package com.my.app.myleetcodeproject.BaseAlgorithm;

public abstract class SortBase {

    protected final static int[] nums = new int[]{2,5,2,1,4,6,3,8,44,9,6,23,32};

    public SortBase() {
    }

    public static void main(String[] args) {

        SortBase sortBase = new SortBase() {
            @Override
            protected int[] sort() {
                return new int[0];
            }
        };

//        int[] array = sort(nums);


    }


    protected abstract int[] sort();


}
