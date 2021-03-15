package me.tomasztopola.api;

import me.tomasztopola.utils.Location;

/**
 * provides getFloatingShips to opponent
 */
public class ClientData {
    private BattleShipClient client;
    private boolean hasntAttacked = true;

    public ClientData(BattleShipClient client){
        this.client = client;
    }

    public int getFloatingShips(){
        return client.getFloatingShips();
    }

    public void attack(Location target){
        assert hasntAttacked : "Multiple attack called. You can send coordinates only once in round.";
        client.receiveAttack(target);
        hasntAttacked = false;
    }
}
