package me.wangxhu.demo_zuochengzuo.linkedlist;

import me.wangxhu.demo_zuochengzuo.ListNode;

/**
 * @Author: StormWangxhu
 * @Time: 2019-01-26 15:59
 * @Email: StormWangxhu@163.com
 * @Description: 删除单链表中倒数第K个节点
 */
public class RemoveLastKthNode {

    static class Solution {

        public ListNode removeLastKthNode(ListNode head, int k) {

            if (head == null || k < 0) {
                return head;
            }

            ListNode cur = head;
            while (cur != null) {
                k--;
                cur = cur.next;
            }
            if (k == 0) {
                head = head.next;
            }
            if (k < 0) {
                cur = head;
                while (++k!=0){
                    cur = cur.next;
                }
                cur.next = cur.next.next;
            }

            return head;
        }
    }

}
