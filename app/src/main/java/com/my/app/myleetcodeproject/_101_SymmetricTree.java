package com.my.app.myleetcodeproject;

import com.my.app.myleetcodeproject.Model.TreeNode;

/**
 * @description: 101. Symmetric Tree 对称二叉树
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-10-01 17:36
 * @version: 1.0
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 */

public class _101_SymmetricTree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(3);

        a.left = b;
        a.right = d;

        b.right = c;
        d.right = e;

        isSymmetric(a);
    }

    /*
    * 思路：1. 判断根结点是否相等
    *      2. 左子结点和右子结点是否相等即可
    * */
    private static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return isSymmetricChild(root.left,root.right);
    }

    private static boolean isSymmetricChild(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;

        if (left ==null || right ==null)
            return false;

        return left.val == right.val && isSymmetricChild(left.left,right.right)&& isSymmetricChild(left.right,right.left);
    }

}
