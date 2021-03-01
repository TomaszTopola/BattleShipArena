package me.tomasztopola.clients.tomasztopola;

import me.tomasztopola.api.BattleShipClient;
import me.tomasztopola.utils.Location;

import java.util.Random;

public class NewHope implements BattleShipClient{

    private int floatingShips;
    Random r = new Random();

    public NewHope(int floatingShips){
        this.floatingShips = floatingShips;
    }

    @Override
    public int getFloatingShips() {
        //TODO
        return floatingShips;
    }

    @Override
    public void receiveAttack(Location target) {
        floatingShips -= 1;
        //TODO
    }

    @Override
    public Location attack() {
        //TODO
        return null;
    }

    @Override
    public String getBotName() {
        return new String(this.getClass().getName());
    }
}
