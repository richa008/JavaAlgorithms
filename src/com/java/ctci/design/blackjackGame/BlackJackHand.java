package com.java.ctci.design.BlackjackGame;

import java.util.ArrayList;

/**
 * Created by richa on 1/12/17.
 *
 */
public class BlackJackHand extends Hand{

    /**
     *  Ace can be 1 or 13. So there can be different possible scores
     */
    public ArrayList<Integer> possibleScores(){
        return null;
    }

    public boolean isGameWon(){
        return false;
    }

    public boolean isGameLost(){
        return false;
    }

    public boolean isScore21(){
        return false;
    }

}
