package me.wangxhu.demo_zuochengzuo.tree;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-06 15:31
 * @Email: StormWangxhu@163.com
 * @Description: 统计完全二叉树的节点数
 */
public class TreeNodeCount {

    public int treeNodeCount(TreeNode head) {

        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    /**
     * 🌲以head为头节点树的所有节点数
     *
     * @param head   当前节点
     * @param level  当前节点所在的层数
     * @param height 层数
     * @return
     */
    private int bs(TreeNode head, int level, int height) {

        if (level == height) {
            return 1;
        }

        //即头节点右子树到底了，去遍历右边，没到底即为满二叉树，遍历左边
        if (mostLeftLevel(head.right, level + 1) == height) {//右子树左边界碰到底了
            return (1 << (height - level)) + bs(head.right, level + 1, height);
        } else {//右树高度比左树高度少1个
            return (1 << (height - level - 1)) + bs(head.left, level + 1, height);
        }


    }


    private int mostLeftLevel(TreeNode head, int level) {

        while (head != null) {
            level++;
            head = head.left;
        }
        return level - 1;
    }
}