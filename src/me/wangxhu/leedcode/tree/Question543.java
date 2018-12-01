package me.wangxhu.leedcode.tree;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-1</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode543 : 二叉树的直径
 * <p>
 * 难度级别: 简单
 * <p>
 * 二叉树的直径:一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * 路径长度:两结点之间的路径长度是以它们之间边的数目表示。
 */
public class Question543 {

    static class Solution {

        private int max = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            maxDepth(root);
            return max;
        }

        private int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            max = Math.max(max, (leftDepth + rightDepth));
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
