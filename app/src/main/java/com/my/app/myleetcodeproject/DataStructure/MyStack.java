package com.my.app.myleetcodeproject.DataStructure;

import com.my.app.myleetcodeproject.Model.ListNode;

public class MyStack {

    private ListNode head;

    private int count =0;


    public void push(int item){
        ListNode old = head;
        head = new ListNode(item);
        head.val =item;
        head.next = old;//在链表头部加入
        count++;
    }


    public int pop(){
        int val = head.val;
        head = head.next;//删除链表头部元素
        count--;
        return val;
    }


    public int size() {
        return count;
    }

    public ListNode getHead() {
        return head;
    }
}
