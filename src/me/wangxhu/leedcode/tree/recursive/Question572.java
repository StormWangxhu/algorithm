package me.wangxhu.leedcode.tree.recursive;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-1</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode572 : 在一个树中找另个一个树  /另一个树的子树
 * <p>
 * 难度级别:简单
 */
public class Question572 {

    static class Solution {

        public boolean isSubtree(TreeNode s, TreeNode t) {

            if (s == null) {
                return false;
            }
            if (t == null) {
                return false;
            }
            return isSubtreeWithRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        private boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {

            if (s == null && t == null) {
                return true;
            }
            if (s == null || t == null) {
                return false;
            }
            if (t.val != s.val) {
                return false;
            }

            return isSubtreeWithRoot(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);
        }
    }
}
