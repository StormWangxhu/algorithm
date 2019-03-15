package me.wangxhu.nowcoder.linkedlist;

import me.wangxhu.demo_zuochengzuo.common.ListNode;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-15 20:29
 * @Email: StormWangxhu@163.com
 * @Description: ；链表环的第一个入口节点
 */
public class EntryNodeOfLoop {

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        //当有一个节点的时候，有两个节点的时候，成不了环，直接返回null
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }

        //快慢指针
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;

        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }
}
