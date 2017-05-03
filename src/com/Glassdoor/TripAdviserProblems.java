package com.Glassdoor;

import com.TreeNode;
import com.model.main.LinkedListNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by richa on 4/8/17.
 *
 */
public class TripAdviserProblems {

    char[] cesearCipher(char array[], int k){
        for(int i = 0; i < array.length; i++){
            int next = ((array[i] - 'a') + k) % 26;
            array[i] = (char)(next + 'a');
        }
        return array;
    }

    /**
     *  Find the second most max number in an array
     * @param array
     * @return
     */
    int getNextMax(int array[]){
        int max = Integer.MIN_VALUE, nextMax = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++){
            if(array[i] > max){
                nextMax = max;
                max = array[i];
            }else if(array[i] > nextMax){
                nextMax = array[i];
            }
        }
        return nextMax;
    }

    LinkedListNode getFibonacciLinkedList(LinkedListNode head){
        LinkedListNode newHead = new LinkedListNode(head.data);
        LinkedListNode cur1 = head, cur2 = newHead;
        int a = 0, b = 1, count = 0;

        while(cur1 != null) {
            int fiboNo = a + b;

            while (count < fiboNo && cur1 != null) {
                cur1 = cur1.next;
                count++;
            }
            if (cur1 != null) {
                cur2.next = new LinkedListNode(cur1.data);
                cur2 = cur2.next;
            }
            b = a;
            a = fiboNo;
        }
        return newHead;
    }

    boolean isBinarySearchTree(TreeNode root){
        return isBinarySearchTreeHelper(root, null, null);
    }

    boolean isBinarySearchTreeHelper(TreeNode node, Integer max, Integer min){
        if(node == null){
            return true;
        }
        if((max != null && node.val > max) || (min != null && node.val < min)){
            return false;
        }

        return isBinarySearchTreeHelper(node.left, node.val, min) && isBinarySearchTreeHelper(node.right, max, node.val);
    }

    public class UpperCaseList implements Iterable<Character>{

        private List<Character> uppercaseList;

        public UpperCaseList(List <Character> list){
            uppercaseList = new ArrayList<Character>();
            for(int i = 0; i < list.size(); i++){
                Character c = list.get(i);
                if(!Character.isLowerCase(c)){
                    uppercaseList.add(c);
                }
            }
        }

        @Override
        public Iterator<Character> iterator(){
            Iterator<Character> it = new Iterator<Character>(){

                private int index = 0;

                @Override
                public boolean hasNext(){
                    return (index < uppercaseList.size());
                }

                @Override
                public Character next(){
                    Character c = uppercaseList.get(index);
                    index++;
                    return c;
                }
            };
            return it;
        }
    }

    public static void main(String args[]){
        TripAdviserProblems t = new TripAdviserProblems();
        char array[] = {'x', 'f', 'z'};
        System.out.println(t.cesearCipher(array, -3));
    }
}
