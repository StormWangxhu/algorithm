package me.wangxhu.leedcode.tree;

import me.wangxhu.leedcode.dfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created on 18-12-1</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * leetcode 94
 * 二叉树的中序遍历
 * 递归版本
 */
public class Question94 {
    static class Solution {

        public static List<Integer> res;
        public List<Integer> inorderTraversal(TreeNode root) {
            res = new ArrayList<>();
            inOrderTraversal(root);
            return res;
        }

        private void inOrderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrderTraversal(root.left);
            res.add(root.val);
            inOrderTraversal(root.right);
        }
    }
}
