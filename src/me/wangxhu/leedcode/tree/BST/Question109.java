package me.wangxhu.leedcode.tree.BST;

import me.wangxhu.leedcode.dfs.ListNode;
import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-2</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode109 : 有序链表转换为二叉搜索树
 * <p>
 * 难度级别: 中等
 * <p>
 * leetcode108: 有序数组转换为二叉搜索树
 */
public class Question109 {

    static class Solution {

        public TreeNode sortedListToBST(ListNode head) {

            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return new TreeNode(head.val);
            }
            ListNode preMid = preMid(head);
            ListNode mid = preMid.next;
            preMid.next = null;
            TreeNode root = new TreeNode(mid.val);
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(mid.next);
            return root;
        }

        private ListNode preMid(ListNode head) {
            ListNode slow = head, fast = head.next;
            ListNode pre = head;
            while (fast != null && fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            return pre;
        }
    }
}
