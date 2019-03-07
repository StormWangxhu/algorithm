package me.wangxhu.demo_zuochengzuo.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-07 17:13
 * @Email: StormWangxhu@163.com
 * @Description:
 */
public class IPO {

    //每一个Node就是一个项目，有两个值
    public static class Node {

        public int p;//收益
        public int c;//花费

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    /**
     * 收益低的比较器
     */
    public static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;//o1写在前是降序
        }
    }

    /**
     * 收益高的比较器
     */
    public static class MaxProfitComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;//o2写在前是升序
        }
    }

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {

        Node[] nodes = new Node[Profits.length];//Node数组中放着所有生成的项目
        for (int i = 0; i < Profits.length; i++) {
            nodes[i] = new Node(Profits[i], Capital[i]);
        }

        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());//小根堆
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());//大根堆

        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);
        }

        //依次做项目，最多做K个
        for (int i = 0; i < k; i++) {
            //当前钱数为W。小根堆堆顶钱数<W，则可以做，符合条件的全部解锁
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {//minCostQ.peek().c <= W 小根堆堆顶的钱小于我当前的钱
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return W;
            }
            W += maxProfitQ.poll().p;
        }
        return W;
    }
}
