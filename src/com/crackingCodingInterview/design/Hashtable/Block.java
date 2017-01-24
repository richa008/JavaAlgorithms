package com.crackingCodingInterview.design.Hashtable;

/**
 * Created by richa on 1/14/17.
 *
 */
public class Block<K, V> {

    private K key;

    private V value;

    public Block(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }
}
