package me.wangxhu.leedcode.array;

/**
 * <p>Created on 18-12-10</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 *
 * leetcode922.按奇偶排序数组
 *
 * 将一个数组排序,奇数下标是奇数,偶数小标是偶数
 *
 * 简单
 */
public class Question922 {

    static class Solution{

        public int[] sortArrayByParityII(int[] A) {

            int[] sort = new int[A.length];
            int index0 = 0;
            int index1 = 1;
            for(int a: A){
                if(a % 2==0 ){//偶数
                    sort[index0] = a;
                    index0 += 2;
                }else { //奇数
                    sort[index1] = a;
                    index1 += 2;
                }
            }
            return sort;
        }
    }
}
