package me.tomasztopola.utils;

import me.tomasztopola.rules.Rules;
import me.tomasztopola.rules.ShipsConfig;

public class Board {

    private final ShipsConfig shipsConfig;
    private final int boardSize;
    private int[][] board;

    public Board(){
        this.shipsConfig = Rules.getShipsConfig();
        this.boardSize = Rules.getBoardSize();
        this.generate();
    }

    public void generate(){
        for (int i=0; i < boardSize; i++){
            for (int j=0; j<boardSize; j++){
                board[i][j] = 0;
            }
        }
    }

    public void receiveAttack(Location target){
        board[target.getX()][target.getY()] = 0;
    }

}
