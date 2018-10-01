package com.my.app.myleetcodeproject.Model;

/**
 * @description: 树节点类
 * @author: ouyangxin
 * @date: 2018-10-01 12:40
 * @version: 1.0
 */

public  class TreeNode {
    public int val;
    public String name;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public TreeNode(String name) {
        this.name = name;
    }
}