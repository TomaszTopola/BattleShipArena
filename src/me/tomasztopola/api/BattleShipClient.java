package me.tomasztopola.api;

import me.tomasztopola.utils.Location;

public interface BattleShipClient {

    int getFloatingShips();
    void receiveAttack(Location target);
    Location attack();
    String getBotName();

}
