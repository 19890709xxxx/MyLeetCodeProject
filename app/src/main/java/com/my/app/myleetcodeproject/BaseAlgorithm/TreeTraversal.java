package com.my.app.myleetcodeproject.BaseAlgorithm;

import com.my.app.myleetcodeproject.Model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @description: 树的遍历
 * @author: ouyangxin
 * @date: 2018-10-01 12:33
 * @version: 1.0
 *
 * 树的结构请参照 /BaseLogic/树的遍历.png
 *
 * 前序遍历 中序遍历 后序遍历 代码其实是一样的，只是处理tree的时间点不同，留意System.out.println的位置
 */

public class TreeTraversal {

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
        a.right =c;

        b.left =d;
        b.right =f;

        f.left =e;

        c.left =g;
        c.right =i;

        g.right =h;

        deepthFirstSearch(a);
    }

    //先序遍历（前序遍历）
    private static void preOrder(TreeNode tree){
        if (tree == null ) {
            return;
        }

        System.out.println(tree.name);

        preOrder(tree.left);
        preOrder(tree.right);

    }

    //中序遍历
    private static void inOrder(TreeNode tree){
        if (tree == null ) {
            return;
        }

        inOrder(tree.left);//一直遍历寻找左子树，一直到左子树为空return回来，这时候拿到第一个节点D

        System.out.println(tree.name);

        inOrder(tree.right);
    }

    //后序遍历
    private static void postOrder(TreeNode tree){

        if (tree == null ) {
            return;
        }

        postOrder(tree.left);
        postOrder(tree.right);

        System.out.println(tree.name);
    }

    //深度优先搜索,使用栈实现
    private static void deepthFirstSearch(TreeNode tree){

        Stack<TreeNode> stack = new Stack<>();

        stack.push(tree);

        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();

            if (treeNode.right!=null)
                stack.push(treeNode.right);

            if (treeNode.left!=null)//这里使用的栈，后进先出，所以要访问左子树，就应该把treeNode.left在treeNode.right之后push
                stack.push(treeNode.left);

            System.out.println(treeNode.name);
        }

    }

    //广度优先搜索，使用队列实现
    private void breadthFirstSearch(TreeNode tree){

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(tree);

        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();

            if (treeNode.left!=null)
                queue.offer(treeNode.left);

            if (treeNode.right!=null)
                queue.offer(treeNode.right);

            System.out.println(treeNode.name);
        }

    }
}
