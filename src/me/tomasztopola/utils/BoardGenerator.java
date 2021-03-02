package me.tomasztopola.utils;

import me.tomasztopola.rules.Rules;
import me.tomasztopola.rules.ShipsConfig;

import java.util.Random;

public class BoardGenerator {

    private final ShipsConfig shipsConfig;
    private final int boardSize;
    private int[][] board;
    private Random r = new Random();

    public BoardGenerator(){
        this.shipsConfig = Rules.getShipsConfig();
        this.boardSize = Rules.getBoardSize();
    }

    public int[][] getBoard(){return board;}

    public void generateEmpty(){
        for (int i=0; i < boardSize; i++){
            for (int j=0; j<boardSize; j++){
                board[i][j] = 0;
            }
        }
    }

    public void receiveAttack(Location target){
        board[target.getX()][target.getY()] = 0;
    }

    private void generate(){ //TODO: method still in development. Change to public when done.
        int[] config = shipsConfig.getShipsList();
        generateEmpty();
        for(int ship : config){
            this.placeShip(ship);
        }
    }


    private void placeShip(int length){
        boolean placed = false;
        while (!placed){
            boolean vertical = r.nextBoolean();
            Location target;
            if (vertical) {
                target = new Location(r.nextInt(11 - length), r.nextInt(10));
                Location checker = target.vector(1, -1);
                for (int i=0; i<3; i++){
                    checkIfAvailable(checker, vertical, length+2);
                    checker = checker.vector(0, 1);
                }
            }else
                target = new Location(r.nextInt(10), r.nextInt(10-length));
        }
    }

    private boolean checkIfAvailable(Location startFrom, boolean vertical, int length){
        int x = startFrom.getX();
        int y = startFrom.getY();
        for(int i=0; i<length; i++){
            if(x+i > 9 || y+i >9) break;
            if(vertical && board[x][y+i] != 0) return false;
            if(!vertical && board[x+i][y] != 0) return false;
        }
        return true;
    }

    public void hardcoded(){
        board = new int[][] {
            {1,0,0,0,0,1,1,1,1,0},
            {1,0,0,0,0,0,0,0,0,0},
            {1,0,0,0,0,0,0,0,0,0},
            {1,0,0,0,0,1,1,1,0,0},
            {1,0,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,1,0,0},
            {0,0,1,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,0,0,0},
        };
    }
}
