package me.wangxhu.leedcode.tree;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-1</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode437 : 路径总和
 * <p>
 * 难度级别: 简单
 * <p>
 * 题目描述: 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 */
public class Question437 {

    static class Solution {

        public int pathSum(TreeNode root, int sum) {

            if (root == null) {
                return 0;
            }
            int res = pathSumWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
            return res;
        }

        private int pathSumWithRoot(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }
            int res = 0;
            if (root.val == sum) {
                res++;
            }
            res += pathSumWithRoot(root.left, sum - root.val) + pathSumWithRoot(root.right, sum - root.val);
            return res;
        }
    }
}
