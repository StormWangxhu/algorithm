package me.wangxhu.leedcode.tree.recursive;

import me.wangxhu.leedcode.dfs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Created on 18-12-1</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode101 : 对称二叉树  /  判断一个树是否是镜像树
 * <p>
 * 难度级别: 简单
 */
public class Question101 {

    /**
     * 递归实现
     * 时间复杂度 : O(n)  n是树中的节点,遍历整个输入树一次
     * 空间复杂度 : O(n)  递归调用的次数受树的高度限制。
     * 在最糟糕的情况下，树是线性的，其高度为 O(n)。因此，在最糟糕的情况下，由栈上的递归调用造成的空间复杂度为 O(n)。
     */
    static class Solution {

        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return true;
            }
            if (t1 == null || t2 == null) {
                return false;
            }

            if (t1.val != t2.val) {
                return false;
            }

            return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
        }
    }


    /**
     * 非递归版本判断一个树是否是镜像树
     * 数据结构: 队列
     * 时间复杂度: O(n)  每个节点输入一遍
     * 空间复杂度: O(n)   递归调用的次数受树的高度限制。
     */
    static class Solution2 {

        public boolean isSymmetric(TreeNode root) {

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode t1 = queue.poll();
                TreeNode t2 = queue.poll();
                if (t1 == null && t2 == null) {
                    continue;
                }
                if (t1 == null || t2 == null) {
                    return false;
                }

                if (t1.val != t2.val) {
                    return false;
                }

                queue.add(t1.left);
                queue.add(t2.right);
                queue.add(t1.right);
                queue.add(t2.left);
            }
            return true;
        }
    }
}
