package me.wangxhu.nowcoder.tree;

import me.wangxhu.demo_zuochengzuo.tree.TreeNode;

import java.util.HashMap;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-18 11:03
 * @Email: StormWangxhu@163.com
 * @Description: 根据先序和中序数组构建二叉树
 */
public class ReConstructBinaryTree {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre == null || in == null) {
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);

    }

    private TreeNode preIn(int[] pre, int pi, int pj, int[] in, int iL, int iR, HashMap<Integer, Integer> map) {

        if (pi > pj) {
            return null;
        }

        TreeNode head = new TreeNode(pre[pi]);
        int index = map.get(pre[pi]);
        head.left = preIn(pre, pi + 1, pi + index - iL, in, iL, index - 1, map);
        head.right = preIn(pre, pi + index - iL + 1, pj, in, index + 1, iR, map);
        return head;
    }

}
