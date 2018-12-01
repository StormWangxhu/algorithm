package me.wangxhu.leedcode.tree.recursive;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-1</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode404 : 求左子树叶子节点的和/左叶子之和
 * <p>
 * 难度级别:简单
 */
public class Question404 {

    static class Solution {

        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (isLeaf(root.left)) {
                return root.left.val + sumOfLeftLeaves(root.right);
            }

            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }

        private boolean isLeaf(TreeNode root) {
            if (root == null) {
                return false;
            }
            return root.left == null && root.right == null;
        }
    }
}
