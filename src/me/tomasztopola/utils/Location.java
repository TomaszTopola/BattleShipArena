package me.tomasztopola.utils;

import me.tomasztopola.rules.Rules;

public class Location {

    final private int x;
    final private int y;

    public Location(int x, int y){
        assertRules(x);
        assertRules(y);
        this.x = x;
        this.y = y;
    }

    //assertions
    private void assertRules(int digit){
        int boardSize = Rules.getBoardSize();
        assert ( digit >= 0 ) : "Coordinate should have positive value. Got " +  digit;
        assert ( digit<=boardSize ) : "Coordinate should be smaller or equal to " + Rules.getBoardSize() + ". Got " + digit;
    }

    //getters
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public Location vector(int x, int y){
        int returnX = x+this.x;
        int returnY = y+this.y;

        if(returnX < 0) returnX = 0;
        else if(returnX > 9) returnX = 9;

        if(returnY < 0 ) returnY = 0;
        else if(returnY > 9) returnY = 9;

        return new Location(returnX, returnY);
    }
}
