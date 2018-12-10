package me.wangxhu.leedcode.linkedlist;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-10</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode114: 将二叉树展开为链表
 * <p>
 * 难度级别: 中等
 */
public class Question114 {

    static class Solution {

        public void flatten(TreeNode root) {

            if (root == null) {
                return;
            }
            if (root.left != null) {
                flatten(root.left);
            }
            if (root.right != null) {
                flatten(root.right);
            }
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            while (root.right != null) {
                root = root.right;
            }
            root.right = temp;
        }
    }

}
