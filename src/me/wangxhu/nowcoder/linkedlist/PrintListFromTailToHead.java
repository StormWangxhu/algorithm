package me.wangxhu.nowcoder.linkedlist;

import me.wangxhu.leedcode.dfs.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: StormWangxhu
 * @Time: 2019-02-28 22:45
 * @Email: StormWangxhu@163.com
 * @Description:
 */
public class PrintListFromTailToHead {

    /**
     * 使用栈来解决
     */
    public static class Solution{

        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

            Stack<Integer> stack = new Stack<>();
            while (listNode!=null){
                stack.push(listNode.val);
                listNode = listNode.next;
            }

            ArrayList<Integer> ret = new ArrayList<>();
            while (!stack.isEmpty()){
                ret.add(stack.pop());
            }
            return ret;
        }
    }


    /**
     * 使用递归解决问题
     */
    public static class Solution2 {

        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

            ArrayList<Integer> arrayList = new ArrayList<>();
            if (listNode!=null) {
                arrayList.addAll(printListFromTailToHead(listNode.next));
                arrayList.add(listNode.val);
            }
            return arrayList;
        }
    }


}
