package me.wangxhu.leedcode.linkedlist;

import me.wangxhu.leedcode.dfs.ListNode;

/**
 * <p>Created on 18-12-10</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode160.相交链表
 * <p>
 * 难度级别: 简单
 * <p>
 * 寻找两个相交单链表的起始节点
 */
public class Question160 {

    /**
     * 1ms
     */
    static class Solution {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            ListNode l1 = headA, l2 = headB;
            while (l1 != l2) {
                l1 = (l1 == null) ? headB : l1.next;
                l2 = (l2 == null) ? headA : l2.next;
            }
            return l1;//return l2;
        }
    }
}
