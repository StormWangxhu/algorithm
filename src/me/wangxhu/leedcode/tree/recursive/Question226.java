package me.wangxhu.leedcode.tree.recursive;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-1</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode226 :翻转二叉树
 *
 * 难度级别:简单
 *
 * 翻转二叉树:即以根节点为对称轴,左右节点交换值
 */
public class Question226 {

    static class Solution {

        public TreeNode invertTree(TreeNode root) {
            if (root==null){
                return null;
            }

            TreeNode left = root.left;
            root.left = invertTree(root.right);
            root.right =invertTree(left);
            return root;
        }
    }
}
