package me.tomasztopola;

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
        TestClient test = new TestClient(new NotSoSimpleClient());
        test.run();
    }

    private static void testBoardGenerator(){
        BoardTest boardTest = new BoardTest(new BoardGenerator(
                new ShipsConfig(new int[]{2,3,}),
                5
        ));
        boardTest.run();
    }
}
