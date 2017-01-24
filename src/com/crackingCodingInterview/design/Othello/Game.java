package com.crackingCodingInterview.design.Othello;

/**
 * Created by richa on 1/14/17.
 *
 */
public class Game {

    private Player player1;

    private Player player2;

    private static Game instance;

    private Board board;

    private final int ROWS = 10;

    private final int COLUMNS = 10;

    private Game(){
        board = new Board(ROWS, COLUMNS);
        player1 = new Player(Color.BLACK);
        player2 = new Player(Color.WHITE);
    }

    public static Game getInstance(){
        if(instance == null){
            instance = new Game();
        }
        return instance;
    }

    public Board getBoard(){
        return board;
    }
}
