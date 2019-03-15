package me.wangxhu.nowcoder.linkedlist;

import me.wangxhu.demo_zuochengzuo.common.ListNode;

import java.util.HashSet;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-15 20:39
 * @Email: StormWangxhu@163.com
 * @Description: 寻找链表的第一个入环节点
 * 这是第二种方法：利用哈希表结构
 */
public class EntryNodeOfLoopII {

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        //当有一个节点的时候，有两个节点的时候，成不了环，直接返回null
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }

        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = pHead;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }
}
