package me.tomasztopola.api;

import me.tomasztopola.utils.Location;

/**
 * This interface assures you have all required methods for the competition implemented.
 */
public interface BattleShipClient {

    /**
     * Gets information about client's board and to determine who wins. Opponent may use it to check if it hit
     * the target
     * @return int value of floating ship units
     */
    int getFloatingShips();

    /**
     * Changes floating ship units amount. Here your bot receives opponent's target and takes appropriate
     * action on its board.
     * @param target this is where your bombs will fall
     */
    void receiveAttack(Location target);

    /**
     * Finds and attacks opponent.
     * Must end with <code>opponent.attack();</code>
     * @param opponent ClientData API of opponent
     */
    void attack(ClientData opponent);

    /**
     * Tells the Competition how you named your bot
     * @return Client's name
     */
    String getBotName();

}
