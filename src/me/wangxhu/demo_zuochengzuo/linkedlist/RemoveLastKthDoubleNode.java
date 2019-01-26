package me.wangxhu.demo_zuochengzuo.linkedlist;

import me.wangxhu.demo_zuochengzuo.DoubleListNode;

/**
 * @Author: StormWangxhu
 * @Time: 2019-01-26 16:10
 * @Email: StormWangxhu@163.com
 * @Description: 删除双链表中倒数第k个节点
 */
public class RemoveLastKthDoubleNode {

    static class Solution {

        public DoubleListNode removeLastKthDoubleNode(DoubleListNode head, int k) {

            if (head == null || k < 0) {
                return head;
            }

            DoubleListNode cur = head;
            while (cur != null) {
                k--;
                cur = cur.next;
            }

            if (k == 0) {
                head = head.next;
            }

            if (k < 0) {
                cur = head;
                while (++k != 0) {
                    cur = cur.next;
                }

                DoubleListNode newList = cur.next.next;
                cur.next = newList;
                if (newList != null) {
                    newList.last = cur;
                }
            }

            return head;
        }
    }
}
