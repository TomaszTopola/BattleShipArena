package me.tomasztopola.rules;

import me.tomasztopola.api.BattleShipClient;

public class Rules {

    public static int getBoardSize(){
        return 10;
    }

    public static ShipsConfig getShipsConfig(){
        int[] config = {5, 4, 3, 3, 2};
//        int[] config = {5, 3, 2, 2};
//        int[] config = {4, 3, 3, 2};
//        int[] config = {2, 3, 3, 4};
        return new ShipsConfig(config);
    }

    public static void assertClientRules(BattleShipClient client){
        assert Rules.getShipsConfig().getSumOfShips() == client.getFloatingShips() :
                "Client has different amount of ships (" + client.getFloatingShips() + ") than expected (" +
                Rules.getShipsConfig().getSumOfShips() + ")";
    }
}
