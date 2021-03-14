package me.tomasztopola.rules;

public class ShipsConfig {
    private final int[] shipsList;
    private int sumOfShips;

    public ShipsConfig(int[] ships){
        this.shipsList = ships;

        assert ships.length > 1 : "Min. ships amount is 2. Got " + ships.length;
        assert ships.length < 7 : "Max. ships amount is 6. Got " + ships.length;

        for( int ship : this.shipsList ) {
            assert ship > 1 : "Min. ship length is 2. Got " + ship;
            assert ship < 6 : "Max. ship length is 5. Got " + ship;

            this.sumOfShips += ship;
        }
    }

    private int calculateMaxShips(int size){
        //TODO
        return 0;
    }

    public int getSumOfShips() {
        return sumOfShips;
    }
    public int[] getShipsList(){
        return shipsList;
    }
}
