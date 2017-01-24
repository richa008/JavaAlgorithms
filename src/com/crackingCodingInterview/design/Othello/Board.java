package com.crackingCodingInterview.design.Othello;

/**
 * Created by richa on 1/14/17.
 *
 */
public class Board {

    private Piece pieces[][];

    private int blackCount;

    private int whiteCount;

    public Board(int row, int column){
        pieces = new Piece[row][column];
    }

    public int getScoreForColor(Color c){
        if(c == Color.BLACK){
            return blackCount;
        }
        return whiteCount;
    }

    public void updateScore(Color newColor, int newPieces){

    }

    public boolean placeColor(int row, int column, Color color){
        return true;
    }
}
