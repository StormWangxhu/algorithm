package me.wangxhu.leedcode.tree.recursive;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-1</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode 671: 求二叉树中的第二小的节点
 * <p>
 * 难度级别: 简单
 */
public class Question671 {

    static class Solution {

        public int findSecondMinimumValue(TreeNode root) {

            if (root == null) {
                return -1;
            }
            if (root.left == null && root.right == null) {
                return -1;
            }

            int leftVal = root.left.val;
            int rightVal = root.right.val;
            if (leftVal == root.val) {
                leftVal = findSecondMinimumValue(root.left);
            }
            if (rightVal == root.val) {
                rightVal = findSecondMinimumValue(root.right);
            }
            if (leftVal != -1 && rightVal != -1) {//左右节点都有第二最小值,求最小值
                return Math.min(leftVal, rightVal);
            }
            if (leftVal != -1) {//只有左边有,否则返回右边
                return leftVal;
            }
            return rightVal;

        }
    }
}
