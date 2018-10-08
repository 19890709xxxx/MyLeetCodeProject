package com.my.app.myleetcodeproject;

/**
 * @description: 121. Best Time to Buy and Sell Stock 买卖股票的最佳时机
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-10-08 15:20
 * @version: 1.0
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */

public class _121_BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    /*考的是贪心算法
    * 思路： 遍历数组，获取遍历到的最小的数字，如果遍历到的数字大于前面找到的最小数字minNum，
    * 就减去minNum，获取一个临时收益tempProfit，之后一路取最大的tempProfit就可以了
    * */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int minNum = prices[0];
        int tempProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (minNum < prices[i]) {
                int cur = prices[i] - minNum;
                tempProfit = cur > tempProfit ? cur : tempProfit;
            } else {
                minNum = prices[i];
            }
        }

        return tempProfit;

    }
}
