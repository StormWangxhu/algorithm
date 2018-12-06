package me.wangxhu.leedcode.linkedlist;

import me.wangxhu.leedcode.dfs.ListNode;


/**
 * <p>Created on 18-12-6</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode92: 反转部分单向链表
 * <p>
 * 难度级别:中等
 */
public class Question92 {

    static class Solution {

        public ListNode reverseBetween(ListNode head, int m, int n) {

            int len = 0;
            ListNode node1 = head;
            ListNode fPre = null;
            ListNode tPos = null;
            while (node1 != null) {
                len++;
                fPre = len == m-1 ? node1 : fPre;
                tPos = len == n+1 ? node1 : tPos;
                node1 = node1.next;
            }

            if (m > n || m < 0 || n > len) {
                return head;
            }

            /**
             * 此处部分相当于反转单向链表那中逻辑
             */
            //node1现在是我要反转部分的头节点
            node1 = fPre == null ? head : fPre.next;
            ListNode node2 = node1.next;
            node1.next = tPos;
            ListNode next = null;
            while (node2 != tPos) {
                next = node2.next;
                node2.next = node1;
                node1 = node2;
                node2 = next;
            }

            if (fPre != null) {
                fPre.next = node1;
                return head;
            }
            return node1;
        }
    }
}
