package me.wangxhu.nowcoder.linkedlist;

import me.wangxhu.leedcode.dfs.ListNode;

/**
 * <p>Created on 18-12-3</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * 剑指offer: 输出倒数第k个节点
 * 思路: 快慢指针思想
 * 快指针先走k-1步,然后快慢指针同时一起走,当快指针到链表末尾的时候,慢指针所指向的那个值就是第k个节点
 * <p>
 * 通俗的讲:就是制造了一把长度为k的尺子,当尺子的最右端到达链表末尾的时候,尺子头所指向的节点就是倒数第K个节点.
 */
public class FindKthToTail {

    static class Solution {

        public ListNode FindKthToTail(ListNode head, int k) {

            if (head == null) {
                return head;
            }
            if (k <= 0) {
                return null;
            }
            ListNode fast, slow;
            fast = slow = head;
            for (int i = 1; i < k; i++) {
                if (fast.next != null) {
                    fast = fast.next;
                } else {
                    return null;
                }
            }

            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }


    static class Solutio1 {

        public ListNode FindKthToTail(ListNode head, int k) {

            ListNode p, q;
            p = q = head;
            int i = 0;
            for (; p != null; i++) {
                if (i >= k)
                    q = q.next;
                p = p.next;
            }
            return i < k ? null : q;
        }

    }
}
