package com.java.ctci.design.Othello;

/**
 * Created by richa on 1/14/17.
 *
 */
public class Player {

    private Color color;

    public Player(Color c){
        color = c;
    }

    public boolean playPiece(int row, int column){
        return Game.getInstance().getBoard().placeColor(row, column, color);
    }

    public Color getColor(){
        return color;
    }
}
