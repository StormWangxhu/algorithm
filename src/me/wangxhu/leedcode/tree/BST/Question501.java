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
 * leetcode501 : 二叉搜索树中的众数
 * <p>
 * 难度级别: 简单
 */
public class Question501 {

    static class Solution {

        private int curCnt = 1;
        private int maxCnt = 1;
        private TreeNode preNode = null;

        public int[] findMode(TreeNode root) {

            List<Integer> maxCntNums = new ArrayList<>();
            inOrder(root, maxCntNums);
            int[] res = new int[maxCntNums.size()];
            int idx = 0;
            for (int num : maxCntNums) {
                res[idx++] = num;
            }
            return res;


        }

        private void inOrder(TreeNode root, List<Integer> maxCntNums) {
            if (root == null) {
                return;
            }
            inOrder(root.left, maxCntNums);
            if (preNode != null) {
                if (preNode.val == root.val) {
                    curCnt++;
                } else {
                    curCnt = 1;
                }
            }
            if (curCnt > maxCnt) {
                maxCnt = curCnt;
                maxCntNums.clear();
                maxCntNums.add(root.val);
            } else if (curCnt == maxCnt) {
                maxCntNums.add(root.val);
            }
            preNode = root;
            inOrder(root.right, maxCntNums);
        }
    }
}
