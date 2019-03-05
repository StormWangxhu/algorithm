package me.wangxhu.demo_zuochengzuo.tree;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-05 22:39
 * @Email: StormWangxhu@163.com
 * @Description:
 */
public class TreeNodeWithParent {

    public int value;
    public TreeNodeWithParent left;
    public TreeNodeWithParent right;
    public TreeNodeWithParent parent;

    public TreeNodeWithParent(int value) {
        this.value = value;
    }
}
