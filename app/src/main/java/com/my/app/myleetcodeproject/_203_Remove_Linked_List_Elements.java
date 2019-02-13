package com.my.app.myleetcodeproject;

import com.my.app.myleetcodeproject.Model.ListNode;

/**
 * @description: 203.Remove Linked List Elements 移除链表元素
 * @author: ouyangxin
 * @date: 2019-01-15 15:49
 * @version: 1.0
 */

public class _203_Remove_Linked_List_Elements {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        ListNode head = new ListNode(-1);
        head.next = removeElements(listNode1, 6);
        while (head.next != null) {
            System.out.print(head.next.val + "-> ");
            head.next = head.next.next;
        }

    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode listNode = new ListNode(-1);

        listNode.next = head;

        ListNode cur = listNode;

        /**
         * 关于对象的引用
         * 1 如果这里赋值 cur.val = 9; 那么listNode.val 也会变成9，因为cur指向了listNode 对象，cur的值变化会导致listNode的值也出现变化
         * 2 那么问题来了，为什么cur在下面不断向后遍历，却不会影响listNode呢？
         * 因为未开始遍历的时候，cur指向的是listNode，开始遍历后，cur 指向的是cur.next 或 cur.next.next 这两个对象，此时cur与listNode已经
         * 没有关联，所以这里 ListNode cur = listNode 实际上是复制了一份listNode，然后进行了遍历
         *
         */

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return listNode.next;
    }

}
