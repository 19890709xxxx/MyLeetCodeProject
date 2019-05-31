package com.my.app.myleetcodeproject.DataStructure;

import com.my.app.myleetcodeproject.Model.ListNode;

public class MyQueue {

    private ListNode first;
    private ListNode last;

    private int count;


    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return count;
    }

    //从队列尾部加入item
    public void enqueue(int item){
        ListNode oldLast = last;
        last = new ListNode(item);
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;

        count++;
    }

    //从头部删除item
    public int dequeue(){

        int item = first.val;
        first = first.next;

        if (isEmpty())
            last = null;

        count--;
        return item;

    }
}
