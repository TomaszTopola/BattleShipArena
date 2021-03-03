package me.tomasztopola.clients;

import me.tomasztopola.api.BattleShipClient;
import me.tomasztopola.api.ClientData;
import me.tomasztopola.utils.BoardGenerator;
import me.tomasztopola.utils.Location;

import java.util.Random;

public class MindfulButStillRandomClient implements BattleShipClient {

    private final int[][] board;
    private final int[][] boardOfOpponent;
    private final Random r = new Random();

    public MindfulButStillRandomClient(){
        BoardGenerator boardGenerator = new BoardGenerator();
        boardGenerator.generate();
        board = boardGenerator.getBoard();
        this.boardOfOpponent = BoardGenerator.generateEmpty();
    }

    @Override
    public Location attack(ClientData opponent) {
        Location target;
        do {
            target = new Location(r.nextInt(10), r.nextInt(10));
        } while (boardOfOpponent[target.getY()][target.getX()] != 0);

        boardOfOpponent[target.getY()][target.getX()] = 1;
        return target;
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
    public String getBotName() {
        return this.getClass().getName();
    }
}

