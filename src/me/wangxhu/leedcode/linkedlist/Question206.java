package me.wangxhu.leedcode.linkedlist;

import me.wangxhu.leedcode.dfs.DoubleNode;
import me.wangxhu.leedcode.dfs.ListNode;

/**
 * <p>Created on 18-12-6</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode206: 反转一个单链表
 * <p>
 * 难度级别:简单
 */
public class Question206 {

    static class Solution {

        public ListNode reverseList(ListNode head) {

            if (head == null) {
                return head;
            }

            ListNode pre = null;
            ListNode next = null;

            while (head != null) {
                next = head.next;//将第二节点进行保存
                head.next = pre; //头结点指针指向前一个节点
                pre = head; //pre指针向后移
                head = next; //头结点从新定义
            }
            return pre;
        }
    }


    /**
     * 反转双向链表
     */
    static class Solution1 {

        public DoubleNode reverseList(DoubleNode head) {

            if (head == null) {
                return head;
            }

            DoubleNode pre = null;
            DoubleNode next = null;
            while (head != null) {
                next = head.next;
                head.next = pre;
                head.last = next;
                pre = head;
                head = next;
            }
            return pre;
        }
    }
}
