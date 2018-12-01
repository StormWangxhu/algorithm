package me.wangxhu.leedcode.tree.recursive;

import me.wangxhu.leedcode.dfs.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>Created on 18-12-1</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * leetcode 94
 * 二叉树的中序遍历
 * 递归版本
 */
public class Question94 {
    static class Solution {

        public static List<Integer> res;

        public List<Integer> inorderTraversal(TreeNode root) {
            res = new ArrayList<>();
            inOrderTraversal(root);
            return res;
        }

        private void inOrderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrderTraversal(root.left);
            res.add(root.val);
            inOrderTraversal(root.right);
        }
    }


    /**
     *  进阶:二叉树中序遍历非递归版本
     */
    static class Solution1 {

        public static List<Integer> res;
        public List<Integer> inorderTraversal(TreeNode root) {
            res = new ArrayList<>();
            inOrderTraversal(root);
            return res;
        }

        private void inOrderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    res.add(root.val);
                    root = root.right;
                }
            }
            System.out.println();
        }
    }
}
