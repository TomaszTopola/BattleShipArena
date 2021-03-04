package me.tomasztopola.utils;

import me.tomasztopola.rules.Rules;

public class Location {

    final private int x;
    final private int y;
    final private int boardSize = Rules.getBoardSize();

    public Location(int x, int y){
        assertRules(x);
        assertRules(y);
        this.x = x;
        this.y = y;
    }

    //assertions
    private void assertRules(int digit){
        assert ( digit >= 0 ) : "Coordinate should have positive value. Got " +  digit;
        assert ( digit < boardSize ) : "Coordinate should be smaller or equal to " + Rules.getBoardSize() + ". Got " + digit;
    }

    //getters
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public Location vector(int x, int y){
        return new Location(
            this.checkIfInBoundsForVector(x+this.x),    //X
            this.checkIfInBoundsForVector(y+this.y)     //Y
        );
    }

    private int checkIfInBoundsForVector(int number){
        if(number < 0 ) return 0;
        else if(number >= boardSize) return boardSize-1;
        else return number;
    }
}
