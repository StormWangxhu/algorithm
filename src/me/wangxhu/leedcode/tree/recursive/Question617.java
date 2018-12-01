package me.wangxhu.leedcode.tree.recursive;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-1</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode617: 合并两个二叉树
 */
public class Question617 {

    static class Solition {

        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            return mergeTwoTrees(t1, t2);
        }

        private TreeNode mergeTwoTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return null;
            }
            if (t1 == null && t2 != null) {
                return t2;
            }
            if (t1 != null && t2 == null) {
                return t1;
            }

            TreeNode root = new TreeNode((t1.val + t2.val));
            root.left = mergeTwoTrees(t1.left, t2.left);
            root.right = mergeTwoTrees(t1.right, t2.right);
            return root;
        }
    }
}
