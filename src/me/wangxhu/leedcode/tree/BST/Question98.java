package me.wangxhu.leedcode.tree.BST;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-10</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode98.验证一个树是否是二叉搜索树
 * <p>
 * 难度级别: 中等
 */
public class Question98 {

    static class Range{
        long low, high;
    }

    static class Solution {

        public boolean isValidBST(TreeNode root) {

            if (root == null ||
                    (root.right == null && root.left == null)) return true;
            Range range = new Range();
            range.high = Long.MAX_VALUE;
            range.low = Long.MIN_VALUE;
            return validate(root, range);

        }

        private boolean validate(TreeNode root, Range range) {

            if ((root.val > range.low) && (root.val < range.high)) {
                long temp = range.high;
                if (root.left != null) {
                    range.high = root.val;
                    if (!validate(root.left, range)) return false;
                }
                if (root.right != null) {
                    range.high = temp;
                    range.low = root.val;
                    if (!validate(root.right, range)) return false;
                }
                return true;
            } else
                return false;
        }
    }

}
