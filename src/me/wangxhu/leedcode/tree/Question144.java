package me.wangxhu.leedcode.tree;

import me.wangxhu.leedcode.dfs.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>Created on 18-12-1</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leedcode 144 :求二叉树的前序遍历
 * 难度系数:中等
 * 递归和非递归实现
 *
 * 前序遍历: 根 左 右
 */
public class Question144 {

    /**
     * 递归实现
     */
    static class Solution {

        static List<Integer> res;

        public List<Integer> preorderTraversal(TreeNode root) {
            res = new ArrayList<>();
            preOrderTraversal(root);
            return res;
        }

        private void preOrderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }

            res.add(root.val);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }


    /**
     * 非递归实现  数据结构:栈
     */
    static class Solution2 {
        static List<Integer> res;

        public List<Integer> preorderTraversal(TreeNode root) {
            res = new ArrayList<>();
            preOrderTravsersal(root);
            return res;
        }

        private void preOrderTravsersal(TreeNode root) {
            if (root == null) {
                return;
            }

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                res.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
            System.out.println();
        }
    }
}
