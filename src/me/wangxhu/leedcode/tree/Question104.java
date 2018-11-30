package me.wangxhu.leedcode.tree;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-1</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 *
 * leetcode 104  : 二叉树的最大深度
 * 难度系数: 简单
 *
 */
public class Question104 {

    static class Solution {

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }


    /**
     * 深度优先搜索dfs写法
     */
    static class Solution2{

        public int maxDepth(TreeNode root){
            return dfs(root);
        }

        private int dfs(TreeNode root) {
            if (root==null){
                return 0;
            }
            return 1 + Math.max(dfs(root.left), dfs(root.right));
        }
    }
}
