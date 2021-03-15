package me.tomasztopola.newhope;

import me.tomasztopola.api.ClientData;
import me.tomasztopola.api.SimpleClient;
import me.tomasztopola.rules.Rules;
import me.tomasztopola.utils.BoardGenerator;
import me.tomasztopola.utils.Location;

import java.util.Random;

/**
 * My version of BattleShipClient.
 * @author Tomasz Topoła
 * @version 1.0.0.
 */
public class NewHope extends SimpleClient {

    private final Random r = new Random();
    /**
     * Stores information about places where
     */
    private int[][] boardOfOpponent = new BoardGenerator().generateEmpty();

    public NewHope(){}


    /**
     * Finds and attacks opponent.
     * Must end with <code>opponent.attack();</code>
     * @param opponent ClientData API of opponent
     */
    @Override
    public void attack(ClientData opponent) {
        Location target;
        do{
            target = Location.random();
        }while(boardOfOpponent[target.getY()][target.getX()] != 0);
        boardOfOpponent[target.getY()][target.getX()] = 1;
        opponent.attack(target);
    }
}
