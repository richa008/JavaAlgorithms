package com.java.ctci.design.blackjackGame;

import java.util.ArrayList;

/**
 * Created by richa on 1/12/17.
 *
 */
public class Hand {

    ArrayList<Card> cards;

    int count;

    public void removeCard(Card card){

    }

    /**
     *  Score of the cards
     * @return - addition of all values of the cards in the Hand
     */
    public Integer score(){
        int score = 0;
        for(Card card: cards){
            score = score + card.value;
        }
        return score;
    }
}
