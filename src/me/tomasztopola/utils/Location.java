package me.tomasztopola.utils;

import me.tomasztopola.rules.Rules;

public class Location {

    private int x;
    private int y;

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

    //setters
    public void setX(int x){
        assertRules(x);
        this.x = x;
    }
    public void setY(int y){
        assertRules(y);
        this.y = y;
    }
}
