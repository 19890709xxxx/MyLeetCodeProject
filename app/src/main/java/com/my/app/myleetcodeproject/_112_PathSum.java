package com.my.app.myleetcodeproject;

import com.my.app.myleetcodeproject.Model.TreeNode;

/**
 * @description: 112. Path Sum 路径总和
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-10-07 17:14
 * @version: 1.0
 * <p>
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */

public class _112_PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null && sum - root.val == 0)
            //如果这个节点是叶子节点，没有左右孩子，且sum值等于节点的值，返回true
            return true;
        else
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root
                    .val);//否则一路遍历左右子树，遍历到一个节点，如果该节点不满足条件，那么就sum减去节点的值后继续遍历
    }
}
