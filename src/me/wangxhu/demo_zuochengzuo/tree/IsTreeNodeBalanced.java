package me.wangxhu.demo_zuochengzuo.tree;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-06 09:55
 * @Email: StormWangxhu@163.com
 * @Description: 判断一颗二叉树是否是平衡二叉树
 */
public class IsTreeNodeBalanced {

    /**
     * 收集两个信息
     * 1.左右树是否平衡
     * 2.左右树的高度
     */
    static class ReturnData {
        public boolean isB;
        public int height;

        public ReturnData(boolean isB, int height) {
            this.isB = isB;
            this.height = height;
        }
    }


    /**
     * 递归判断
     *
     * @param head
     * @return
     */
    public static ReturnData process(TreeNode head) {

        if (head == null) {
            return new ReturnData(true, 0);//返回0的原因是因为当不平衡的时候，用不到高度，填任意哪个数字都无所谓
        }

        ReturnData leftData = process(head.left);
        if (!leftData.isB) {
            return new ReturnData(false, 0);
        }
        ReturnData rightData = process(head.right);
        if (!rightData.isB) {
            return new ReturnData(false, 0);
        }

        //高度差>1
        if (Math.abs(leftData.height - rightData.height) > 1) {
            return new ReturnData(false, 0);
        }
        return new ReturnData(true, Math.max(leftData.height, rightData.height) + 1);//整颗树的高度 = 左树高度和右树高度最大的那个 + 1
    }
}
