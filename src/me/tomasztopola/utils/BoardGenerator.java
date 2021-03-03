package me.tomasztopola.utils;

import me.tomasztopola.rules.PlacementRules;
import me.tomasztopola.rules.Rules;
import me.tomasztopola.rules.ShipsConfig;

import java.util.Arrays;
import java.util.Random;

public class BoardGenerator {

    private final ShipsConfig shipsConfig;
    private final int boardSize;
    private int[][] board;
    private final Random r = new Random();

    public BoardGenerator(){
        this.shipsConfig = Rules.getShipsConfig();
        this.boardSize = Rules.getBoardSize();
    }

    public int[][] getBoard(){
        assert board != null : "Board needs to be generated first. Use generate() or generateEmpty()";
        return board;
    }

    public static int[][] generateEmpty(){
        return new int[][] {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
        };
    }

    public void generate(){
        int[] config = shipsConfig.getShipsList();
        board = generateEmpty();
        for(int ship : config){
            this.placeShip(ship);
        }
    }


    private void placeShip(int length){
        TargetLocation target = findSpace(length);
        for( int i=0; i<length; i++){
            if(target.vertical){
                board[target.getY()+i][target.getX()] = 1;
            }else{
                board[target.getY()][target.getX()+i] = 1;
            }
        }
    }

    private TargetLocation findSpace(int length){
        boolean found = false;
        Location target = null;
        boolean vertical = false;
        while (!found){
            vertical = r.nextBoolean();

            if(vertical) target = new Location(r.nextInt(10), r.nextInt(11 - length));
            else target = new Location(r.nextInt(11-length), r.nextInt(10));

            //actual area where ship will be placed
            if(this.checkIfTaken(target, vertical, length)) continue; //check if there is space for the ship

            PlacementRules placementRules = Rules.getPlacementRules();
            if (!placementRules.getAllowSideTouching()){

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

            if(!placementRules.getAllowCornerTouching()){
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

    private boolean checkIfTaken(Location startFrom, boolean vertical, int length){
        int x = startFrom.getX();
        int y = startFrom.getY();
        for(int i=0; i<length; i++){
            if(x+i > 9 || y+i >9) break;
            if(vertical && board[y+i][x] != 0) return true;
            if(!vertical && board[y][x+i] != 0) return true;
        }
        return false;
    }

    public void print(){
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

    private static class TargetLocation extends Location{
        TargetLocation(int x, int y, boolean vertical){
            super(x,y);
            this.vertical = vertical;
        }
        public boolean vertical;
    }
}
 