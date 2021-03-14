package me.tomasztopola.clients;

import me.tomasztopola.api.ClientData;
import me.tomasztopola.api.BattleShipClient;
import me.tomasztopola.rules.Rules;
import me.tomasztopola.utils.BoardGenerator;
import me.tomasztopola.utils.Location;

import java.util.Random;

public class JustRandomClient implements BattleShipClient {

    private final int[][] board;
    private final Random r = new Random();

    public JustRandomClient(){
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
    public Location attack(ClientData opponent) {
        return new Location(r.nextInt(Rules.getBoardSize()), r.nextInt(Rules.getBoardSize()));
    }

    @Override
    public String getBotName() {
        return this.getClass().getName();
    }
}
