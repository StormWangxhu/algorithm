package me.wangxhu.nowcoder.stack;

import com.sun.javafx.charts.ChartLayoutAnimator;

import java.util.Stack;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-01 09:04
 * @Email: StormWangxhu@163.com
 * @Description:
 *
 * 用两个栈来实现一个队列
 *
 * 队列特点：先进先出
 * 第一个栈：存储
 * 第二个栈：再一次改变元素方向
 * 实现先进来的元素先出去
 *
 */
public class MyQueue {

    static class Solution{

        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();

        public void push(int node){
            in.push(node);
        }

        public int pop(){
            if (out.isEmpty()){
                while (!in.isEmpty()){
                    out.push(in.pop());
                }
            }
            return out.pop();
        }
    }
}
