package me.wangxhu.leedcode.tree.dfs;

import me.wangxhu.leedcode.dfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created on 18-12-17</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode872: 叶子相似的树
 * <p>
 * 难度级别：简单
 */
public class Question872 {

    static class Solution {

        public boolean leafSimilar(TreeNode root1, TreeNode root2) {

            List<Integer> leaves1 = new ArrayList<>();
            List<Integer> leaves2 = new ArrayList<>();
            dfs(root1, leaves1);
            dfs(root2, leaves2);
            return leaves1.equals(leaves2);
        }

        private void dfs(TreeNode root, List<Integer> leaves) {

            if (root != null) {
                if (root.left == null && root.right == null) {
                    leaves.add(root.val);
                }
                dfs(root.left, leaves);
                dfs(root.right, leaves);
            }
        }
    }
}
