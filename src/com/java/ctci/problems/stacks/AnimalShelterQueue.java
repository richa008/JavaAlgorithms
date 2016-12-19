package com.java.ctci.problems.stacks;

import java.util.LinkedList;

/**
 * Created by richa on 12/18/16.
 *
 */
public class AnimalShelterQueue {

    private LinkedList<Animal> dogsList = new LinkedList<Animal>();
    private LinkedList<Animal> catsList = new LinkedList<Animal>();
    private int animalNo = 0;

    public void enqueueAnimal(Animal animal){
        if(animal instanceof Dog){
            enqueueDogs(animal);
        }else if(animal instanceof Cat){
            enqueueCats(animal);
        }
    }

    public void enqueueDogs(Animal dog){
        dogsList.addLast(dog);
        dog.setAnimalNo(animalNo);
        animalNo++;
    }

    public void enqueueCats(Animal cat){
        catsList.addLast(cat);
        cat.setAnimalNo(animalNo);
        animalNo++;
    }

    public Animal dequeueAnimal(){

        if(dogsList.isEmpty()){
            return dequeueCats();
        }else if(catsList.isEmpty()){
            return dequeueDogs();
        }

        Animal lastDog = dogsList.peek();
        Animal lastCat = catsList.peek();

        if(lastCat.getAnimalNo() < lastDog.getAnimalNo()){
            return dequeueDogs();
        }
        return dequeueCats();
    }

    public Animal dequeueDogs(){
        return dogsList.poll();
    }

    public Animal dequeueCats(){
        return catsList.poll();
    }
}

