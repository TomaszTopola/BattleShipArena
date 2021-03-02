package me.tomasztopola.utils;

import me.tomasztopola.rules.Rules;

public class Location {

    final private int x;
    final private int y;

    Location(int x, int y){
        assertRules(x);
        assertRules(y);
        this.x = x;
        this.y = y;
    }

    //assertions
    private void assertRules(int digit){
        int boardSize = Rules.getBoardSize();
        assert ( digit > 0 ) : "Coordinate should have positive value";
        assert ( digit<=boardSize ) : "Coordinate should be smaller or equal to Rules.getBoardSize()";
    }

    //getters
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public Location vector(int x, int y){
        x = x+this.x;
        y = y+this.y;
        if(x < 0) x = 0;
        else if(x > 9) x = 9;
        if(y < 0 ) y = 0;
        else if(y < 9) y = 9;
        return new Location(x, y);
    }
}
