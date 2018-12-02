package me.wangxhu.leedcode.tree.bfs;

import me.wangxhu.leedcode.dfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Created on 18-12-1</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode637 : 二叉树的层平均值
 * <p>
 * 难度级别: 简单
 */
public class Question637 {

    static class Solution {

        public List<Double> averageOfLevels(TreeNode root) {

            List<Double> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int count = queue.size();
                double sum = 0;
                for (int i = 0; i < count; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                res.add(sum / count);
            }
            return res;
        }
    }
}
