package me.wangxhu.demo_zuochengzuo.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-06 09:17
 * @Email: StormWangxhu@163.com
 * @Description: 二叉树先序反序列化
 */
public class ReconTreeNodeByPreString {

    public TreeNode reconTreeNodeByPreString(String preStr) {

        String[] values = preStr.split("!");//以叹号作为分割
        Queue<String> queue = new LinkedList<>();//所有东西加入到队列中，可以依次弹出
        for (int i = 0; i != values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);//建立整棵树，消费队列
    }

    /**
     * 根据队列建立出整个树
     * @param queue
     * @return
     */
    private TreeNode reconPreOrder(Queue<String> queue) {

        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }

        //头节点消费当前队列
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;

    }
}
