package me.tomasztopola.api;

import me.tomasztopola.utils.Location;

public interface BattleShipClient {

    public int getFloatingShips();
    public void receiveAttack(Location target);
    public Location attack();
    public String getBotName();

}
