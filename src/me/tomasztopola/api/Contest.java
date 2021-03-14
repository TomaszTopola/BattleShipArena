package me.tomasztopola.api;

public interface Contest {

    /**
     * starts battle between given clients
     */
    void run();

    /**
     * Adds client to competition.
     * @param client your bot
     */
    void addCompetitor(BattleShipClient client);

    /**
     * @return winner - client who won competition
     */
    BattleShipClient getWinner();
}
