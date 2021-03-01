package me.tomasztopola.rules;

public class ShipsConfig {
    private int[] shipsList;
    private int sumOfShips;

    ShipsConfig(int ships[]){
        this.shipsList = ships;

        for( int ship : this.shipsList ){
            this.sumOfShips += ship;
        }
    }

    public int getSumOfShips() {
        return sumOfShips;
    }
    public int[] getShipsList(){
        return shipsList;
    }
}
