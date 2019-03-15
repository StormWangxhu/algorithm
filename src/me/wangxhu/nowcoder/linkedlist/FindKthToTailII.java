package me.wangxhu.nowcoder.linkedlist;

import me.wangxhu.demo_zuochengzuo.common.ListNode;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-15 21:01
 * @Email: StormWangxhu@163.com
 * @Description: 寻找链表中倒数第k个节点
 * 思想：快慢指针：快指针先走k-1步，然后快慢指针一起走
 * 相当于是一个大小为k的尺子
 */
public class FindKthToTailII {

    /**
     * 20ms
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {

        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        if (k <= 0) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 1; i < k; i++) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


}
