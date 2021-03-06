package me.tomasztopola.tests;

import me.tomasztopola.api.BattleShipClient;
import me.tomasztopola.api.ClientData;
import me.tomasztopola.api.Test;
import me.tomasztopola.clients.StupidStubbornClient;
import me.tomasztopola.rules.Rules;
import me.tomasztopola.utils.BoardGenerator;
import me.tomasztopola.utils.Location;

public class TestClient implements Test {

    private final BattleShipClient client;

    public TestClient(BattleShipClient client){
        assert client != null : "Provided client is null.";
        this.client = client;
    }

    public void run(){
        assert testGetBotName() : "Client returns null string value.";
        System.out.println("Client returned expected value botName");

        assert testAttack1() : "Client has returned null Location from attack() method.";
        System.out.println("Client has passed location test.");

        if(testAttack2())System.out.println("Client has passed attack test.");

        assert testGetFloatingShips() : "Client didn't return expected value of floating ships.";
        System.out.println("Client has returned expected value of floating ships.");

        assert testReceiveAttack() : "After receiving attack on every location available client returned floatingShips != 0";
        System.out.println("Client has passed the attack receiving test.");

        System.out.println("Congratulations! Your client has successfully passed all the tests");
    }

    private boolean testGetBotName(){
        return client.getBotName() != null;
    }

    private boolean testAttack1(){
        for(int i=0; i<100; i++){
            Location target = client.attack(new ClientData(client));
            if(target == null) return false;
        }
        return true;
    }

    private boolean testAttack2(){
        BattleShipClient testBoard = new StupidStubbornClient();
        int maxRounds = (int) Math.pow(Rules.getBoardSize(), 2);
        for(int i=0; true; i++){
            testBoard.receiveAttack(client.attack(new ClientData(testBoard)));
            if(testBoard.getFloatingShips() == 0) break;
            if(i>=maxRounds){
                System.out.println("After " +maxRounds + " rounds client didn't take down enemy.");
                return false;
            }
        }
        return true;
    }

    private boolean testGetFloatingShips() {
        return client.getFloatingShips() == Rules.getShipsConfig().getSumOfShips();
    }

    private boolean testReceiveAttack() {
        for (int x=0; x<Rules.getBoardSize(); x++){
            for (int y=0; y<Rules.getBoardSize(); y++){
                client.receiveAttack(new Location(x,y));
            }
        }
        return client.getFloatingShips() == 0;
    }
}
