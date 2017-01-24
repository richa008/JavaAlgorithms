package com.crackingCodingInterview.problems.stacks;

/**
 * Created by richa on 12/18/16.
 *
 */
public abstract class Animal {

    private int animalNo;
    private String name;

    public Animal(String name){
        this.name = name;
    }


    public int getAnimalNo() {
        return animalNo;
    }

    public void setAnimalNo(int animalNo) {
        this.animalNo = animalNo;
    }
}
