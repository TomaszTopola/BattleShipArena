package me.tomasztopola.api;

public interface Contest {

    /**
     * starts battle between given clients
     */
    void run();

    /**
     * @return winner - client who won competition
     */
    BattleShipClient getWinner();
}
