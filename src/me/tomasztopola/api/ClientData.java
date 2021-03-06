package me.tomasztopola.api;

import me.tomasztopola.utils.Location;

/**
 * provides getFloatingShips to opponent
 */
public class ClientData {
    BattleShipClient client;
    public ClientData(BattleShipClient client){
        this.client = client;
    }
    public int getFloatingShips(){
        return client.getFloatingShips();
    }
}
