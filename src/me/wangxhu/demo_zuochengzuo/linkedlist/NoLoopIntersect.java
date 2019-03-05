package me.wangxhu.demo_zuochengzuo.linkedlist;

import me.wangxhu.demo_zuochengzuo.common.ListNode;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-05 14:29
 * @Email: StormWangxhu@163.com
 * @Description: Intersect:相交
 * 即：两个无环链表相交
 * 学习完了如何判断两个链表有环还是无环，现在来看两个无环链表
 * 的交点
 */
public class NoLoopIntersect {

    public ListNode noLoop(ListNode head1, ListNode head2) {

        if (head1 == null || head1 == null) {
            return null;
        }

        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int n = 0;//长度差值的绝对值
        //找出来两个链表的最后一个节点
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }

        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }

        //如果两个尾节点不相等，则不相交，否则相交
        if (cur1 != cur2) {
            return null;
        }

        cur1 = n > 0 ? head1 : head2;  //长一点的
        cur2 = cur1 == head1 ? head2 : head1;  //短一点的
        n = Math.abs(n);
        //长的先走掉比短的长出来的节点
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        //然后两个节点一起走
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
