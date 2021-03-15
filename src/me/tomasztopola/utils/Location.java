package me.tomasztopola.utils;

import me.tomasztopola.rules.Rules;

import java.util.Random;

/**
 * Stores location as 2-dimensional coordinates of x and y
 */
public class Location {

    final private int x;
    final private int y;
    final private int boardSize = Rules.getBoardSize();

    /**
     * using this you make sure your coordinates fit within game rules
     * @param x coordinate on x axis
     * @param y coordinate on y axis
     */
    public Location(int x, int y){
        assertRules(x);
        assertRules(y);
        this.x = x;
        this.y = y;
    }

    /**
     * X coordinate getter
     * @return value of X coordinate
     */
    public int getX(){
        return this.x;
    }

    /**
     * Y coordinate getter
     * @return value of Y coordinate
     */
    public int getY(){
        return this.y;
    }

    /**
     * Makes sure your new coordinates fit in the board
     * @param x vector of x
     * @param y vector of y
     * @return Location translated with given vector
     */
    public Location vector(int x, int y){
        return new Location(
            this.checkIfInBoundsForVector(x+this.x),    //X
            this.checkIfInBoundsForVector(y+this.y)     //Y
        );
    }

    /**
     * Generates new random Location within board bounds.
     * @return new Location(randomX, randomY)
     */
    public static Location random(){
        return new Location(
                new Random().nextInt(Rules.getBoardSize()),
                new Random().nextInt(Rules.getBoardSize())
        );
    }

    private int checkIfInBoundsForVector(int number){
        if(number < 0 ) return 0;
        else if(number >= boardSize) return boardSize-1;
        else return number;
    }

    //assertions
    private void assertRules(int digit){
        assert ( digit >= 0 ) : "Coordinate should have positive value. Got " +  digit;
        assert ( digit < boardSize ) : "Coordinate should be smaller or equal to " + Rules.getBoardSize() + ". Got " + digit;
    }
}
