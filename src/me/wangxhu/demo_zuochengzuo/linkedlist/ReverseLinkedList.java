package me.wangxhu.demo_zuochengzuo.linkedlist;

import me.wangxhu.demo_zuochengzuo.common.ListNode;

/**
 * @Author: StormWangxhu
 * @Time: 2019-01-26 16:41
 * @Email: StormWangxhu@163.com
 * @Description: 反转单向链表
 */
public class ReverseLinkedList {

    static class Solution {

        public ListNode reverseLinkedList(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }

            ListNode pre = null;
            ListNode next = null;

            while (head != null) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }

            return pre;
        }
    }
}
