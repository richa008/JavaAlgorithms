package com.java.ctci.design.Hashtable;

import java.util.LinkedList;

/**
 * Created by richa on 1/14/17.
 *
 */
public class Hashtable<K, V> {

    private final int SIZE = 10;

    private LinkedList<Block<K, V>> items[];

    public Hashtable(){
        items = (LinkedList<Block<K, V>>[]) new LinkedList[SIZE];
    }

    private int hashCodeOfKey(K key){
        return key.toString().length() % items.length;
    }

    public void put(K key, V value){
        int x = hashCodeOfKey(key);
        if(items[x] == null){
            items[x] = new LinkedList<Block<K, V>>();
        }else{
            LinkedList<Block<K, V>> collided = items[x];
            for(Block<K, V> b : collided){
                if(b.getKey().equals(key)){
                    collided.remove(b);
                    break;
                }
            }

            Block<K, V> block = new Block<K, V>(key, value);
            collided.add(block);
        }
    }

    public V get(K key){
        int x = hashCodeOfKey(key);
        if(items[x] == null){
            return null;
        }
        LinkedList<Block<K, V>> collided = items[x];

        for(Block<K, V> b : collided){
            if (b.getKey().equals(key)) {
                return b.getValue();
            }
        }
        return null;
    }
}
