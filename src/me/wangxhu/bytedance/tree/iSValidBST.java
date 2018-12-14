package me.wangxhu.bytedance.tree;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-13</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * 验证一颗树是否是搜索二叉树
 */
public class iSValidBST {

    static class Solution {

        public static boolean isValidBST(TreeNode head) {

            return isValidBST(head, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private static boolean isValidBST(TreeNode head, long minValue, long maxValue) {

            if (head == null) {
                return false;
            }
            if (head.val <= minValue || head.val >= maxValue) {
                return false;
            }

            return isValidBST(head.left, minValue, head.val) && isValidBST(head.right, head.val, maxValue);

        }

    }

}
