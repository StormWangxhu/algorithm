package me.wangxhu.leedcode.linkedlist;

import me.wangxhu.leedcode.dfs.ListNode;

/**
 * <p>Created on 18-12-3</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * <p>
 * leetcode19 : 删除链表的倒数第n个节点
 * <p>
 * 难度级别: 中等
 * <p>
 * <p>
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
public class Question19 {

    static class Solution {

        public ListNode removeNthFromEnd(ListNode head, int n) {

            if (head == null || n < 1) {
                return head;
            }

            ListNode cur = head;
            while (cur != null) {
                n--;
                cur = cur.next;
            }
            if (n == 0) {
                head = head.next;
            }
            if (n < 0) {
                cur = head;
                while (++n != 0) {
                    cur = cur.next;
                }
                cur.next = cur.next.next;
            }
            return head;
        }
    }
}
