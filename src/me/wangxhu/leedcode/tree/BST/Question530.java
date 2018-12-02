package me.wangxhu.leedcode.tree.BST;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-2</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * <p>
 * leetcode530: 二叉搜索树的最小绝对差
 * <p>
 * 难度级别: 简单
 * <p>
 * 思路: 利用二叉搜索树中序遍历为有序,利用中序遍历中临近节点之差的绝对值,取最小值
 */
public class Question530 {

    static class Solution {

        private int minDiff = Integer.MAX_VALUE;
        private TreeNode preNode = null;

        public int getMinimumDifference(TreeNode root) {
            inOrder(root);
            return minDiff;
        }

        private void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            if (preNode != null) {
                minDiff = Math.min(minDiff, root.val - preNode.val);
            }
            preNode = root;
            inOrder(root.right);
        }
    }
}
