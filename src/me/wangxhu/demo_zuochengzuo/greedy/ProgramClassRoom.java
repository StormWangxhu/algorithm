package me.wangxhu.demo_zuochengzuo.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-07 20:52
 * @Email: StormWangxhu@163.com
 * @Description: 项目在会议室要宣讲，求一个教室可以安排的最多场次
 */
public class ProgramClassRoom {

    /**
     * 每个项目有开始时间，结束时间
     */
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 哪一个项目结束的早
     */
    public static class ProgramComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;//从小到大排序，即升序
        }
    }

    /**
     * 项目安排
     *
     * @param programs 项目数组
     * @param curTime  当前时间
     * @return
     */
    public static int bestArrange(Program[] programs, int curTime) {

        Arrays.sort(programs, new ProgramComparator());//把项目时间最早结束的排在前面，结束晚的排在后面

        int result = 0;//可以安排的项目数
        for (int i = 0; i < programs.length; i++) {
            if (curTime <= programs[i].start) {//此逻辑中了的是可以选择的
                result++;
                curTime = programs[i].end;
            }
        }
        return result;
    }
}
