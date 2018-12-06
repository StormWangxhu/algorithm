package me.wangxhu.leedcode.linkedlist;

import me.wangxhu.leedcode.dfs.ListNode;

/**
 * <p>Created on 18-12-6</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 *
 * leetcode21: 合并两个有序的链表
 *
 * 难度级别:简单
 */
public class Question21 {

    static class Solution{

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            if (l1==null){
                return l2;
            }

            if (l2==null){
                return l1;
            }

            if (l1.val<l2.val){
                l1.next = mergeTwoLists(l1.next,l2);
                return l1;
            }else {
                l2.next = mergeTwoLists(l1,l2.next);
                return l2;
            }
        }
    }
}
