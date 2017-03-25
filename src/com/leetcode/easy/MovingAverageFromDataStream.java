package com.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by richa on 3/24/17.
 *
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

 For example,
 MovingAverage m = new MovingAverage(3);
 m.next(1) = 1
 m.next(10) = (1 + 10) / 2
 m.next(3) = (1 + 10 + 3) / 3
 m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverageFromDataStream {
    public class MovingAverage {

        private int size = 0;
        private int curSize = 0;
        private double sum = 0;
        private Queue<Integer> window;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.size = size;
            window = new LinkedList<Integer>();
        }

        public double next(int val) {
            if(curSize < size){
                window.add(val);
                sum += val;
                curSize++;
            }else{
                int removedVal = window.remove();
                window.add(val);
                sum += val - removedVal;
            }
            return sum/curSize;
        }
    }

/*
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
