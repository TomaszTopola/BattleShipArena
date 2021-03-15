package me.tomasztopola.api;

import me.tomasztopola.utils.BoardGenerator;
import me.tomasztopola.utils.Location;

import java.util.Random;

/**
 * Simplified version of BattleShipClient that implements methods that in most cases are obvious.
 * Best choice for beginners.
 */
public abstract class SimpleClient implements BattleShipClient{

    protected final int[][] board;

    public SimpleClient(){
        BoardGenerator boardGenerator = new BoardGenerator();
        boardGenerator.generate();
        board = boardGenerator.getBoard();
    }
    /**
     * Gets information about client's board and to determine who wins. Opponent may use it to check if it hit
     * the target
     * @return int value of floating ship units
     */
    @Override
    public int getFloatingShips() {
        int floatingShips = 0;
        for(int[] row : board){
            for(int ship : row){
                floatingShips += ship;
            }
        }
        return floatingShips;
    }
    /**
     * Changes floating ship units amount. Here your bot receives opponent's target and takes appropriate
     * action on its board.
     * @param target this is where your bombs will fall
     */
    @Override
    public void receiveAttack(Location target) {
        board[target.getY()][target.getX()] = 0;
    }
    /**
     * Tells Competition how you named your bot
     * @return Client's name
     */
    @Override
    public String getBotName() {
        return this.getClass().getName();
    }
    /**
     * Finds and attacks opponent.
     * Must end with <code>opponent.attack();</code>
     * @param opponent ClientData API of opponent
     */
    @Override
    public abstract void attack(ClientData opponent);
}
