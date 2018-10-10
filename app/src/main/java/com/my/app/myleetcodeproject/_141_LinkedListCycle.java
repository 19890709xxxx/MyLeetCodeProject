package com.my.app.myleetcodeproject;

import com.my.app.myleetcodeproject.Model.ListNode;

/**
 * @description: 141. Linked List Cycle 环形链表
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-10-10 18:49
 * @version: 1.0
 *
 * 给定一个链表，判断链表中是否有环。
 */

public class _141_LinkedListCycle {

    public static void main(String[] args) {

    }

    /*
    * 这道题是快慢指针的经典应用。只需要设两个指针，一个每次走一步的慢指针和一个每次走两步的快指针，
    * 如果链表里有环的话，两个指针最终肯定会相遇
    * */
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next ==null)
            return false;

        ListNode fast = head;
        ListNode slow = head;

        while(fast.next !=null&&fast.next.next!=null){

            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow )
                return true;
        }


        return false;
    }
}
