package me.tomasztopola.api;

import me.tomasztopola.utils.Location;

/**
 * This interface assures you have all required methods for the competition implemented.
 */
public interface BattleShipClient {

    /**
     * Used to get information about client's board and to determine who wins. Opponent may use it to check if it hit
     * the target
     * @return int value of floating ship units
     */
    int getFloatingShips();

    /**
     * Should affect floating ship units.
     * @param target this is where your bombs will fall
     */
    void receiveAttack(Location target);

    /**
     * The most important method. It determines how fast your client defeats its opponent.
     * @param opponent allows to call getFloatingShips()
     * @return Location with target of bombing
     */
    Location attack(ClientData opponent);

    /**
     * We want to know how you named your bot. Go ahead, tell us
     * @return Client's name
     */
    String getBotName();

}
