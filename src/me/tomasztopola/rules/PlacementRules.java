package me.tomasztopola.rules;

public class PlacementRules {

    private final boolean allowSideTouching;
    private final boolean allowCornerTouching;

    PlacementRules(boolean allowSideTouching, boolean allowCornerTouching){
        this.allowCornerTouching = allowCornerTouching;
        this.allowSideTouching = allowSideTouching;
    }

    public boolean getAllowSideTouching(){
        return allowSideTouching;
    }
    public boolean getAllowCornerTouching(){
        return allowCornerTouching;
    }
}
