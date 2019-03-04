package me.wangxhu.demo_zuochengzuo.linkedlist;

import me.wangxhu.demo_zuochengzuo.common.ListNode;

import java.util.Stack;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-04 14:09
 * @Email: StormWangxhu@163.com
 * @Description: 判断一个链表是否是回文结构
 * 方法一：需要辅助栈
 * 方法二：不需要辅助栈，牛逼做法
 */
public class IsPalindrome {


    /**
     * 空间复杂度:O(n)
     * 栈做法
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome1(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * n / 2
     * 栈+快慢指针
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome2(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;//慢指针
        ListNode quick = head;//快指针
        while (quick.next != null && quick.next.next != null) {//保证快指针能够到达
            slow = slow.next;
            quick = quick.next.next;
        }

        Stack<ListNode> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }



    /**
     * 快慢指针
     * 空间复杂度：O(1)
     * 最牛逼的解法
     * @param head
     * @return
     */
    public static boolean isPalindrome3(ListNode head) {

        if (head != null || head.next != null) {
            return true;
        }

        ListNode n1 = head;//满指针
        ListNode n2 = head;//快指针

        //找到中间节点
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;  //n1 --> mid
            n2 = n2.next.next;  // n2 --> end
        }

        n2 = n1;  //n2 --> right part first node
        n1.next = null; // m id.next --> null
        ListNode n3 = null;
        //将右半部分反转
        while (n2 != null) {
            n3 = n2.next; //save next node
            n2.next = n1;  //next of right node convert
            n1 = n2; //n1 move
            n2 = n3; //n2 move
        }

        //检查是否是回文
        n3 = n1;//n3 -->save last node
        n2 = head; // n2 --> left first node
        boolean res = true;
        while (n1 != null && n2 != null) { //check palindrome
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next; //left to mid
            n2 = n2.next; //right to mid
        }

        //把右半部分再逆序回来
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {  // recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}
