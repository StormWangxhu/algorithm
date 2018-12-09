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
 *
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
}
