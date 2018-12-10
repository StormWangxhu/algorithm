package me.wangxhu.leedcode.linkedlist;

import me.wangxhu.leedcode.dfs.RandomListNode;

/**
 * <p>Created on 18-12-10</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode138.复制含有随机指针的链表
 */
public class Question138 {

    static class Solution{

        public RandomListNode copyRandomList(RandomListNode head) {

            if (head == null) return null;
            RandomListNode ite = head, next;
            while (ite != null) {
                next = ite.next;
                RandomListNode node = new RandomListNode(ite.label);
                ite.next = node;
                node.next = next;
                ite = next;
            }

            ite = head;
            while (ite != null) {
                if (ite.random != null)
                    ite.next.random = ite.random.next;
                ite = ite.next.next;
            }

            ite = head;
            RandomListNode copyIte = ite.next, copyHead = ite.next;
            while (copyIte.next != null) {
                ite.next = copyIte.next;
                copyIte.next = ite.next.next;
                copyIte = copyIte.next;
                ite = ite.next;
            }
            ite.next = null;

            return copyHead;

        }
    }
}
