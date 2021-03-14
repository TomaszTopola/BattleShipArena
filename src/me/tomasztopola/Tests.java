package me.tomasztopola;

import me.jerzytopola.Gruszka;
import me.tomasztopola.clients.JustRandomClient;
import me.tomasztopola.clients.MindfulButStillRandomClient;
import me.tomasztopola.clients.NotSoSimpleClient;
import me.tomasztopola.rules.ShipsConfig;
import me.tomasztopola.tests.BoardTest;
import me.tomasztopola.tests.TestClient;
import me.tomasztopola.utils.BoardGenerator;

public class Tests {
    public static void main (String[] args){
        testClient();
//        testBoardGenerator();
    }

    private static void testClient(){
        TestClient test = new TestClient(new MindfulButStillRandomClient());
        test.run();
    }

    private static void testBoardGenerator(){
        BoardTest boardTest = new BoardTest(new BoardGenerator(
                new ShipsConfig(new int[]{5,4,3,3,2}),
                10
        ));
        boardTest.run();
    }
}
