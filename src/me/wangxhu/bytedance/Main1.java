package me.wangxhu.bytedance;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-16 10:31
 * @Email: StormWangxhu@163.com
 * @Description:
 */
public class Main1 {

    public static void main(String[] args) {
        solution1();
    }

    private static void solution1() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            String str = scanner.nextLine();
            char[] chars1 = str.toCharArray();
            list.add(chars1);
        }

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            char[] chars = (char[]) iterator.next();
            int length = chars.length;
            Stack<Character> stack = new Stack<>();
            stack.push(chars[0]);
            for (int i = 0; i < length; i++) {
                while (!stack.isEmpty()) {
                    int num = 0;
                    if (stack.peek() == chars[i + 1]) {
                        num++;
                    }
                    if (num < 3) {
                        stack.push(chars[i + 1]);
                    } else {
                        num = 0;
                    }
                }
            }
            while (!stack.isEmpty()) {

            }


        }

    }
}
