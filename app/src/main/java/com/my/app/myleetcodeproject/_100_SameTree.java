package com.my.app.myleetcodeproject;

import com.my.app.myleetcodeproject.Model.TreeNode;

/**
 * @description: 100. Same Tree 相同的树
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-09-27 18:01
 * @version: 1.0
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * <p>
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:      1          1
 *           /            \
 *          2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * 输出: false
 * 示例 3:
 * <p>
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * 输出: false
 */

public class _100_SameTree {

    public static void main(String[] args) {

    }

    /*
    * 这道题考的是树的前序遍历（先序遍历），只要不断递归去遍历每个树节点的值，判断是否相等就可以了
    * */
    private static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p ==null && q == null)//如果两个节点一样，那么直接返回true
            return true;

        if (p == null ||q == null)//这里的判断一定要放在 p==null&& q ==null这个判断之后，因为如果放在之前，则永远无法到达 p==null&& q ==null这个判断
            return false;

        if(p.val != q.val)//如果两个节点值不同，
            return false;

        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);//接下来分别对比相同位置的节点是否相同
    }

    /*
    * leetcode 最快的算法，逻辑是一样的
    * */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        else {
            if (p.val == q.val)
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            else
                return false;
        }
    }


}
