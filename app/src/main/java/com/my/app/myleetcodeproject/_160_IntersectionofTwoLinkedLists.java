package com.my.app.myleetcodeproject;

import com.my.app.myleetcodeproject.Model.ListNode;

/**
 * @description: 160. Intersection of Two Linked Lists 相交链表
 * @author: ouyangxin
 * @date: 2018-10-14 22:39
 * @version: 1.0
 * <p>
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * <p>
 * <p>
 * 例如，下面的两个链表：
 * <p>
 *
 *  A:     a1 → a2
 *                      ↘
 *                        c1 → c2 → c3
 *                      ↗
 *  B:     b1 → b2 → b3
 *
 * 在节点 c1 开始相交。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */

public class _160_IntersectionofTwoLinkedLists {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(10);
        ListNode listNode2 = new ListNode(18);
        ListNode listNode3 = new ListNode(30);
        listNode.next =listNode1;
        listNode1.next =listNode2;
        listNode2.next= listNode3;


        ListNode listNode11 = new ListNode(4);
        ListNode listNode12 = new ListNode(16);

        listNode11.next =listNode12;
        listNode12.next =listNode2;

        ListNode result = getIntersectionNode(listNode,listNode11);

        if (result != null)
            System.out.println(result.val+"");
        else
            System.out.println("没有相交点");
    }

    //实际上这是最巧妙的解法，但是我还没理解，以后理解了再来说说原理
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null)
            return null;

        if (headA == headB)
            return headA;

        ListNode a = headA;
        ListNode b = headB;

        while( a != b){

            a = a == null? headB : a.next;
            b = b == null? headA : b.next;

        }

        return a;
    }


}
