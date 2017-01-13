package com.java.ctci.design.BlackjackGame;

/**
 * Created by richa on 1/12/17.
 *
 */
public class BlackJackCard extends Card{

    public Integer getBlackJackValue(){
        if(this.value > 11 && this.value < 13) {
            return 10;
        }
        return this.value;
    }
}
