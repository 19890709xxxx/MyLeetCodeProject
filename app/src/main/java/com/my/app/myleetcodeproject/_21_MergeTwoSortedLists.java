package com.my.app.myleetcodeproject;

import com.my.app.myleetcodeproject.Model.ListNode;

/**
 * @description: 合并两个有序链表
 * 难度：简单
 * @author: ouyangxin
 * @date: 2018-09-10 16:41
 * @version: 1.0
 * <p>
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 *
 */

public class _21_MergeTwoSortedLists {

    //这道题有两种解法，递归式的 和 非递归式的
    // 非递归式的，考的是链表的基础知识，以及 归并排序 左右半边的数按序排列后的合并操作


    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        ListNode listNode1 = new ListNode(10);
        ListNode listNode2 = new ListNode(18);
        ListNode listNode3 = new ListNode(30);
        listNode.next =listNode1;
        listNode1.next =listNode2;
        listNode2.next= listNode3;


        ListNode listNode11 = new ListNode(4);
        ListNode listNode12 = new ListNode(16);
        ListNode listNode13 = new ListNode(19);
        ListNode listNode14 = new ListNode(31);
        listNode11.next =listNode12;
        listNode12.next =listNode13;
        listNode13.next= listNode14;

        ListNode result = mergeTwoLists(listNode,listNode11);

        while (result!=null){
            System.out.println(result.val+"");
            result = result.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)//如果l1为空，直接返回l2
            return l2;
        if (l2 == null)//如果l2为空，直接返回l1
            return l1;


        ListNode first = new ListNode(0);

        /*
        *新建一个ListNode 对象 temp 指向 first，
        *这里java基础不牢固的同学可能会疑惑为什么first没进行任何的操作，那么这里first的值为什么会不断变化？
        *这里我们要知道Java的传值规则：
        *对于基础类型的赋值和传参（int，float等等），传值直接就是复制，
        *对于对象，java中没有C语言的指针概念，对象传递默认就是引用
        *
        *eg: 基础类型： int a= 9； int b = a； b =5； b赋值5后，a仍然为9，不会受到b值变化的影响
        *    对象类型： ListNode a = new ListNode(4);ListNode b  = a; b.val = 1 ,此时a.val 也会变成 1，
        *              如果ListNode c = new ListNode(40); b  = c，这时b是指向另外一个对象c，所以a对象不会受影响
        *
        **/

        ListNode temp= first ;

        while (l1!=null&&l2!=null) {
            if (l1.val <= l2.val) {//将 l1 和 l2 进行比较，谁小谁就合并到 temp，直到 l1 或者 l2 为空
                temp.next = l1;// 这里first.next 也会指向l1
                l1 = l1.next;//将l1链表往下移动一位，下面的l2是同样逻辑，注意这里l1虽然指向了l1.next,但是temp.next并没有受影响
            } else {
                temp.next = l2;
                l2 =l2.next;
            }
            /*
            * temp往后移动一位，以便在下一个循环里进行赋值，注意，虽然这里temp指向了temp.next，
            * 但是first的值没受影响
            * */
            temp = temp.next;
        }


        while (l1!=null){//如果l1还有剩余节点，把l1剩下的节点并入first
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }

        while (l2 != null){//把l2剩下的节点并入first
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }



        return first.next;


    }

    //使用递归去解决这个问题，但是递归的效率太低，一般不推荐
    public static ListNode mergeTwoListsWithRecursion(ListNode l1, ListNode l2){
        if (l1 == null)//如果l1为空，直接返回l2
            return l2;
        if (l2 == null)//如果l2为空，直接返回l1
            return l1;
        ListNode temp;

        if (l1.val < l2.val){
            temp = l1;
            temp.next = mergeTwoListsWithRecursion(l1.next,l2);
        }else {
            temp =l2;
            temp.next = mergeTwoListsWithRecursion(l1,l2.next);
        }
        return temp;
    }


}
