package me.wangxhu.leedcode.tree.bfs;

import me.wangxhu.leedcode.dfs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Created on 18-12-2</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode513 : 找到树左下角的值
 * <p>
 * 难度级别: 中等
 */
public class Question513 {

    static class Solution {

        public int findBottomLeftValue(TreeNode root) {

            if (root == null) {
                return 0;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                root = queue.poll();
                if (root.right != null) {
                    queue.add(root.right);
                }
                if (root.left != null) {
                    queue.add(root.left);
                }
            }
            return root.val;
        }
    }
}
