package me.tomasztopola.api;

import me.tomasztopola.utils.Location;

/**
 * Provides required actions to competitors. Prevents from unauthorized method calls by competitors.
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

    /**
     * Must be called once in round by each competitor. Calls BattleShipClient.receiveAttack().
     * @see me.tomasztopola.api.BattleShipClient#receiveAttack(Location)
     * @param target location with aim coordinates passed to opponent.
     */
    public void attack(Location target){
        assert hasntAttacked : "Multiple attack called. You can send coordinates only once in round.";
        client.receiveAttack(target);
        hasntAttacked = false;
    }
}
