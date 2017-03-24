package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by richa on 3/23/17.
 *
 * Given numRows, generate the first numRows of Pascal's triangle.
 */
public class PascalsTriangle {
    public class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            if(numRows == 0){
                return list;
            }

            List<Integer> l = new ArrayList<Integer>();
            l.add(1);
            list.add(l);

            int num = 1;
            while(num < numRows){
                List<Integer> newList = new ArrayList<Integer>();
                newList.add(1);

                List<Integer> last = list.get(list.size() - 1);
                for(int i = 1; i < last.size(); i++){
                    newList.add(last.get(i) + last.get(i - 1));
                }
                newList.add(1);
                list.add(newList);

                num++;
            }

            return list;
        }
    }
}
