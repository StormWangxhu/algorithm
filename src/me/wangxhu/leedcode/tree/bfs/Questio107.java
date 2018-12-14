package me.wangxhu.leedcode.tree.bfs;

import me.wangxhu.leedcode.dfs.TreeNode;

import java.util.*;

/**
 * <p>Created on 18-12-14</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 */
public class Questio107 {

    static class Solution1 {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            Collections.reverse(lists);
            return lists;
        }
    }
}
