package me.wangxhu.leedcode.tree.recursive;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-2</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode222 : 求完全二叉树的节点个数
 * <p>
 * 难度级别: 中等
 */
public class Question222 {

    //TODO : 测试用例只能通过15个/18个

    /**
     * 二叉树的节点数=左子树节点数+右子树节点数+1(头节点)
     * 时间复杂度 O(n)
     * 运行该算法会发现测试用例只能过去15个/18个,并且会超时
     * 原因:  没有运用完全二叉树这个条件
     */
    static class Solution {

        public int countNodes(TreeNode root) {

            if (root == null) {
                return 0;
            }
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }


    /**
     * 满二叉树条件 写法1
     * 时间复杂度: O(h^2)  h为树的高度(层数)
     */
    static class Solution1 {

        public int countNodes(TreeNode root) {

            if (root == null) {
                return 0;
            }
            int leftHeight = getLeftHeight(root);
            int rightHeight = getRightHeight(root);
            //左子树高度=右子树高度 ==> 满二叉树,套用节点公式: 2^n - 1
            if (leftHeight == rightHeight) {
                return (1 << leftHeight) - 1;
            } else {
                return countNodes(root.left) + countNodes(root.right) + 1;
            }
        }

        /**
         * 获取左子树的高度
         *
         * @param root
         * @return
         */
        private int getRightHeight(TreeNode root) {
            int count = 0;
            while (root != null) {
                count++;
                root = root.left;
            }
            return count;
        }

        /**
         * 获取右子树的高度
         *
         * @param root
         * @return
         */
        private int getLeftHeight(TreeNode root) {
            int count = 0;
            while (root != null) {
                count++;
                root = root.right;
            }
            return count;
        }
    }


    /**
     * 满二叉树条件写法2
     */
    static class Solution2 {

        public int countNodes(TreeNode root) {

            if (root == null) {
                return 0;
            }
            return bs(root, 1, mostLeftLevel(root, 1));
        }

        /**
         * 返回的是所有节点个数
         *
         * @param root 头节点
         * @param l    当前头结点所在的层数
         * @param h    整棵树的高度
         * @return
         */
        private int bs(TreeNode root, int l, int h) {
            if (l == h) {
                return 1;
            }
            if (mostLeftLevel(root.right, l + 1) == h) {
                return (1 << (h - l) + bs(root.right, l + 1, h));
            } else {
                return (1 << (h - l - 1) + bs(root.left, l + 1, h));
            }
        }

        /**
         * 求子树最大深度
         *
         * @param root  当前节点
         * @param level 当前节点所在的层数
         * @return
         */
        private int mostLeftLevel(TreeNode root, int level) {
            while (root != null) {
                level++;
                root = root.left;
            }
            return level - 1;//因为求的是子树的高度,传进来的level=1,是因为根节点所在层数为1,所以子树高度应该把根节点所在层数减去
        }

    }
}
