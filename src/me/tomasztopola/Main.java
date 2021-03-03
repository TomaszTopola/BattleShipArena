package me.tomasztopola;

import me.tomasztopola.clients.JustRandomClient;
import me.tomasztopola.clients.MindfulButStillRandomClient;
import me.tomasztopola.clients.StupidStubbornClient;
import me.tomasztopola.competition.Contest;
import me.tomasztopola.competition.OneVsOne;
import me.tomasztopola.utils.BoardGenerator;

public class Main {

    public static void main(String[] args) {
//        competition();
        oneVsOne();
    }

    private static void competition(){
        Contest contest = new Contest();
    }

    private static void oneVsOne(){
        OneVsOne competition;
        competition = new OneVsOne(new JustRandomClient(), new MindfulButStillRandomClient());
        competition.runBattle();
    }

    private static void testBoardGenerator(){
        BoardGenerator board = new BoardGenerator();
        for(int i=0; i<100; i++){
            System.out.println("Generated board No. " + i);
            board.generate();
            board.print();
        }
    }
}
