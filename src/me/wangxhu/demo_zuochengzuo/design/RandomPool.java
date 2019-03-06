package me.wangxhu.demo_zuochengzuo.design;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: StormWangxhu
 * @Time: 2019-03-06 17:08
 * @Email: StormWangxhu@163.com
 * @Description: 设计RandomPool结构
 * 有三个功能
 * Insert(key):将某个key加入到该结构，做到不重复加入
 * delete(key):将原本在结构中的某个key移除掉
 * getRandom():等概率随机的返回结构中的任何一个key
 */
public class RandomPool<K> {

    private HashMap<K, Integer> keyIndexMap;
    private HashMap<Integer, K> indexKeyMap;
    private int size;

    public RandomPool() {
        keyIndexMap = new HashMap<>();
        indexKeyMap = new HashMap<>();
        size = 0;

    }

    public void insert(K key) {
        keyIndexMap.put(key, size);
        indexKeyMap.put(size, key);
        size++;
    }

    /**
     * 等概率返回
     *
     * @return
     */
    public K getRandom() {
        if (size == 0) {
            return null;
        }
        int index = (int) (Math.random() * size);
        return indexKeyMap.get(index);
    }

    /**
     * 将最后一条记录上的key填充到要删除的那条记录上，然后再把最后那条记录删除
     *
     * @param key
     */
    public void remove(K key) {
        int removeIndex = keyIndexMap.get(key);
        int lastIndex = --size;

        K lastKey = indexKeyMap.get(lastIndex);
        keyIndexMap.put(lastKey, removeIndex);
        indexKeyMap.put(removeIndex, lastKey);

        keyIndexMap.remove(key);
        indexKeyMap.remove(lastIndex);
    }


}
