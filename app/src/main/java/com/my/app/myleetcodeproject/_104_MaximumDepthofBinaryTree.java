package com.my.app.myleetcodeproject;

import com.my.app.myleetcodeproject.Model.TreeNode;

/**
 * @description: 104. Maximum Depth of Binary Tree 二叉树的最大深度
 * @author: ouyangxin
 * @date: 2018-10-02 19:00
 * @version: 1.0
 */

public class _104_MaximumDepthofBinaryTree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        TreeNode d = new TreeNode("D");
        TreeNode e = new TreeNode("E");
        TreeNode f = new TreeNode("F");
        TreeNode g = new TreeNode("G");
        TreeNode h = new TreeNode("H");
        TreeNode i = new TreeNode("I");

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = f;

        f.left = e;

        c.left = g;
        c.right = i;

        g.right = h;

        System.out.println(maxDepth(a) + "");

    }

    /**
     * 当二叉树是null时，最大深度就为0
     * 当二叉树只有根节点时，最大深度为1
     * 当二叉树有根节点还有其他子节点时候，最大深度为左、右子树深度较大一边的深度加上 1（加上节点）
     *
     * 这道题 就是考 深度优先遍历
     */
    private static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = maxDepth(root.left) + 1;

        int right = maxDepth(root.right) + 1;

        return left > right ? left : right;

    }
}
