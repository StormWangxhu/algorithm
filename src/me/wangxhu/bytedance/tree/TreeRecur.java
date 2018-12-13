package me.wangxhu.bytedance.tree;

import me.wangxhu.leedcode.dfs.ListNode;
import me.wangxhu.leedcode.dfs.TreeNode;

import java.util.Stack;

/**
 * <p>Created on 18-12-13</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * 树的前中后序遍历
 */
public class TreeRecur {

    /**
     * 递归实现
     */
    static class Solution {

        /**
         * 前序遍历 : 根左右
         *
         * @param head
         */
        public static void preOrderRecur(TreeNode head) {

            if (head == null) {
                return;
            }
            System.out.println(head.val);
            preOrderRecur(head.left);
            preOrderRecur(head.right);
        }


        /**
         * 中序遍历： 左右中
         *
         * @param head
         */
        public static void inOrderRecur(TreeNode head) {

            if (head == null) {
                return;
            }
            inOrderRecur(head.left);
            System.out.println(head.val);
            inOrderRecur(head.right);
        }


        /**
         * 后序遍历： 左右根
         *
         * @param head
         */
        public static void posOrderRecur(TreeNode head) {

            if (head == null) {
                return;
            }
            posOrderRecur(head.left);
            posOrderRecur(head.right);
            System.out.println(head.val);
        }
    }


    /**
     * 非递归实现树的前中后序遍历
     */
    static class Soluton1 {

        /**
         * 前序非递归实现
         *
         * @param head
         */
        public static void preOrederRecur(TreeNode head) {

            if (head == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node == null) {
                    continue;
                }

                System.out.println(node.val);//先进右节点后进左节点
                stack.push(node.right);
                stack.push(node.left);
            }
        }


        /**
         * 二叉树前序非递归实现
         *
         * @param head
         */
        public static void preOrderRecur1(TreeNode head) {

            if (head != null) {
                Stack<TreeNode> stack = new Stack<>();
                stack.push(head);
                while (!stack.isEmpty()) {
                    head = stack.pop();
                    System.out.println(head.val);
                    if (head.right != null) {
                        stack.push(head.right);
                    }
                    if (head.left != null) {
                        stack.push(head.left);
                    }
                }
            }
            System.out.println();
        }


        /**
         * 二叉树非递归实现
         *
         * @param head
         */
        public static void inOrderRecur(TreeNode head) {

            if (head == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {//中序遍历两个判断条件
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.val);
                    head = head.right;
                }
            }
            System.out.println();
        }


        public static void posOrderRecur(TreeNode head) {

            if (head == null) {
                return;
            }

            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> help = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                help.push(head);
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
            while (!help.isEmpty()) {
                System.out.println(help.pop().val);
            }
        }


    }
}
