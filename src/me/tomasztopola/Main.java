package me.tomasztopola;

import me.tomasztopola.clients.JustRandomClient;
import me.tomasztopola.clients.MindfulButStillRandomClient;
import me.tomasztopola.clients.NotSoSimpleClient;
import me.tomasztopola.clients.StupidStubbornClient;
import me.tomasztopola.competition.Contest;
import me.tomasztopola.competition.OneVsOne;
import me.tomasztopola.rules.ShipsConfig;
import me.tomasztopola.utils.BoardGenerator;
import tests.BoardTest;
import tests.TestClient;

public class Main {

    public static void main(String[] args) {
//        competition();
//        oneVsOne();
        testClient();
//        testBoardGenerator();
    }

    private static void competition(){
        Contest contest = new Contest();
    }

    private static void oneVsOne(){
        OneVsOne competition;
        competition = new OneVsOne(new JustRandomClient(), new NotSoSimpleClient());
        competition.runBattle();
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
