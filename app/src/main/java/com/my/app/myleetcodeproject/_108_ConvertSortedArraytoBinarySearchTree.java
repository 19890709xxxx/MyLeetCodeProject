package com.my.app.myleetcodeproject;

import com.my.app.myleetcodeproject.Model.TreeNode;

/**
 * @description: 108. Convert Sorted Array to Binary Search Tree 将有序数组转换为二叉搜索树
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-10-03 22:50
 * @version: 1.0
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * <p>
 * <p>
 * 3层二叉搜索树
 * <p>
 * <p>
 * 二叉查找树（英语：Binary Search Tree），也称为二叉搜索树、有序二叉树（ordered binary tree）或排序二叉树（sorted binary
 * tree），是指一棵空树或者具有下列性质的二叉树：
 * <p>
 * 若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
 * 若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
 * 任意节点的左、右子树也分别为二叉查找树；
 * 没有键值相等的节点。
 * <p>
 * <p>
 * 二叉搜索树按中序遍历的话，得到的就是一个有序数组了。那么反过来，我们可以得知，根节点应该是有序数组的中间点，从中间点分开为左右两个有序数组，
 * 在分别找出其中间点作为原中间点的左右两个子节点，这不就是二分查找法的核心思想么。所以这道题考的就是二分查找法。
 */

public class _108_ConvertSortedArraytoBinarySearchTree {

    public static void main(String[] args) {

    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        return getTree(nums,0,nums.length-1);

    }

    private static TreeNode getTree(int[] nums, int start, int end) {
        if (start>end)
            return null;

        int middle = ( start + end ) >>> 1;

        TreeNode treeNode = new TreeNode(middle);//中间的数字就是根节点，然后把数组分成两半

        treeNode.left = getTree(nums,start,middle-1);//左边从起始位置开始，到 middle 的前一位 开始遍历

        treeNode.right = getTree(nums,middle+1,end);//右边从middle 的后一位，到 end 开始遍历

        return treeNode;
    }
}
