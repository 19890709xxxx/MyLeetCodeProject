package com.my.app.myleetcodeproject;

import java.util.HashMap;

/**
 * @description: 两数之和
 * 难度：简单
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * <p>
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */

public class _1_TwoSum {

    public static void main(String[] args) {
        int[] array = {4, 7, 65, 15};
        int[] result = twoSum(array, 19);

        String s = "";

        for (int i : result) {
            s += i + ",";
        }

        System.out.print(s);
    }

    /**
     * 时间复杂度：O(n)O(n)， 我们只遍历了包含有 nn 个元素的列表一次。在表中进行的每次查找只花费 O(1)O(1) 的时间。
     * <p>
     * 空间复杂度：O(n)O(n)， 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 nn 个元素。
     **/

    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
//            hashMap.put(nums[i], i);  // 不把 hashMap 的赋值放在这里是因为，如果放在这里，下面的if判断语句要增加 hashMap.get(result) != i ,
//                                         因为可能出现 result =   nums[i] 的情况，这样 就会返回 同一个index ，eg ： target =8 ，num[i] =4, 返回结果是【i,i】

            int result = target - nums[i];
            if (hashMap.containsKey(result))
                return new int[]{hashMap.get(result), i};

            hashMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");

    }
}
