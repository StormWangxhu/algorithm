package me.wangxhu.leedcode.tree;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-1</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 *
 * leetcode111 : 求二叉树的最小深度
 */
public class Question111 {

    /**
     * 二叉树的最小深度:dfs  时间复杂度:O(n)  n为节点的个数
     */
    static class Solution{
        public int minDepth(TreeNode root) {
            return dfs(root);
        }

        private int dfs(TreeNode root) {
            if (root==null){
                return 0;
            }
            //若不考虑以下两种情况,leetcode测试用例只能过去一部分
            if (root.left==null){
                return 1+minDepth(root.right);
            }
            if (root.right==null){
                return 1+minDepth(root.left);
            }
            return 1+Math.min(dfs(root.left),dfs(root.right));
        }
    }
}
