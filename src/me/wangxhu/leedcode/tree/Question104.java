package me.wangxhu.leedcode.tree;

import javafx.util.Pair;
import me.wangxhu.leedcode.dfs.TreeNode;

import java.util.*;

/**
 * <p>Created on 18-12-1</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode 104  : 二叉树的最大深度
 * <p>
 * 难度系数: 简单
 * <p>
 * 最大深度的定义: 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 非递归实现:{dfs:栈,bfs:队列}
 */
public class Question104 {

    static class Solution {

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }


    /**
     * 深度优先搜索dfs写法
     * <p>
     * 时间复杂度 : O(n)  ,n是节点的数量,即每个节点我们都访问一次
     * 空间复杂度 : O(n)  ,在最糟糕的情况下，树是完全不平衡的，例如每个结点只剩下左子结点，
     * 递归将会被调用 N 次（树的高度），因此保持调用栈的存储将是O(N)。
     * 但在最好的情况下（树是完全平衡的），树的高度将是 log(N)。
     * 因此，在这种情况下的空间复杂度将是O(log(N))。
     */
    static class Solution2 {

        public int maxDepth(TreeNode root) {
            return dfs(root);
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(dfs(root.left), dfs(root.right));
        }
    }


    /**
     * 最大深度的非递归实现
     */
    static class Solution3 {

        private int depth = 0;

        public int maxDepth(TreeNode root) {

            Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
            if (root != null) {
                stack.add(new Pair<>(root, 1));
            }

            int depth = 0;
            while (!stack.isEmpty()) {
                Pair<TreeNode, Integer> current = stack.poll();
                root = current.getKey();
                int cur_depth = current.getValue();
                if (root != null) {
                    depth = Math.max(depth, cur_depth);
                    stack.add(new Pair<>(root.left, cur_depth + 1));
                    stack.add(new Pair<>(root.right, cur_depth + 1));
                }
            }
            return depth;
        }
    }
}
