package me.wangxhu.demo_zuochengzuo.linkedlist;

import me.wangxhu.demo_zuochengzuo.common.ListNode;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-05 09:05
 * @Email: StormWangxhu@163.com
 * @Description: 将一个单向链表按某值划分为左边小，中间相等，右边大的形式。
 * 高级解法，即不用额外的空间
 * 使用6个变量来解决
 * 牛逼！！！
 */
public class LinkListPartitionLikeHeLanFlagII {

    public ListNode listNodePartition(ListNode head, int num) {

        ListNode sH = null; //small head
        ListNode sT = null; //small tail
        ListNode eH = null; //equal head
        ListNode eT = null; //equal tail
        ListNode bH = null; //big head
        ListNode bT = null; // big tail
        ListNode next = null; //save next ListNode
        //所有的节点分进三个链表中
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < num) {
                //作为小于链表部分的头
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {//尾部向下接
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == num) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }

        //小的和相等的重新连接
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }

        //所有的重新连接
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }
}
