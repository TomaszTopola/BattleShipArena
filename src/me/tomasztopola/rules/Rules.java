package me.tomasztopola.rules;

import me.tomasztopola.api.BattleShipClient;

public class Rules {

    public static int getBoardSize(){
        return 10;
    }

    /**
     * @return set ints, where each one is length of a ship
     */
    public static ShipsConfig getShipsConfig(){
        int[] config = {5, 4, 3, 3, 2};
//        int[] config = {5, 3, 2, 2};
//        int[] config = {4, 3, 3, 2};
//        int[] config = {2, 3, 3, 4};
        return new ShipsConfig(config);
    }

    /**
     * @return PlacementRules object
     */
    public static PlacementRules getPlacementRules(){
        return new PlacementRules(false, false);
//        return new PlacementRules(false, true);
//        return new PlacementRules(true, false);
//        return new PlacementRules(true, true);
    }

    /**
     * Asserts that client fits expectations.
     * @param client - tested bot
     */
    public static void assertClientRules(BattleShipClient client){
        assert Rules.getShipsConfig().getSumOfShips() == client.getFloatingShips() :
                "Client has different amount of ships (" + client.getFloatingShips() + ") than expected (" +
                Rules.getShipsConfig().getSumOfShips() + ")";
    }

    /**
     * Determines if boards should be printed as array or graph
     * @return boolean
     */
    public static boolean printBoardAsArray(){
        return false;
    }
}
