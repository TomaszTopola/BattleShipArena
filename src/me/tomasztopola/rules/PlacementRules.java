package me.tomasztopola.rules;

public class PlacementRules {

    private final boolean allowSideTouching;
    private final boolean allowCornerTouching;

    PlacementRules(boolean allowSideTouching, boolean allowCornerTouching){
        this.allowCornerTouching = allowCornerTouching;
        this.allowSideTouching = allowSideTouching;
    }

    public boolean getSideTouching(){
        return allowSideTouching;
    }
    public boolean getCornerTouching(){
        return allowCornerTouching;
    }
}
