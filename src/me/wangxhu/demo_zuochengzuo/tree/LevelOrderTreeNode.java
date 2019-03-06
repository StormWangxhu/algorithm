package me.wangxhu.demo_zuochengzuo.tree;

import me.wangxhu.demo_zuochengzuo.common.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-06 14:26
 * @Email: StormWangxhu@163.com
 * @Description: 二叉树的层次遍历
 *
 * 二叉树的层次遍历  数据结构：队列
 */
public class LevelOrderTreeNode {

    public List<TreeNode> levelOrder(TreeNode head) {

        List<TreeNode> lists = new ArrayList<>();
        if (head == null) {
            return lists;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            lists.add(head);
            if (head.left != null) {
                queue.add(head.left);
            } else if (head.right != null) {
                queue.add(head.right);
            }
        }
        return lists;
    }
}
