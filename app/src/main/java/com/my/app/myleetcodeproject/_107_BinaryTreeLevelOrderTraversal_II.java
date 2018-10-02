package com.my.app.myleetcodeproject;

import com.my.app.myleetcodeproject.Model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 107. Binary Tree Level Order Traversal II 二叉树的层次遍历 II
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-10-02 22:33
 * @version: 1.0
 * <p>
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */

public class _107_BinaryTreeLevelOrderTraversal_II {

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

        for (List<Integer> list : levelOrderBottom(a)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : list){
                stringBuilder.append(i+",");
            }
            System.out.println(stringBuilder.toString());
        }
    }

    /**
     * 这道题考的是广度优先遍历 ，但是在细节上，在同一层的节点上，这里是一次性全部offer入队列
     */
    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();// 获取队列的长度，然后在后面的循环中，一次性把节点全部都offer入队列
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i<size;i++){

                TreeNode treeNode = queue.poll();//弹出循环到的当前节点，并把节点值加入链表 level，这里可以获得这一层所有节点
                level.add(treeNode.val);

                if (treeNode.left !=null)//接下来把所有子节点都入队列，为遍历下一层的节点做准备
                    queue.offer(treeNode.left);

                if (treeNode.right !=null)
                    queue.offer(treeNode.right);

            }

            lists.add(0,level);//直接插入到首位，实现反转

        }

        return lists;
    }
}
