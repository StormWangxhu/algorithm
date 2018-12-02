package me.wangxhu.leedcode.tree.recursive;

import me.wangxhu.leedcode.dfs.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * <p>Created on 18-12-2</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode145 : 二叉树的后序遍历
 * <p>
 * 难度级别: 困难
 * <p>
 * 分析: 前序 : 根 左 右
 * 后续 : 左 右 根
 * 翻转:  根 右 左 ---> 改变前序遍历代码
 * <p>
 * 非递归实现
 */
public class Question145 {

    /**
     * 非递归实现
     * 2ms
     */
    static class Solution {

        public List<Integer> postorderTraversal(TreeNode root) {

            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            if (root == null) {
                return list;
            }
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                if (root == null) {
                    continue;
                }
                list.add(root.val);
                stack.push(root.left);
                stack.push(root.right);
            }
            Collections.reverse(list);
            return list;
        }
    }


    /**
     * 二叉树后续遍历递归实现
     *
     * 1ms
     */
    static class Solution1 {

        private List<Integer> res;

        public List<Integer> postorderTraversal(TreeNode root) {
            res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            postOrderTraversal(root);
            return res;
        }

        private void postOrderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            res.add(root.val);
        }
    }
}
