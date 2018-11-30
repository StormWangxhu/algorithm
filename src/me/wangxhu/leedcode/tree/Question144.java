package me.wangxhu.leedcode.tree;

import me.wangxhu.leedcode.dfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created on 18-12-1</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leedcode 144 :求二叉树的前序遍历
 * 难度系数:中等
 * 递归和非递归实现
 */
public class Question144 {

    /**
     * 递归实现
     */
    static class Solution {

        static List<Integer> res;
        public List<Integer> preorderTraversal(TreeNode root) {
            res = new ArrayList<>();
            preOrderTraversal(root);
            return res;
        }

        private void preOrderTraversal(TreeNode root) {
            if (root==null){
                return;
            }

            res.add(root.val);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }
}
