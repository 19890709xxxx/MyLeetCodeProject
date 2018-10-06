package com.my.app.myleetcodeproject;

import com.my.app.myleetcodeproject.Model.TreeNode;

/**
 * @description: 111. Minimum Depth of Binary Tree 二叉树的最小深度
 * @author: ouyangxin
 * @date: 2018-10-06 23:08
 * @version: 1.0
 */

public class _111_MinimumDepthofBinaryTree {

    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        int leftH  = minDepth(root.left);
        int rightH  = minDepth(root.right);

        if(leftH == 0 || rightH == 0)//如果有一个节点没有孩子节点，那么就加上同一层的右节点的深度，再加上根节点
            return leftH + rightH + 1;
        else
            return Math.min(leftH,rightH) + 1;
    }
}
