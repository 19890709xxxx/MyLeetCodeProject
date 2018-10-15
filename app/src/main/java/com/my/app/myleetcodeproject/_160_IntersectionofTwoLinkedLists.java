package com.my.app.myleetcodeproject;

import com.my.app.myleetcodeproject.Model.ListNode;

/**
 * @description: 160. Intersection of Two Linked Lists 相交链表
 * @author: ouyangxin
 * @date: 2018-10-14 22:39
 * @version: 1.0
 */

public class _160_IntersectionofTwoLinkedLists {

    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (isCircle(headA)&&isCircle(headB)){

        }else if (!isCircle(headA)&&isCircle(headB)){

        }else {

        }
    }

    private static boolean isCircle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

}
