package me.wangxhu.leedcode.tree.BST;

import me.wangxhu.leedcode.dfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created on 18-12-2</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode653: 二叉搜索树中寻找两个节点等于给定的目标值
 * <p>
 * 难度级别: 简单
 * <p>
 * 思路: 二叉搜索树的中序遍历性质: 有序
 * 得到一个有序数组再用双指针对数组进行查找
 */
public class Question653 {

    static class Solution {

        public boolean findTarget(TreeNode root, int k) {

            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            int start = 0, end = list.size() - 1;//双指针
            while (start < end) {
                int sum = list.get(start) + list.get(end);
                if (sum == k) {
                    return true;
                }
                if (sum < k) {
                    start++;
                } else {
                    end--;
                }
            }
            return false;
        }

        private void inOrder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }
}
