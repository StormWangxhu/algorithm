package me.wangxhu.demo_zuochengzuo.linkedlist;

import me.wangxhu.demo_zuochengzuo.common.ListNode;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-05 15:13
 * @Email: StormWangxhu@163.com
 * @Description: 两个有环链表相交，三种拓扑结构,以各自链表的入环节点相等与否来划分
 */
public class BothLoopIntersect {

    public ListNode bothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {

        ListNode cur1 = null;
        ListNode cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }

            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }

            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }

            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;

        } else {//此处有两种拓扑结构
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {//遇到了loop2
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
}
