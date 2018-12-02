package me.wangxhu.leedcode.tree.bfs;

import me.wangxhu.leedcode.dfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Created on 18-12-2</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode102 . 二叉树层次的遍历
 * <p>
 * 难度级别: 中等
 * <p>
 * 非递归实现
 */
public class Question102 {

    static class Solution {

        public List<List<Integer>> levelOrder(TreeNode root) {

            List<List<Integer>> lists = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();

            if (root == null) {
                return lists;
            }
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> subList = new ArrayList<>();
                while (size-- > 0) {
                    root = queue.poll();
                    subList.add(root.val);
                    if (root.left != null) {
                        queue.add(root.left);
                    }
                    if (root.right != null) {
                        queue.add(root.right);
                    }
                }
                lists.add(subList);
            }
            return lists;
        }
    }
}
