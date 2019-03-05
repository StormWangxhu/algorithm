package me.wangxhu.demo_zuochengzuo.tree;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-05 22:33
 * @Email: StormWangxhu@163.com
 * @Description: 在二叉树找到一个节点的后继节点
 * 和二叉树的中序遍历有关（根据题意。）
 * 最优解理论支持：
 * 1.如果当前节点node有右子树，则node的后继节点是该右子树上最左的节点
 * 2.若当前节点node没有右子树，则向上看node节点的父节点，看node是不是父节点的左节点，若是则当前父节点就是
 * Node节点的后继节点。若不是则继续向上寻找。
 * 只走过L个节点，则时间复杂度为：O（L）
 * 空间复杂度：O（1）
 * 前驱节点：
 * 当前节点左孩子的最右节点。
 */
public class GetNextTreeNode {


    public TreeNodeWithParent getNextTreeNode(TreeNodeWithParent node) {

        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getLeftTreeNode(node.right);
        } else {
            TreeNodeWithParent parent = node.parent;
            //parent != null 是最右的叶子节点在向上寻找过程中，会寻找到头节点，头节点父亲节点为null，则该节点没有后继结点
            while (parent != null && parent.left != node) {//parent.left != node 当前节点等于父节点左节点停，否则一直向上找
                node = parent;
                parent = node.parent;
            }
            return parent;
        }

    }

    /**
     * 得到一个节点的最左节点
     *
     * @param node
     * @return
     */
    private TreeNodeWithParent getLeftTreeNode(TreeNodeWithParent node) {

        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
