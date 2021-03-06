package me.tomasztopola.utils;

import me.tomasztopola.rules.PlacementRules;
import me.tomasztopola.rules.Rules;
import me.tomasztopola.rules.ShipsConfig;

import java.util.Arrays;
import java.util.Random;

/**
 * Generates board which fits game rules. Then returns it as int[][], where 0 means empty space and 1 ship unit
 */
public class BoardGenerator {

    private final ShipsConfig shipsConfig;
    private final int boardSize;
    private int[][] board;
    private final Random r = new Random();

    /**
     * Use this constructor to generate according to existing game rules
     */
    public BoardGenerator(){
        this.shipsConfig = Rules.getShipsConfig();
        this.boardSize = Rules.getBoardSize();
    }

    /**
     * Constructor for custom board size and ships config
     * @param shipsConfig tells how many boats of which type should be generated
     * @param boardSize size of the square board
     */
    public BoardGenerator(ShipsConfig shipsConfig, int boardSize){
        this.shipsConfig = shipsConfig;
        this.boardSize = boardSize;
    }

    /**
     * @return board as int[][]
     */
    public int[][] getBoard(){
        assert board != null : "Board needs to be generated first. Use generate() or generateEmpty()";
        return board;
    }

    /**
     *  generates empty board (useful for keeping track on your attacks)
     * @return board as int[][]
     */
    public int[][] generateEmpty(){
        int[][] myBoard = new int[this.boardSize][this.boardSize];
        for(int x=0; x<this.boardSize; x++){
            for (int y=0; y<this.boardSize; y++){
                myBoard[x][y] = 0;
            }
        }
        return myBoard;
    }

    /**
     * Generates board according to the rules. You may extract it later using getBoard()
     */
    public void generate(){
        int[] config = shipsConfig.getShipsList();
        board = generateEmpty();
        for(int ship : config){
            TargetLocation target = findSpace(ship);
            for( int i=0; i<ship; i++){
                if(target.vertical) board[target.getY()+i][target.getX()] = 1;
                else board[target.getY()][target.getX()+i] = 1;
            }
        }
    }

    /**
     * Finds spot with free space for the ship.
     * @param length length of the ship
     * @return Location with additional parameter - vertical
     */
    private TargetLocation findSpace(int length) {
        boolean found = false;
        Location target = null;
        boolean vertical = false;
        while (!found){
            vertical = r.nextBoolean();

            if(vertical) target = new Location(r.nextInt(boardSize), r.nextInt(boardSize+1 - length));
            else target = new Location(r.nextInt(boardSize+1-length), r.nextInt(boardSize));

            //actual area where ship will be placed
            if(this.checkIfTaken(target, vertical, length)) continue; //check if there is space for the ship

            PlacementRules placementRules = Rules.getPlacementRules();
            if (!placementRules.getAllowSideTouching()) {

                //sides before and after ship
                if(vertical){
                    if(this.checkIfTaken(target.vector(0, -1), true, 1)) continue;
                    else if(this.checkIfTaken(target.vector(0,length),true, 1)) continue;
                }else{
                    if(this.checkIfTaken(target.vector(-1,0), false, 1)) continue;
                    else if(this.checkIfTaken(target.vector(length,0),false, 1)) continue;
                }

                //sides above and beyond ship
                if(vertical){
                    if(this.checkIfTaken(target.vector(-1,0), true, length)) continue;
                    else if(this.checkIfTaken(target.vector(1, 0), true, length)) continue;
                }else{
                    if(this.checkIfTaken(target.vector(0, -1), false, length)) continue;
                    else if(this.checkIfTaken(target.vector(0, 1), false, length)) continue;
                }
            }

            if(!placementRules.getAllowCornerTouching()) {
                //check corners
                if(vertical){
                    if (this.checkIfTaken(target.vector(-1, -1), true, 1)) continue;
                    else if (this.checkIfTaken(target.vector(1, -1), true, 1)) continue;
                    else if (this.checkIfTaken(target.vector(-1, length), true, 1)) continue;
                    else if (this.checkIfTaken(target.vector(1, length), true, 1)) continue;
                }else{
                    if (this.checkIfTaken(target.vector(-1, -1), false, 1)) continue;
                    else if (this.checkIfTaken(target.vector(-1, 1), false, 1)) continue;
                    else if (this.checkIfTaken(target.vector(length, -1), false, 1)) continue;
                    else if (this.checkIfTaken(target.vector(length, 1), false, 1)) continue;
                }
            }
            found = true;
        }
        return new TargetLocation(target.getX(), target.getY(), vertical);
    }

    /**
     * Checks if given location is taken in a row or column
     * @param startFrom location of first check in the strip
     * @param vertical orientation of the ship
     * @param length length of checked strip
     * @return true if space is free, false if it's taken
     */
    private boolean checkIfTaken(Location startFrom, boolean vertical, int length) {
        int x = startFrom.getX();
        int y = startFrom.getY();
        for(int i=0; i<length; i++){
            if(x+i >= this.boardSize || y+i >= this.boardSize) break;
            if(vertical && board[y+i][x] != 0) return true;
            if(!vertical && board[y][x+i] != 0) return true;
        }
        return false;
    }

    /**
     * Prints board to the console
     */
    public void print() {
        System.out.println();
        if(Rules.printBoardAsArray()) System.out.print(Arrays.deepToString(board).replaceAll("],", "]\n"));
        else{
            for(int y=0; y<this.boardSize; y++){
                for(int x=0; x<this.boardSize; x++){
                    if(board[y][x]==0) System.out.print('~');
                    else System.out.print('■');
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Stores location of ship and its orientation (vertical boolean)
     */
    private static class TargetLocation extends Location {
        TargetLocation(int x, int y, boolean vertical){
            super(x,y);
            this.vertical = vertical;
        }
        final public boolean vertical;
    }
}
 