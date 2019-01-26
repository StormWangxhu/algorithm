package me.wangxhu.demo_zuochengzuo.linkedlist;

import me.wangxhu.demo_zuochengzuo.ListNode;

/**
 * @Author: StormWangxhu
 * @Time: 2019-01-26 15:23
 * @Email: StormWangxhu@163.com
 * @Description: 打印两个有序链表的公共部分 （外排思想）
 */

public class PrintCommonPart {

    static class Solution {

        public void printCommonPart(ListNode head1, ListNode head2) {

            System.out.println("Common Part...");
            while (head1 != null && head2 != null) {
                if (head1.value > head2.value) {
                    head2 = head2.next;
                } else if (head1.value < head2.value) {
                    head1 = head1.next;
                } else {
                    System.out.println(head1.value);
                    head1 = head1.next;
                    head2 = head2.next;
                }
            }

            System.out.println();
        }
    }
}
