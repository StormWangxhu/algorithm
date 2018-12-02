package me.wangxhu.leedcode.tree.BST;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-2</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode230 寻找二叉查找树中的第K小的元素
 *
 * 难度级别: 中等
 */
public class Question230 {

    /**
     * 中序遍历解法
     */
    static class Solution {

        private int cnt = 0;
        private int val;

        public int kthSmallest(TreeNode root, int k) {

            inOrder(root, k);
            return val;
        }

        private void inOrder(TreeNode root, int k) {
            if (root == null) {
                return;
            }
            inOrder(root.left, k);
            cnt++;
            if (cnt == k) {
                val = root.val;
                return;
            }
            inOrder(root.right, k);
        }
    }
}
