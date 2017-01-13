package com.java.ctci.design.BlackjackGame;

import java.util.ArrayList;

/**
 * Created by richa on 1/12/17.
 *
 */
public class Deck {

    private ArrayList<Card> cards;

    private int dealtIndex;

    /**
     *  Shuffle the cards
     */
    public void shuffle(){

    }

    /**
     *  Deals a card
     * @return - Card
     */
    public Card dealCard(){
        return cards.get(0);
    }

    /**
     *  Deals a Hand
     * @return - Hand
     */
    public Hand dealHand(){
        return null;
    }

}
