package me.wangxhu.leedcode.linkedlist;

import me.wangxhu.leedcode.dfs.ListNode;

import java.util.HashSet;
import java.util.Stack;

/**
 * <p>Created on 18-12-6</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode234.判断一个链表是否是回文结构
 * <p>
 * 难度级别:简单
 * <p>
 * 思路:就是一个链表要是回文链表,则借用栈结构可以实现反转,再一次遍历链表,若栈顶值和链表元素都相同,则是回文结构,否则不是回文结构!
 */
public class Question234 {

    /**
     * TODO: 最后一个例子没有过
     */
    static class Solution {

        public boolean isPalindrome(ListNode head) {

            if (head == null) {
                return false;
            }

            ListNode cur = head;
            Stack<ListNode> stack = new Stack<>();
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }

            while (head != null) {
                if (head.val != stack.pop().val) {
                    return false;
                }
                head = head.next;
            }

            return true;
        }
    }

    /**
     * 这个例子可以全部通过
     */
    static class Solution1 {

        public boolean isPalindrome(ListNode head) {

            Stack<ListNode> stack = new Stack<>();
            ListNode cur = head;

            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }

            while (head != null) {
                if (head.val != stack.pop().val) {
                    return false;
                }
                head = head.next;
            }
            return true;
        }
    }


    /**
     * 题目要求：以 O(1) 的空间复杂度来求解。
     * <p>
     * 切成两半，把后半段反转，然后比较两半是否相等。
     */
    static class Solution2 {

        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) return true;
            ListNode slow = head, fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            if (fast != null) slow = slow.next;  // 偶数节点，让 slow 指向下一个节点
            cut(head, slow);                     // 切成两个链表
            return isEqual(head, reverse(slow));
        }

        private void cut(ListNode head, ListNode cutNode) {
            while (head.next != cutNode) {
                head = head.next;
            }
            head.next = null;
        }

        private ListNode reverse(ListNode head) {
            ListNode newHead = null;
            while (head != null) {
                ListNode nextNode = head.next;
                head.next = newHead;
                newHead = head;
                head = nextNode;
            }
            return newHead;
        }

        private boolean isEqual(ListNode l1, ListNode l2) {
            while (l1 != null && l2 != null) {
                if (l1.val != l2.val) return false;
                l1 = l1.next;
                l2 = l2.next;
            }
            return true;
        }
    }
}
