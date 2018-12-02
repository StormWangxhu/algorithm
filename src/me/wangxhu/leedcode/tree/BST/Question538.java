package me.wangxhu.leedcode.tree.BST;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-2</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * <p>
 * leetcode538 : 把二叉搜索树转换为累加树
 * <p>
 * 难度级别: 简单
 */
public class Question538 {

    static class Solution {

        private int sum = 0;

        public TreeNode convertBST(TreeNode root) {
            traver(root);
            return root;
        }

        private void traver(TreeNode root) {
            if (root == null) {
                return;
            }
            traver(root.right);
            sum += root.val;
            root.val = sum;
            traver(root.left);
        }
    }
}
