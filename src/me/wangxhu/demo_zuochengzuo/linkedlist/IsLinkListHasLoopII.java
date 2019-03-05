package me.wangxhu.demo_zuochengzuo.linkedlist;

import me.wangxhu.demo_zuochengzuo.common.ListNode;

import java.util.HashSet;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-05 11:25
 * @Email: StormWangxhu@163.com
 * @Description: 判断链表是否有环
 * 方法二：利用哈希表来做HashSet.
 * 将所有节点都放进哈希表中，若哈希表中第一次遇见已经存在的节点，即为第一个入环节点
 * 若遍历完都没有遇到哈希表中已经存在的节点，则该链表没有环
 */
public class IsLinkListHasLoopII {

    public ListNode getLoopListNode(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        HashSet<ListNode> hashSet = new HashSet<>();
        while (head != null) {
            if (hashSet.contains(head)) {
                return head;
            }
            hashSet.add(head);
            head = head.next;
        }

        return null;
    }
}
