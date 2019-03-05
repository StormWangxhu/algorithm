package me.wangxhu.demo_zuochengzuo.linkedlist;

import me.wangxhu.demo_zuochengzuo.common.ListNode;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-05 11:13
 * @Email: StormWangxhu@163.com
 * @Description: 判断链表是否有环
 * 方法：快慢指针
 * 理论：快指针每次走2步，慢指针每次走1步。
 * 当快指针走完时都没有和满指针相遇，则链表没有环。
 * 当快慢指针第一次相遇时，快指针回到链表头节点位置，改为每次走一步。
 * 快慢指针开始继续走，当他们再次相遇时，即为入环节点
 */
public class IsLinkListHasLoop {

    public ListNode getLoopListNode(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        ListNode n1 = head.next;//慢指针
        ListNode n2 = head.next.next;//快指针

        while (n1 != n2) {  //n1=n2 说明快慢指针相遇
            //快指针走到链表末尾都没有遇到慢指针，则返回Null
            if (n2.next != null || n2.next.next != null) {
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }

        //快指针回到头节点
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next; //快指针改为每次走一步
        }
        return n1;
    }
}
