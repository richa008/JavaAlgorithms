package com.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Created by richa on 4/30/17.
 */

public class LFUCache {

    HashMap<Integer, Integer> valuesMap;
    HashMap<Integer, Integer> freqMap;
    HashMap<Integer, LinkedHashSet<Integer>> keysMap; // stores keys that have the same frequencies
    int capacity = 0;
    int min = -1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        valuesMap = new HashMap<Integer, Integer>();
        freqMap = new HashMap<Integer, Integer>();
        keysMap = new HashMap<Integer, LinkedHashSet<Integer>>();
        keysMap.put(1, new LinkedHashSet<Integer>());
    }

    public int get(int key) {
        if (!valuesMap.containsKey(key)) {
            return -1;
        }
        int value = valuesMap.get(key);
        int freq = freqMap.get(key);
        freqMap.put(key, freq + 1);
        keysMap.get(freq).remove(key);
        if (freq == min && keysMap.get(freq).size() == 0) {
            min++;
        }
        if (!keysMap.containsKey(freq + 1)) {
            keysMap.put(freq + 1, new LinkedHashSet<Integer>());
        }
        keysMap.get(freq + 1).add(key);

        return value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (valuesMap.containsKey(key)) {
            valuesMap.put(key, value);
            get(key);
            return;
        } else if (valuesMap.size() >= capacity) {
            int removeKey = keysMap.get(min).iterator().next();
            keysMap.get(min).remove(removeKey);
            valuesMap.remove(removeKey);
            freqMap.remove(removeKey);
        }
        valuesMap.put(key, value);
        freqMap.put(key, 1);
        min = 1;
        keysMap.get(min).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

