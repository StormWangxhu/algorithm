package me.wangxhu.leedcode.tree.BST;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-2</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode108 : 将有序数组转换为二叉搜索树
 * <p>
 * 难度级别: 简单
 * <p>
 * 思路: 因为是有序数组,所以将这个有序数组中中间的数作为树的头节点,该数左边的数为左子树,
 * 该数右边的数为右子树
 * 方法: 递归实现
 */
public class Question108 {

    static class Solution {

        public TreeNode sortedArrayToBST(int[] nums) {

            return toBST(nums, 0, nums.length - 1);
        }

        private TreeNode toBST(int[] nums, int sIdx, int eIdx) {
            if (sIdx > eIdx) {
                return null;
            }

            int mIdx = sIdx + ((eIdx - sIdx) / 2);// (sIdx+sIdx)/2
            TreeNode root = new TreeNode(nums[mIdx]);
            root.left = toBST(nums, sIdx, mIdx - 1);
            root.right = toBST(nums, mIdx + 1, eIdx);
            return root;
        }
    }
}
