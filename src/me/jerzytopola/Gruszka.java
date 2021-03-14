package me.jerzytopola;

import me.tomasztopola.api.BattleShipClient;
import me.tomasztopola.api.ClientData;
import me.tomasztopola.api.SimpleClient;
import me.tomasztopola.rules.Rules;
import me.tomasztopola.utils.BoardGenerator;
import me.tomasztopola.utils.Location;

import java.util.Random;

public class Gruszka extends SimpleClient {
    Random r = new Random();//liczby losowe
    int[][] boardOfOpponent;

    public Gruszka(){
        boardOfOpponent = new BoardGenerator().generateEmpty();
    }

    @Override
    public void attack(ClientData opponent) {
        int x,y;
        while(true){
            x=r.nextInt(Rules.getBoardSize());
            y=r.nextInt(Rules.getBoardSize());
            if(boardOfOpponent[y][x]==0) break;
        }
        boardOfOpponent[y][x]=1;
        opponent.attack(new Location(x,y));
    }
}
