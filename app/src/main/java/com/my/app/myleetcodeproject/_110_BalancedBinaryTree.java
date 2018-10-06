package com.my.app.myleetcodeproject;

import com.my.app.myleetcodeproject.Model.TreeNode;

/**
 * @description: 110. Balanced Binary Tree 平衡二叉树
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-10-05 20:21
 * @version: 1.0
 * <p>
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 *      3
 *     / \
 *    9  20
 *   /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * 返回 false 。
 */

public class _110_BalancedBinaryTree {

    public static void main(String[] args) {

    }


    /*
    * 思路 ： 既然左右两个子树的高度差的绝对值不超过1，那么我们就遍历找出左右子树的最大高度，如果高度差一直都没有超过1，就是平衡二叉树
    * */
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        int left = maxDepth(root.left);

        int right = maxDepth(root.right);

        if(Math.abs(left - right)>1)
            return false;
        else
            return isBalanced(root.left)&&isBalanced(root.right);
    }

    private static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = maxDepth(root.left) + 1;

        int right = maxDepth(root.right) + 1;

        return left > right ? left : right;

    }
}
