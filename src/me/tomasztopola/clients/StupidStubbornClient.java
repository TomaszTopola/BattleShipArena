package me.tomasztopola.clients;

import me.tomasztopola.api.BattleShipClient;
import me.tomasztopola.api.ClientData;
import me.tomasztopola.utils.BoardGenerator;
import me.tomasztopola.utils.Location;

public class StupidStubbornClient implements BattleShipClient {

    private final int[][] board;

    public StupidStubbornClient(){
        BoardGenerator boardGenerator = new BoardGenerator();
        boardGenerator.generate();
        board = boardGenerator.getBoard();
    }

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

    @Override
    public void receiveAttack(Location target) {
        board[target.getY()][target.getX()] = 0;
    }

    @Override
    public void attack(ClientData opponent) {
        opponent.attack(new Location(0,0));
    }

    @Override
    public String getBotName() {
        return this.getClass().getName();
    }
}
