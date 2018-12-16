package me.wangxhu.leedcode.tree.recursive;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-1</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode 110:平衡二叉树
 * <p>
 * 平衡树的定义:平衡树的左右子树的高度差的绝对值小于等于1
 * 难度级别:简单
 */
public class Question110 {

    static class Solution {

        private boolean res = true;

        public boolean isBalanced(TreeNode root) {
            maxDepth(root);
            return res;
        }

        private int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            if (Math.abs((left - right)) > 1) {
                res = false;
            }
            return 1 + Math.max(left, right);
        }
    }


    /**
     * 第二种写法
     */
    static class Solution1 {
        public boolean isBalanced(TreeNode root) {
            if(root == null) {
                return true;
            }
            boolean flag = true;

            flag = isBalanced(root.left);
            if(flag) {
                flag = isBalanced(root.right);
            }

            if(flag) {
                flag = Math.abs(height(root.left) - height(root.right)) <= 1;
            }

            return flag;
        }

        private int height(TreeNode root) {
            if(root == null) {
                return 0;
            }

            int left = height(root.left);
            int right = height(root.right);

            return Math.max(left, right) + 1;
        }
    }
}
