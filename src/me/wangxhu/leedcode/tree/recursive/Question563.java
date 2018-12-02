package me.wangxhu.leedcode.tree.recursive;

import me.wangxhu.leedcode.dfs.TreeNode;

import static java.lang.Math.abs;

/**
 * <p>Created on 18-12-2</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 */
public class Question563 {

    static class Solution {

        public int res = 0;

        public int findTilt(TreeNode root) {
            findTiltDfs(root);
            return res;
        }

        private int findTiltDfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftSum = findTiltDfs(root.left);
            int rightSum = findTiltDfs(root.right);
            res += Math.abs(leftSum - rightSum);
            return leftSum + rightSum + root.val;
        }
    }
}



