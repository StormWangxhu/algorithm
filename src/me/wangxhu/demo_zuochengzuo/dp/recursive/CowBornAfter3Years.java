package me.wangxhu.demo_zuochengzuo.dp.recursive;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-08 19:46
 * @Email: StormWangxhu@163.com
 * @Description: 母牛每年生一只母牛，新出生的母牛成长三年后也能每年生一只母牛，假设牛不会死，求N年后母牛的数量
 * 递推公式：F（N）=F（N-1）+F（N-3）
 */
public class CowBornAfter3Years {

    public int cowBorn(int n) {
        if (n <= 4) {
            return n;
        }
        return cowBorn(n - 1) + cowBorn(n - 3);
    }
}
