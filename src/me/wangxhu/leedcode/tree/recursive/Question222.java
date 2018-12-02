package me.wangxhu.leedcode.tree.recursive;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-2</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode222 : 求完全二叉树的节点个数
 */
public class Question222 {

    //TODO : 测试用例只能通过15个/18个
    static class Solution {

        public int countNodes(TreeNode root) {

            if (root == null) {
                return 0;
            }
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}
