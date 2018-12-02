package me.wangxhu.leedcode.tree.BST;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-2</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode669 修剪二叉查找树
 * <p>
 * 难度级别: 简单
 * <p>
 * 二叉查找树(BST[Binary Search Tree])定义: 根节点大于等于左子树所有节点，小于等于右子树所有节点。
 * BST性质: 二叉查找树中序遍历 为有序
 */
public class Question669 {

    static class Solution {

        public TreeNode trimBST(TreeNode root, int L, int R) {

            if (root == null) {
                return null;
            }
            if (root.val > R) {
                return trimBST(root.left, L, R);
            }
            if (root.val < L) {
                return trimBST(root.right, L, R);
            }
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }
    }
}
