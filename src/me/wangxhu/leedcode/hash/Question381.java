package me.wangxhu.leedcode.hash;

import java.util.*;

/**
 * <p>Created on 18-12-10</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 */
public class Question381 {

    static class RandomizedCollection {

        private Map<Integer, Set<Integer>> map;
        private List<Integer> list;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean status = map.containsKey(val);
            Set<Integer> set = map.get(val);
            if (set == null) {
                set = new HashSet<>();
                map.put(val, set);
            }
            list.add(val);
            set.add(list.size() - 1);
            return !status;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            if (map.containsKey(val)) {
                Set<Integer> set = map.get(val);
                int valIndex = set.iterator().next();
                set.remove(valIndex);
                if (set.isEmpty()) {
                    map.remove(val);
                }
                if (valIndex == list.size() - 1) { //if this is the last index then simply remove it
                    list.remove(list.size() - 1);
                } else {
                    int lastEle = list.get(list.size() - 1);
                    map.get(lastEle).remove(list.size() - 1);
                    map.get(lastEle).add(valIndex);
                    list.set(valIndex, lastEle);
                    list.remove(list.size() - 1);
                }
                return true;
            } else return false;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            Random random = new Random();
            return list.get(random.nextInt(list.size()));
        }

    }
}
