package me.wangxhu.demo_zuochengzuo.linkedlist;

import me.wangxhu.demo_zuochengzuo.common.ListNode;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-04 17:04
 * @Email: StormWangxhu@163.com
 * @Description: 将一个单向链表按某值划分为左边小，中间相等，右边大的形式。
 * 和荷兰国旗问题很相似
 * 普通解法：
 * 1.创建一个节点类型的数组，将所有节点都加入数组。
 * 2.利用荷兰国旗问题进行`partition`
 * 3.再将数组中的节点形成一个链表返回
 */
public class LinkListPartitionLikeHeLanFlag {

    public ListNode listNodePartition(ListNode head, int num) {

        if (head == null) {
            return head;
        }

        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }

        ListNode[] arrNode = new ListNode[i];
        i = 0;
        cur = head;
        for (i = 0; i != arrNode.length; i++) {
            arrNode[i] = cur;
            cur = cur.next;
        }
        arrPartition(arrNode, num);
        //再将数组中的节点形成一个链表
        for (i = 1; i != arrNode.length; i++) {
            arrNode[i - 1].next = arrNode[i];
        }
        arrNode[i - 1].next = null;
        return arrNode[0];

    }

    private void arrPartition(ListNode[] arrNode, int num) {

        int less = -1;
        int more = arrNode.length;
        int index = 0;

        while (index != more) {
            if (arrNode[index].value < num) {
                swap(arrNode, ++less, index++);
            } else if (arrNode[index].value > num) {
                swap(arrNode, --more, index);
            } else {
                index++;
            }
        }
    }

    private void swap(ListNode[] arrNode, int i, int index) {
        ListNode temp = arrNode[i];
        arrNode[i] = arrNode[index];
        arrNode[index] = temp;
    }


}
