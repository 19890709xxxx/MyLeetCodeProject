package com.my.app.myleetcodeproject;

/**
 * @description: 83. Remove Duplicates from Sorted List 删除排序链表中的重复元素
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-09-27 11:47
 * @version: 1.0
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */

public class _83_RemoveDuplicatesfromSortedList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        listNode.next =listNode1;
        listNode1.next =listNode2;
        listNode2.next= listNode3;

        ListNode result = deleteDuplicates(listNode);

        while (result!=null){
            System.out.println(result.val+"");
            result = result.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {

        if(head ==null||head.next == null)
            return head;

        ListNode listNode = head;//新建一个临时链表指向 head

        while (head.next!=null){//对head进行遍历,这里判断head.next!=null 才进行遍历，如果head.next==null，则表示已经到达最后一位了，无需再进行遍历

            if (head.val == head.next.val)//如果相邻两个值相等，就把链表下一个对象删除，替换成下下个对象
                head.next =head.next.next;
            else
                head =head.next;//不相等就把head指向下一个对象，继续循环
        }

        return listNode;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
